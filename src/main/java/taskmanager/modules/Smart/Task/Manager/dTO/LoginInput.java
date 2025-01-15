package taskmanager.modules.Smart.Task.Manager.dTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@JsonInclude(JsonInclude.Include.NON_DEFAULT)

@Builder
@Data
public class LoginInput {
    private String userName;
    private String password;

}
