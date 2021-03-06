package per.pao.example.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "subtype_test")
public class SubtypeTestDo {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "input")
    private String input;
}
