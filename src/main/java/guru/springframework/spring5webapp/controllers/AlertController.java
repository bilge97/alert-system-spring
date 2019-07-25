package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.model.Alert;
import guru.springframework.spring5webapp.service.AlertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")

public class AlertController {
    private AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    private long i =0;

    @GetMapping("/alerts")
    public List<Alert> getAlertList() {

        return alertService.findAll();
    }

    @PostMapping("/alert")
    public Alert postAlert(@Valid @RequestBody Alert alert ) {
        alertService.save(alert);
        return alert;
    }

    //@PostMapping("/alert")
    public Alert postAlert(@Valid @RequestParam(value = "name") String name,
                           @RequestParam(value = "url") String url,
                           @RequestParam(value = "method") String method,
                           @RequestParam(value = "period") Long period) {
        Alert alert =new Alert(name , url , method ,period );
        alertService.save(alert);
        return alert;
    }


    @GetMapping("/alert/{id}")
    public Alert getAlertById(@PathVariable Long id) {

        return alertService.findById(id);

    }

    @DeleteMapping("/alert/{id}")
    public void deleteAlertById(@PathVariable Long id) {
        alertService.deleteAlertById(id);
    }

    @PutMapping("/alert/{id}")
    public ResponseEntity<Alert> updateAlert(@PathVariable(value = "id") Long alertId,
                                             @Valid @RequestBody Alert alertDetails)  {
        Alert alert= alertService.findById(alertId);

        alert.setName(alertDetails.getName());
        alert.setUrl(alertDetails.getUrl());
        alert.setMethod(alertDetails.getMethod());
        alert.setPeriod(alertDetails.getPeriod());
        final Alert updatedAlert = alertService.save(alert);
        return ResponseEntity.ok(updatedAlert);
    }

}
