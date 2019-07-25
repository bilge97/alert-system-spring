package guru.springframework.spring5webapp.controllers;


import guru.springframework.spring5webapp.model.Login;
import guru.springframework.spring5webapp.service.LoginService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/logins")
    public List<Login> getAlertList() {

        return loginService.findAll();
    }

    @PostMapping("/login")
    public Login postAlert(@Valid @RequestBody Login login) {
        loginService.save(login);
        return login;
    }


    @GetMapping("/login/{id}")
    public Login getAlertById(@PathVariable Long id) {

        return loginService.findById(id);

    }
}
