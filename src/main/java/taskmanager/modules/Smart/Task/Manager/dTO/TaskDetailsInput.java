package taskmanager.modules.Smart.Task.Manager.dTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
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
    private String notification;


}
