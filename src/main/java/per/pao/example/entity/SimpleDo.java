package per.pao.example.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "test")
public class SimpleDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigserial")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;
}
