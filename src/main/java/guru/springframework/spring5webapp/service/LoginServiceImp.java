package guru.springframework.spring5webapp.service;

import guru.springframework.spring5webapp.model.Login;
import guru.springframework.spring5webapp.repository.LoginRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginServiceImp implements LoginService {

    private LoginRepository loginRepository;



    public LoginServiceImp(LoginRepository loginRepository){
        this.loginRepository = loginRepository;

    }


    @Override
    public List<Login> findAll() {
        return loginRepository.findAll();
    }

    @Override
    public Login save(Login login) {
        return  loginRepository.save(login);
    }

    @Override
    public Login findById(Long id) {
        Optional<Login> result = loginRepository.findById(id);

        return result.get();
    }

}
