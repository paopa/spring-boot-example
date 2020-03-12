package pers.paopa.springboot.demo.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_info")
public class UserDaoEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private String account;
    private String password;
    private String name;
}
