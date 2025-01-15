package taskmanager.modules.Smart.Task.Manager.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taskmanager.modules.Smart.Task.Manager.convertor.AboutConvertor;
import taskmanager.modules.Smart.Task.Manager.dTO.InfoDTO;
import taskmanager.modules.Smart.Task.Manager.entity.AboutEntity;
import taskmanager.modules.Smart.Task.Manager.repository.AboutRepository;
import taskmanager.modules.Smart.Task.Manager.service.AboutService;
@Service
public class AboutServiceImpl implements AboutService {
    @Autowired
    AboutRepository aboutRepository;
    @Autowired
    AboutConvertor aboutConvertor;
    @Override
    public InfoDTO getDetails() {
        //whenever we will be doing any operation with database then we will use try catch
        AboutEntity aboutEntity;
        try{

             aboutEntity=aboutRepository.findAll().get(0);
        }
        catch(Exception e)
        {
            return InfoDTO.builder()
                    .aboutInfo(e.getMessage())
                    .build();
        }
        return aboutConvertor.backward(aboutEntity);

    }

}
