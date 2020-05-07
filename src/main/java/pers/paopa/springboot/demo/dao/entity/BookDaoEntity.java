package pers.paopa.springboot.demo.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="book")
public class BookDaoEntity{
    @Id
    @GeneratedValue
    @Column(name = "bookid")
    private Integer bookId;
    private String name;
    private String author;
}
