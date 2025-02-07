package taskmanager.modules.Smart.Task.Manager.service;


import taskmanager.modules.Smart.Task.Manager.dTO.DailyTaskId;
import taskmanager.modules.Smart.Task.Manager.dTO.TaskDetailsInput;

import java.util.List;

public interface TaskDetailsService {

  

   TaskDetailsInput addOrUpdateTask(TaskDetailsInput taskDetailsInput);

   List<TaskDetailsInput> getAllTasks();

   TaskDetailsInput getTaskById(long taskId);

   TaskDetailsInput deleteTaskById(long taskId);

   TaskDetailsInput toDoTasks(DailyTaskId dailyTaskId);

   DailyTaskId collectDailyTasks();
}
