package taskmanager.modules.Smart.Task.Manager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor

@Data
@Builder
@Entity
public class TaskDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long taskId;
    private String taskName;
    private Date taskStartdate;
    private Date taskEndDate;
    private int timeRequiredPerDay;
    private String startTime;
    private String endTime;
    private boolean startedOrNot;

}
