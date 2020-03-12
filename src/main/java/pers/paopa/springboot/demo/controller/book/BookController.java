package pers.paopa.springboot.demo.controller.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pers.paopa.springboot.demo.dao.entity.BookDaoEntity;
import pers.paopa.springboot.demo.dao.repository.BookRepository;

import java.util.List;

@RestController
@RequestMapping(value="/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="/getAll")
    public List<BookDaoEntity> getAll(){
        return bookRepository.findAll();
    }
}
