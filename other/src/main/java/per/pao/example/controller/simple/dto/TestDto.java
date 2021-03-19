package per.pao.example.controller.simple.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
public class TestDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -1185901933382883584L;

    @NotNull(message = "name must has value")
    private String name;

    @Min(value= 0)
    private int age;

    @Valid
    private SubTest sub;

    @NotEmpty
    private List<Integer> nums;

    @NotEmpty
    private List<@Valid SubTest> subs;

    @Data
    public static class SubTest{
        @NotNull
        private String sex;
    }
}
