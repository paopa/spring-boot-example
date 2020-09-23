package per.pao.example.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "test")
public class SimpleDo {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer age;
}
