package taskmanager.modules.Smart.Task.Manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taskmanager.modules.Smart.Task.Manager.entity.AboutEntity;

@Repository
public interface AboutRepository extends JpaRepository<AboutEntity,Long> {


}
