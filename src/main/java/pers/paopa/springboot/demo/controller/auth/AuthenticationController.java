package pers.paopa.springboot.demo.controller.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pers.paopa.springboot.demo.controller.auth.dio.LoginInputEntity;
import pers.paopa.springboot.demo.controller.auth.dio.RegisterInputEntity;
import pers.paopa.springboot.demo.controller.auth.dto.LoginDtoEntity;
import pers.paopa.springboot.demo.dao.entity.UserDaoEntity;
import pers.paopa.springboot.demo.service.auth.AllUsersInfoService;
import pers.paopa.springboot.demo.service.auth.LoginService;
import pers.paopa.springboot.demo.service.auth.RegisterService;

import java.util.List;

@RestController
@RequestMapping(value ="/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final RegisterService registerService;

    //create user
    @PostMapping(value = "register")
    public ResponseEntity register(
            @RequestBody RegisterInputEntity registerInputEntity){
        return registerService.request(registerInputEntity);
    }

    private final LoginService loginService;

    //login
    @PostMapping(value = "login")
    public LoginDtoEntity login(
            @RequestBody LoginInputEntity loginInputEntity){
        return loginService.request(loginInputEntity);
    }

    private final AllUsersInfoService allUsersInfoService;

    //get all user info with auth
    @GetMapping(value = "getAllUsers")
    public List<UserDaoEntity> getAllUsers(){
        return allUsersInfoService.request();
    }
}
