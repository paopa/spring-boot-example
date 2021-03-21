package per.pao.example.controller.simple.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import per.pao.example.annotation.validation.custom.MyValid;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class CustomDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -8960387841606656942L;

    @MyValid(min = 5,message="custom validation annotation")
    @JsonProperty(value = "name")
    private String name;
}
