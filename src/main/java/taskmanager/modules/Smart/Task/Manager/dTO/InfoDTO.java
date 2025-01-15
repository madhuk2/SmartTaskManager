package taskmanager.modules.Smart.Task.Manager.dTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Builder
@Data
public class InfoDTO {
    private String aboutInfo;
}
