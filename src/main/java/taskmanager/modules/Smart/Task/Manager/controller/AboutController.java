package taskmanager.modules.Smart.Task.Manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import taskmanager.modules.Smart.Task.Manager.dTO.InfoDTO;
import taskmanager.modules.Smart.Task.Manager.service.AboutService;

@RequestMapping("api/about")
@RestController
public class AboutController {
    @Autowired
    AboutService aboutService;
    @GetMapping("details")
    public InfoDTO details()
    {
        return aboutService.getDetails();
    }


}
