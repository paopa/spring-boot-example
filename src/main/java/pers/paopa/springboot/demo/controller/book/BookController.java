package pers.paopa.springboot.demo.controller.book;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pers.paopa.springboot.demo.dao.entity.BookDaoEntity;
import pers.paopa.springboot.demo.dao.repository.BookRepository;

import java.util.List;

@Api(tags = "Book")
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    @ApiOperation(value = "取得書本", notes = "列出所有書本")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/v1/book", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookDaoEntity> getAll() {
        return bookRepository.findAll();
    }

}
