package pers.paopa.springboot.demo.service.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pers.paopa.springboot.demo.controller.auth.dio.LoginInputEntity;
import pers.paopa.springboot.demo.controller.auth.dto.LoginDtoEntity;
import pers.paopa.springboot.demo.dao.entity.UserDaoEntity;
import pers.paopa.springboot.demo.dao.repository.UserRepository;

import static pers.paopa.springboot.demo.config.security.SecurityConfiguration.*;

@Service("LoginService")
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    public LoginDtoEntity request(LoginInputEntity loginInput) throws Exception {
        UserDaoEntity user = getUserData(loginInput);
        if (user != null) {
            return responseData(user);
        } else {
            throw new Exception("user not exist");
        }
    }

    private LoginDtoEntity responseData(UserDaoEntity user) {
        LoginDtoEntity loginDtoEntity = new LoginDtoEntity();
        String accessToken = createJWT();
        loginDtoEntity.setAccount(user.getName());
        loginDtoEntity.setToken(accessToken);
        return loginDtoEntity;
    }

    private String createJWT() {
        return Jwts.builder()
                .setSubject(ACCESS_SUBJECT)
                .signWith(SignatureAlgorithm.HS512, ACCESS_SIGN.getBytes())
                .compact();

    }

    private UserDaoEntity getUserData(LoginInputEntity loginInput) {
        return userRepository.findByNameAndPassword(loginInput.getName(), loginInput.getPassword());
    }
}
