package pers.paopa.springboot.demo.controller.auth.dto;

import lombok.Data;

@Data
public class UserDtoEntity {

    private Integer id;
    private String account;
    private String name;
    private String password;

}
