package guru.springframework.spring5webapp.repository;

import guru.springframework.spring5webapp.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<Alert, Long> {


}
