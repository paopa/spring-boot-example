package async;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import per.pao.example.Application;
import per.pao.example.controller.async.service.SimpleCheckAsyncAliveService;

import static per.pao.example.enums.TimeUnit.Minute;
import static per.pao.example.enums.TimeUnit.Second;

@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SimpleCheckAsyncAliveTest {

    @Autowired
    private SimpleCheckAsyncAliveService simpleCheckAsyncAliveService;

    @Test
    public void testThread() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            try {
                simpleCheckAsyncAliveService.execute();
            } catch (Exception e) {
                throw e;
            }
            Thread.sleep(3 * Second.millis);
        }
        Thread.sleep(30 * Minute.millis);
        System.out.println("finished");
    }
}
