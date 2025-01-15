package taskmanager.modules.Smart.Task.Manager.dTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class SignUpInput {
    private String userName;
    private String password;
    private String emailId;
    private long phoneNo;


}
