package taskmanager.modules.Smart.Task.Manager.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api")
public class TestController {
    @GetMapping("test")
   public String testApi()
   {
       return "running";
   }
}
