package taskmanager.modules.Smart.Task.Manager.dTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class SignUpOrLoginOutput {
    private String notification;
}
