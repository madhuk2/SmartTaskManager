package taskmanager.modules.Smart.Task.Manager.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taskmanager.modules.Smart.Task.Manager.convertor.TaskDetailsConvertor;
import taskmanager.modules.Smart.Task.Manager.dTO.TaskDetailsInput;
import taskmanager.modules.Smart.Task.Manager.dTO.TaskDetailsOutput;
import taskmanager.modules.Smart.Task.Manager.entity.TaskDetailsEntity;
import taskmanager.modules.Smart.Task.Manager.repository.TaskDetailsRepository;
import taskmanager.modules.Smart.Task.Manager.service.TaskDetailsService;

@Service
public class TaskDetailsServiceImpl implements TaskDetailsService {
    @Autowired
    TaskDetailsRepository taskDetailsRepository;
    @Autowired
    TaskDetailsConvertor taskDetailsConvertor;
    @Override
    public TaskDetailsOutput addOrUpdateTask(TaskDetailsInput newTask) {
        TaskDetailsEntity taskDetailsEntity=taskDetailsConvertor.forward(newTask);
        try
        {
            taskDetailsRepository.save(taskDetailsEntity);
        }
        catch(Exception e)
        {
            return TaskDetailsOutput.builder()
                    .notification("Task Could not be Added")
                    .build();
        }
        return TaskDetailsOutput.builder()
                .notification("Your Task has been added")
                .build();

    }



}
