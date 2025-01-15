package taskmanager.modules.Smart.Task.Manager.service;


import taskmanager.modules.Smart.Task.Manager.dTO.TaskDetailsInput;
import taskmanager.modules.Smart.Task.Manager.dTO.TaskDetailsOutput;

public interface TaskDetailsService {

   TaskDetailsOutput addOrUpdateTask(TaskDetailsInput taskDetailsInput);

}
