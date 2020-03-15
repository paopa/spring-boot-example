package pers.paopa.springboot.demo.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pers.paopa.springboot.demo.dao.entity.UserDaoEntity;

@Repository
public interface UserRepository extends JpaRepository<UserDaoEntity,Integer> {

    UserDaoEntity findByAccountAndPassword(String account, String password);

    UserDaoEntity findByName(String username);
}
