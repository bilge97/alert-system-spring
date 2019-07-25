package guru.springframework.spring5webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import guru.springframework.spring5webapp.model.Response;


public interface ResponseRepository extends JpaRepository<Response , Long> {

}
