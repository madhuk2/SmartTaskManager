package taskmanager.modules.Smart.Task.Manager.dTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class SignUpInput {
    private String userName;
    private String password;
    private String emailId;
    private long phoneNo;


}
