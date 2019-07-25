package guru.springframework.spring5webapp.repository;

import guru.springframework.spring5webapp.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
}
