package pers.paopa.springboot.demo.controller.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.paopa.springboot.demo.controller.auth.dio.LoginInputEntity;
import pers.paopa.springboot.demo.controller.auth.dio.RegisterInputEntity;
import pers.paopa.springboot.demo.controller.auth.dto.LoginDtoEntity;
import pers.paopa.springboot.demo.service.auth.LoginService;
import pers.paopa.springboot.demo.service.auth.RegisterService;

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

    //get all user info with auth
}
