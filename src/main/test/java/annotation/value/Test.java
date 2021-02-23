package annotation.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import per.pao.example.Application;

@SpringBootTest(
        classes = Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Test {

    @Value("${git.commit.id:na}")
    private String x;

    @org.junit.jupiter.api.Test
    public void test() {
        System.out.println(x);
    }
}
