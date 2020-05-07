package pers.paopa.springboot.demo.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pers.paopa.springboot.demo.dao.entity.BookDaoEntity;

@RepositoryRestResource
public interface BookRepository extends JpaRepository<BookDaoEntity, Integer> {
}
