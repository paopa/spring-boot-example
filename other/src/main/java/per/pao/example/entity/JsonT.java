package per.pao.example.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import per.pao.example.pojo.Input;

import javax.persistence.*;

@Data
@Entity
@Table(name = "json_t")
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class JsonT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Input content;
}
