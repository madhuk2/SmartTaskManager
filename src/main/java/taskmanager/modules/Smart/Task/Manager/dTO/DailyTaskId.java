package taskmanager.modules.Smart.Task.Manager.dTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class DailyTaskId {
    private List<Long> tasksToDo;
    private boolean isStartedOrFinished;
}
