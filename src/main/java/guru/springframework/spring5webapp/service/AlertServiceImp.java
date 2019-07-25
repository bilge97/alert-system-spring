package guru.springframework.spring5webapp.service;

import guru.springframework.spring5webapp.model.Alert;
import guru.springframework.spring5webapp.repository.AlertRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertServiceImp implements AlertService {

    private AlertRepository alertRepository;



    public AlertServiceImp(AlertRepository alertRepository){
        this.alertRepository = alertRepository;

    }


    @Override
    public List<Alert> findAll() {
        return alertRepository.findAll();
    }

    @Override
    public Alert save(Alert alert) {
        return  alertRepository.save(alert);
    }

    @Override
    public Alert findById(Long id) {
        Optional<Alert> result = alertRepository.findById(id);

        return result.get();
    }

    @Override
    public void deleteAlertById(Long id){

        alertRepository.deleteById(id);
    }






}
