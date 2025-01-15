package taskmanager.modules.Smart.Task.Manager.service;

import taskmanager.modules.Smart.Task.Manager.dTO.LoginInput;
import taskmanager.modules.Smart.Task.Manager.dTO.SignUpInput;
import taskmanager.modules.Smart.Task.Manager.dTO.SignUpOrLoginOutput;

public interface UserService {
    SignUpOrLoginOutput addOrUpdateUser(SignUpInput newUser);

//    void deleteEmployee(long id);
//    List<Employee> searchEmpByName(String empName);
//    List<Employee> getAllEmp();
//    Employee getEmpById(long id);

    SignUpOrLoginOutput login(LoginInput loginInput);

    void deleteUser(long id);
}
