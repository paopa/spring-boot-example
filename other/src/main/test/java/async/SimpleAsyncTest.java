package async;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import per.pao.example.Application;
import per.pao.example.controller.async.service.SimpleAsyncService;

@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SimpleAsyncTest {

    @Autowired
    private SimpleAsyncService simpleAsyncService;

    @Test
    public void testThread() throws InterruptedException {
        for (int i = 0; i < 200; i++) {
            try {
                simpleAsyncService.execute(i);
            } catch (Exception e) {

            }
        }
        System.out.println("finished");
    }
}
