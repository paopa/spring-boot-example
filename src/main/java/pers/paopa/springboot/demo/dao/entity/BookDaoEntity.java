package pers.paopa.springboot.demo.dao.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="book")
public class BookDaoEntity {
    @Id
    @GeneratedValue
    private Integer bookid;
    private String name;
    private String author;
}
