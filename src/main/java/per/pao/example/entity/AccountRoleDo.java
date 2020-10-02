package per.pao.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "account_role")
public class AccountRoleDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigserial not null")
    private Long id;

    @Column(name = "account_id", columnDefinition = "bigint")
    private Long accountId;

    @Column(name = "role_id", columnDefinition = "bigint")
    private Long roleId;

    @Column(name = "create_date", columnDefinition = "timestamp")
    private Date createDate;

    @Column(name = "create_by", columnDefinition = "bigint")
    private Long createBy;

    @Column(name = "last_modified_date", columnDefinition = "timestamp")
    private Date lastModifiedDate;

    @Column(name = "last_modified_by", columnDefinition = "bigint")
    private Long lastModifiedBy;
}
