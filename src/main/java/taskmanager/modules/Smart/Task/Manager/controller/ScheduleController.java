package taskmanager.modules.Smart.Task.Manager.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import taskmanager.modules.Smart.Task.Manager.dTO.DailyTaskId;
import taskmanager.modules.Smart.Task.Manager.dTO.TaskDetailsInput;
import taskmanager.modules.Smart.Task.Manager.service.TaskDetailsService;

@RequestMapping("api/schedule")
@RestController
public class ScheduleController {
    @Autowired
    TaskDetailsService taskDetailsService;
    @PostMapping("tasksToDo")
    public TaskDetailsInput toDoTasks(@RequestBody DailyTaskId dailyTaskId)
    {
        return taskDetailsService.toDoTasks(dailyTaskId);
    }
//   @PostMapping("fetchTasks")
    @GetMapping("collectTasksToNotify")
   public DailyTaskId collectDailyTasks()
    {
        return taskDetailsService.collectDailyTasks();
    }
}
