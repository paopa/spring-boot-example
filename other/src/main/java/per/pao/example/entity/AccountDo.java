package per.pao.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "account")
public class AccountDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigserial not null")
    private Long id;

    @Column(name = "username", columnDefinition = "varchar(30) not null")
    private String username;

    @Column(name = "password", columnDefinition = "text not null")
    private String password;

    @Column(name = "enabled", columnDefinition = "boolean")
    private Boolean enabled;

    @Column(name = "expired", columnDefinition = "boolean")
    private Boolean expired;

    @Column(name = "locked", columnDefinition = "boolean")
    private Boolean locked;

    @Column(name = "credentials_expired", columnDefinition = "boolean")
    private Boolean credentialsExpired;

    @Column(name = "create_date", columnDefinition = "timestamp")
    private Date createDate;

    @Column(name = "create_by", columnDefinition = "bigint")
    private Long createBy;

    @Column(name = "last_modified_date", columnDefinition = "timestamp")
    private Date lastModifiedDate;

    @Column(name = "last_modified_by", columnDefinition = "bigint")
    private Long lastModifiedBy;
}
