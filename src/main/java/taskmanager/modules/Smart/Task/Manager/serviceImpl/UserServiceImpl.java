package taskmanager.modules.Smart.Task.Manager.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taskmanager.modules.Smart.Task.Manager.convertor.SignUpConvertor;
import taskmanager.modules.Smart.Task.Manager.dTO.LoginInput;
import taskmanager.modules.Smart.Task.Manager.dTO.SignUpInput;
import taskmanager.modules.Smart.Task.Manager.dTO.SignUpOrLoginOutput;
import taskmanager.modules.Smart.Task.Manager.entity.UserEntity;
import taskmanager.modules.Smart.Task.Manager.repository.UserRepository;
import taskmanager.modules.Smart.Task.Manager.service.UserService;
@Service
public class UserServiceImpl implements UserService {
  @Autowired
    UserRepository userRepository;
  @Autowired
    SignUpConvertor signUpConvertor;

    @Override
    public SignUpOrLoginOutput addOrUpdateUser(SignUpInput newUser) {
        UserEntity userEntity=signUpConvertor.forward(newUser);
        try
        {
            userRepository.save(userEntity);
        }
        catch(Exception e)
        {
            System.out.println(e);
           return SignUpOrLoginOutput.builder()
                   .notification("SignUp Failed")
                   .build();
        }
        return SignUpOrLoginOutput.builder()
                .notification("Signup Successfully")
                 .build();



    }

    @Override
    public SignUpOrLoginOutput login(LoginInput loginInput) {
         String userName=loginInput.getUserName();
         String password=loginInput.getPassword();
         LoginInput currUser=userRepository.findByUserName(userName);
         if(currUser==null)
         {
             return SignUpOrLoginOutput.builder()
                     .notification("User Not Found")
                     .build();
         }
         if(currUser.getPassword().equals(password))
         {
             return SignUpOrLoginOutput.builder()
                     .notification("Login  successful")
                     .build();
         }
        return SignUpOrLoginOutput.builder()
                .notification("Either your userName or password is wrong")
                .build();
    }

    @Override
    public void deleteUser(long id) {

    }



}
