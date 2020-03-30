package pers.paopa.springboot.demo.service.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pers.paopa.springboot.demo.controller.auth.dio.RegisterInputEntity;
import pers.paopa.springboot.demo.dao.entity.UserDaoEntity;
import pers.paopa.springboot.demo.dao.repository.UserRepository;

import java.util.Date;


@RequiredArgsConstructor
@Service("RegisterService")
public class RegisterService {

    private final UserRepository userRepository;

    public ResponseEntity request(RegisterInputEntity registerInputEntity) {
        Date now = new Date();
        UserDaoEntity user = new UserDaoEntity();
        user.setPassword(registerInputEntity.getPassword());
        user.setName(registerInputEntity.getName());
        user.setEmail(registerInputEntity.getEmail());
        user.setCreateDate(now);
        user.setUpdateDate(now);
        user.setActive(true);
        user.setCreateBy(4);
        user.setUpdateBy(4);
        userRepository.save(user);
        return null;
    }
}
