package pers.paopa.springboot.demo.controller.auth.dio;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RegisterInputEntity {

    @NotEmpty
    private String name;

    @NotEmpty
    private String password;

    @NotEmpty
    private String email;
}
