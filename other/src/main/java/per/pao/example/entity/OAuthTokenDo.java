package per.pao.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "oauth_token")
public class OAuthTokenDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigserial not null")
    private Long id;

    @Column(name = "username", columnDefinition = "varchar(30) not null")
    private String username;

    @Column(name = "token_id", columnDefinition = "text")
    private String tokenId;

    @Column(name = "refresh_id", columnDefinition = "text")
    private String refreshId;

    @Column(name = "client_id", columnDefinition = "text")
    private String clientId;

    @Column(name = "grant_type", columnDefinition = "text")
    private String grantType;

    @Column(name = "resources_ids", columnDefinition = "text")
    private String resourcesIds;

    @Column(name = "scopes", columnDefinition = "text")
    private String scopes;

    @Column(name = "redirect_uri", columnDefinition = "text")
    private String redirectUri;

    @Column(name = "access_token", columnDefinition = "text")
    private String accessToken;

    @Column(name = "refresh_token", columnDefinition = "text")
    private String refreshToken;

    @Column(name = "refreshed", columnDefinition = "boolean")
    private Boolean refreshed;

    @Column(name = "locked", columnDefinition = "boolean")
    private Boolean locked;

    @Column(name = "authentication", columnDefinition = "text")
    private String authentication;

    @Column(name = "create_date", columnDefinition = "timestamp")
    private Date createDate;

    @Column(name = "create_by", columnDefinition = "bigint")
    private Long createBy;

    @Column(name = "last_modified_date", columnDefinition = "timestamp")
    private Date lastModifiedDate;

    @Column(name = "last_modified_by", columnDefinition = "bigint")
    private Long lastModifiedBy;
}