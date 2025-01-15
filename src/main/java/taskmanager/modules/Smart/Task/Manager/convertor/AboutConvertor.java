package taskmanager.modules.Smart.Task.Manager.convertor;

import org.springframework.stereotype.Component;
import taskmanager.modules.Smart.Task.Manager.dTO.InfoDTO;
import taskmanager.modules.Smart.Task.Manager.entity.AboutEntity;

@Component
public class AboutConvertor {
    public AboutEntity forward(InfoDTO infoDTO)
    {
        return AboutEntity.builder()
                .aboutInfo(infoDTO.getAboutInfo())
                .build();
    }
    public InfoDTO backward(AboutEntity aboutEntity)
    {
        return InfoDTO.builder()
                .aboutInfo(aboutEntity.getAboutInfo())
                .build();
    }


}
