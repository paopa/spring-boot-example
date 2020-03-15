package pers.paopa.springboot.demo.service.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.paopa.springboot.demo.dao.entity.UserDaoEntity;
import pers.paopa.springboot.demo.dao.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AllUsersInfoService {

    @Autowired
    private final UserRepository userRepository;

    public List<UserDaoEntity> request(){
        return userRepository.findAll();
    }
}
