package pers.paopa.springboot.demo.controller.auth.dio;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginInputEntity {
    @NotEmpty
    private String account;
    @NotEmpty
    private String password;
}
