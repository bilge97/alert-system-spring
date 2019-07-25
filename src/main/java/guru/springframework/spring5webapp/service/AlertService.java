package guru.springframework.spring5webapp.service;

import guru.springframework.spring5webapp.model.Alert;

import java.util.List;

public interface AlertService {

    public List<Alert> findAll();
    public Alert save(Alert alert);

    public Alert findById(Long id);
    public void deleteAlertById(Long id);
}
