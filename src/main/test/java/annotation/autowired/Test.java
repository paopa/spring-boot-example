package annotation.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import per.pao.example.Application;
import per.pao.example.annotation.autowired.Base;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Test {

    @Autowired
    private Base a;

    @org.junit.jupiter.api.Test
    public void test() {
        a.printX();
    }
}