package pers.paopa.springboot.demo.service.auth;

import io.jsonwebtoken.Jwts;
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
        String accessToken = createJWT(user);
        loginDtoEntity.setAccount(user.getAccount());
        loginDtoEntity.setToken(accessToken);
        return loginDtoEntity;
    }

    private String createJWT(UserDaoEntity user) {
//        return Jwts.builder()
//                .setSubject()
//                .compact();
        return null;
    }


    private UserDaoEntity getUserData(LoginInputEntity loginInput) {
        return userRepository.findByAccountAndPassword(loginInput.getAccount(), loginInput.getPassword());
    }
}
