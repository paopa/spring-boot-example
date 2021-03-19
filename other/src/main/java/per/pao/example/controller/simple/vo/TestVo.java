package per.pao.example.controller.simple.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class TestVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 8854544912840591206L;

    private final String name;
    private final int age;
    private final String sex;
}
