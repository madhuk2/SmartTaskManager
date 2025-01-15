package taskmanager.modules.Smart.Task.Manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taskmanager.modules.Smart.Task.Manager.dTO.LoginInput;
import taskmanager.modules.Smart.Task.Manager.entity.UserEntity;

import java.beans.JavaBean;
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    LoginInput findByUserName(String userName);
}
