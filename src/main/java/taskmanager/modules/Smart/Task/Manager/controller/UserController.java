package taskmanager.modules.Smart.Task.Manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import taskmanager.modules.Smart.Task.Manager.dTO.LoginInput;
import taskmanager.modules.Smart.Task.Manager.dTO.SignUpInput;
import taskmanager.modules.Smart.Task.Manager.dTO.SignUpOrLoginOutput;
import taskmanager.modules.Smart.Task.Manager.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    UserService userService;
    //whenever  there will be request body then  we will use post mapping
    @PostMapping("addOrUpdate")
    public SignUpOrLoginOutput signUp(@RequestBody SignUpInput signUpInput)
    {
        return userService.addOrUpdateUser(signUpInput);
    }
    @PostMapping("login")
    public SignUpOrLoginOutput login(@RequestBody LoginInput loginInput)
    {
        return userService.login(loginInput);
    }
    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable long id)
    {
        userService.deleteUser(id);
    }
}
