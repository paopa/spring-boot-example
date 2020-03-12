package pers.paopa.springboot.demo.controller.auth.dto;

import lombok.Data;

@Data
public class LoginDtoEntity {

    private String account;
    private String token;
}
