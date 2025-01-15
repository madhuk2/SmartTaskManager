package taskmanager.modules.Smart.Task.Manager.dTO;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;
@Builder
@Data

public class TaskDetailsOutput {
    private String notification;
}
