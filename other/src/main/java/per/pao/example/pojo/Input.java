package per.pao.example.pojo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Input.AInput.class, name = "a"),
        @JsonSubTypes.Type(value = Input.BInput.class, name = "b")
})
public abstract class Input {
    private String type;

    @EqualsAndHashCode(callSuper = true)
    @Data
    @ToString(callSuper = true)
//    @JsonTypeName(value = "a")
    public static class AInput extends Input {
        private String a;
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
//    @JsonTypeName(value = "b")
    public static class BInput extends Input {
        private String b;
    }
}
