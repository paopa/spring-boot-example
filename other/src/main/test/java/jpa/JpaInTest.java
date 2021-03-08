package jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import per.pao.example.Application;
import per.pao.example.dao.jpa.SimpleRepository;
import per.pao.example.entity.SimpleDo;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = {Application.class},webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JpaInTest {

    @Autowired
    private SimpleRepository simpleRepository;

    @Test
    public void test() {
        List<Long> list = new ArrayList<>();
        list.add(4L);
        list.add(8L);
        list.add(6L);
        List<SimpleDo> Dos = simpleRepository.findAllByIdIn(list);
    }
}
