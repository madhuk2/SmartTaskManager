package taskmanager.modules.Smart.Task.Manager.convertor;

import org.springframework.stereotype.Component;
import taskmanager.modules.Smart.Task.Manager.dTO.SignUpInput;
import taskmanager.modules.Smart.Task.Manager.entity.UserEntity;

@Component
public class SignUpConvertor {
    public UserEntity forward(SignUpInput signUpInput)
    {
       return UserEntity.builder()
               .userName(signUpInput.getUserName())
               .password(signUpInput.getPassword())
               .emailId(signUpInput.getEmailId())
               .phoneNo(signUpInput.getPhoneNo())
               .build();
    }
    public SignUpInput backward(UserEntity userEntity)
    {
        return SignUpInput.builder()
                .userName(userEntity.getUserName())
                .password(userEntity.getPassword())
                .emailId(userEntity.getEmailId())
                .phoneNo(userEntity.getPhoneNo())
                .build();
    }
}
