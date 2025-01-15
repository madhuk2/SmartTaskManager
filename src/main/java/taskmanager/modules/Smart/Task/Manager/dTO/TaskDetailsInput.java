package taskmanager.modules.Smart.Task.Manager.dTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDetailsInput {
    private String taskName;
    private Date taskStartdate;
    private Date taskEndDate;
    private int timeRequiredPerDay;
    private String startTime;
    private String endTime;


}
