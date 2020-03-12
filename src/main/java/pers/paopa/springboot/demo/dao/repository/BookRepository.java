package pers.paopa.springboot.demo.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pers.paopa.springboot.demo.dao.entity.BookDaoEntity;

@Repository
public interface BookRepository
        extends JpaRepository<BookDaoEntity,Integer> {
}
