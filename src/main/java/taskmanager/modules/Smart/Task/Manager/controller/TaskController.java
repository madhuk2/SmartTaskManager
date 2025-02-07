package taskmanager.modules.Smart.Task.Manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import taskmanager.modules.Smart.Task.Manager.dTO.TaskDetailsInput;
import taskmanager.modules.Smart.Task.Manager.service.TaskDetailsService;

import java.util.List;

@RequestMapping("api/task")
@RestController
public class TaskController {
    @Autowired
    TaskDetailsService taskDetailsService;
    @PostMapping("addOrUpdateTask")
    public TaskDetailsInput addOrUpdateTask(@RequestBody TaskDetailsInput taskDetailsInput)
    {
        return taskDetailsService.addOrUpdateTask(taskDetailsInput);
    }
    @GetMapping("getAllTasks")
    public List<TaskDetailsInput> getAllTasks()
    {
        return taskDetailsService.getAllTasks();
    }
    @GetMapping("getTaskById")
    public  TaskDetailsInput getTasksById(@Param("taskId") long taskId)
    {
        return taskDetailsService.getTaskById(taskId);
    }
    @DeleteMapping("deleteTaskById")
    public TaskDetailsInput deleteTaskById(@Param("taskId") long taskId)
    {
        return taskDetailsService.deleteTaskById(taskId);
    }



}
