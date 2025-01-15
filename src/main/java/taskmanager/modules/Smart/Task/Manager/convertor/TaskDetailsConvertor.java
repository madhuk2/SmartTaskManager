package taskmanager.modules.Smart.Task.Manager.convertor;

import org.springframework.stereotype.Component;
import taskmanager.modules.Smart.Task.Manager.dTO.TaskDetailsInput;
import taskmanager.modules.Smart.Task.Manager.entity.TaskDetailsEntity;

@Component
public class TaskDetailsConvertor {
    public TaskDetailsEntity forward(TaskDetailsInput taskDetailsInput){
        return TaskDetailsEntity.builder()
                .taskName(taskDetailsInput.getTaskName())
                .taskStartdate(taskDetailsInput.getTaskStartdate())
                .taskEndDate(taskDetailsInput.getTaskEndDate())
                .timeRequiredPerDay(taskDetailsInput.getTimeRequiredPerDay())
                .startTime(taskDetailsInput.getStartTime())
                .endTime(taskDetailsInput.getEndTime())
                .build();

    }
    public TaskDetailsInput backward(TaskDetailsEntity taskDetailsEntity)
    {
        return TaskDetailsInput.builder()
                .taskName(taskDetailsEntity.getTaskName())
                .taskStartdate((taskDetailsEntity.getTaskStartdate()))
                .taskEndDate(taskDetailsEntity.getTaskEndDate())
                .timeRequiredPerDay(taskDetailsEntity.getTimeRequiredPerDay())
                .startTime(taskDetailsEntity.getStartTime())
                .endTime(taskDetailsEntity.getEndTime())
                .build();
    }
}
