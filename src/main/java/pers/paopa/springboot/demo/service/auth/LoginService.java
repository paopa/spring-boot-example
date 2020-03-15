package pers.paopa.springboot.demo.service.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pers.paopa.springboot.demo.controller.auth.dio.LoginInputEntity;
import pers.paopa.springboot.demo.controller.auth.dto.LoginDtoEntity;
import pers.paopa.springboot.demo.dao.entity.UserDaoEntity;
import pers.paopa.springboot.demo.dao.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    public LoginDtoEntity request(LoginInputEntity loginInputEntity) {
        String account = loginInputEntity.getAccount();
        String password = loginInputEntity.getPassword();
        UserDaoEntity user = userRepository.findByAccountAndPassword(account,password);
        LoginDtoEntity loginDtoEntity = new LoginDtoEntity();
        if(user != null) {
            String accessToken = "qweasdzxxc";
            loginDtoEntity.setAccount(account);
            loginDtoEntity.setToken(accessToken);
            return loginDtoEntity;
        }
        return null;
    }
}
