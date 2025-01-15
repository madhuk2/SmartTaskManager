package taskmanager.modules.Smart.Task.Manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import taskmanager.modules.Smart.Task.Manager.dTO.TaskDetailsInput;
import taskmanager.modules.Smart.Task.Manager.dTO.TaskDetailsOutput;
import taskmanager.modules.Smart.Task.Manager.service.TaskDetailsService;

@RequestMapping("api/task")
@RestController
public class TaskController {
    @Autowired
    TaskDetailsService taskDetailsService;
    @PostMapping("addOrUpdateTask")
    public TaskDetailsOutput addOrUpdateTask(@RequestBody TaskDetailsInput taskDetailsInput)
    {
        return taskDetailsService.addOrUpdateTask(taskDetailsInput);
    }
}
