package guru.springframework.spring5webapp.service;

import guru.springframework.spring5webapp.model.Login;

import java.util.List;

public interface LoginService {

    public List<Login> findAll();
    public Login save(Login login);

    public Login findById(Long id);

}
