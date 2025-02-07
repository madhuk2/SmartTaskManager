package taskmanager.modules.Smart.Task.Manager.serviceImpl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taskmanager.modules.Smart.Task.Manager.config.RabbitMQConfig;
import taskmanager.modules.Smart.Task.Manager.convertor.TaskDetailsConvertor;
import taskmanager.modules.Smart.Task.Manager.dTO.DailyTaskId;
import taskmanager.modules.Smart.Task.Manager.dTO.TaskDetailsInput;
import taskmanager.modules.Smart.Task.Manager.entity.TaskDetailsEntity;
import taskmanager.modules.Smart.Task.Manager.repository.TaskDetailsRepository;
import taskmanager.modules.Smart.Task.Manager.service.TaskDetailsService;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class TaskDetailsServiceImpl implements TaskDetailsService {
    @Autowired
    TaskDetailsRepository taskDetailsRepository;
    @Autowired
    TaskDetailsConvertor taskDetailsConvertor;
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public TaskDetailsInput addOrUpdateTask(TaskDetailsInput newTask) {
        TaskDetailsEntity taskDetailsEntity=taskDetailsConvertor.forward(newTask);
        try
        {
            taskDetailsRepository.save(taskDetailsEntity);
        }
        catch(Exception e)
        {
            return TaskDetailsInput.builder()
                    .notification("Task Could not be Added")
                    .build();
        }
        return TaskDetailsInput.builder()
                .notification("Your Task has been added")
                .build();

    }

    @Override
    public List<TaskDetailsInput> getAllTasks() {

        List<TaskDetailsEntity>taskDetailsEntities;
        try
        {
            taskDetailsEntities=taskDetailsRepository.findAll();
        }
        catch (Exception e) {
            return List.of(TaskDetailsInput.builder()
                    .notification(e.getMessage())
                    .build());
        }

           return  taskDetailsEntities.stream()
                   .map(taskDetailsEntity -> taskDetailsConvertor.backward(taskDetailsEntity))
                   .collect(Collectors.toList());



    }

    @Override
    public TaskDetailsInput getTaskById(long taskId) {
        TaskDetailsInput task;
        TaskDetailsEntity taskDetailsEntity;
        try
        {
            taskDetailsEntity=taskDetailsRepository.findById(taskId).get();
        }
        catch (Exception e)
        {
            return  TaskDetailsInput.builder()
                    .notification(e.getMessage())
                    .build();
        }
        return taskDetailsConvertor.backward(taskDetailsEntity);
    }

    @Override
    public TaskDetailsInput deleteTaskById(long taskId)
    {
        try
        {
            taskDetailsRepository.deleteById(taskId);
        }
        catch (Exception e)
        {
            return TaskDetailsInput.builder()
                    .notification(e.getMessage())
                    .build();
        }
        return  TaskDetailsInput.builder()
                .notification("your task has been deleted")
                .build();

    }

    @Override
    public TaskDetailsInput toDoTasks(DailyTaskId dailyTaskId) {
       List<Long>taskIds=dailyTaskId.getTasksToDo();
        taskIds.stream().forEach(id -> {
            try {
                TaskDetailsEntity task = taskDetailsRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found for ID: " + id));
                task.setStartedOrNot(dailyTaskId.isStartedOrFinished());
                taskDetailsRepository.save(task);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage()); // Modify this as per your requirements for handling exceptions
            }
        });


        return TaskDetailsInput.builder()
                .notification("Task status updated")
                .build();
    }

    @Override
    public DailyTaskId collectDailyTasks() {
        List<TaskDetailsEntity>tasks;
        try
        {
            tasks=taskDetailsRepository.findAll();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
//        Map<String, List<Long>>map=new HashMap<>();
        List<Long>tasksToNotify=new ArrayList<>();
        for(TaskDetailsEntity task:tasks)
        {
            boolean status=task.isStartedOrNot();
            Date currDate=new Date();
            Date startDate=task.getTaskStartdate();
            Date endDate=task.getTaskEndDate();
            if(!status&&(currDate.compareTo(startDate) >= 0 && currDate.compareTo(endDate) <= 0))
            {
                tasksToNotify.add(task.getTaskId());
            }
        }
        DailyTaskId dailyTaskId=DailyTaskId.builder()
                .tasksToDo(tasksToNotify)
                .build();
//        map.put("tasks",tasksToNotify);
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME,"routing.key.#",dailyTaskId);

        return dailyTaskId;
    }


}
