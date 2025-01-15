package taskmanager.modules.Smart.Task.Manager.dTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
public class LoginInput {
    private String userName;
    private String password;

}
