package per.pao.practice.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginVo {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
