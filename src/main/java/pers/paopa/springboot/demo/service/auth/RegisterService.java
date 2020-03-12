package pers.paopa.springboot.demo.service.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pers.paopa.springboot.demo.controller.auth.dio.RegisterInputEntity;
import pers.paopa.springboot.demo.dao.entity.UserDaoEntity;
import pers.paopa.springboot.demo.dao.repository.UserRepository;


@RequiredArgsConstructor
@Service
public class RegisterService {

    private final UserRepository userRepository;

    public ResponseEntity request(RegisterInputEntity registerInputEntity) {
        UserDaoEntity user = new UserDaoEntity();
        user.setAccount(registerInputEntity.getAccount());
        user.setPassword(registerInputEntity.getPassword());
        user.setName(registerInputEntity.getName());
        userRepository.save(user);
        return null;
    }
}
