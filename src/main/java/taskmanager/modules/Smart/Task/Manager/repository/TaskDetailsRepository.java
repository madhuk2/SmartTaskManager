package taskmanager.modules.Smart.Task.Manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taskmanager.modules.Smart.Task.Manager.entity.TaskDetailsEntity;

@Repository
public interface TaskDetailsRepository extends JpaRepository<TaskDetailsEntity,Long> {

}
