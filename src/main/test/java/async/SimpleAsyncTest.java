package async;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import per.pao.example.Application;
import per.pao.example.controller.async.service.SimpleAsyncService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SimpleAsyncTest {

    @Autowired
    private SimpleAsyncService simpleAsyncService;

    @Test
    public void testThread() throws InterruptedException {
        for (int i = 0; i < 18; i++) {
            simpleAsyncService.executeAsync(i);
        }
        for (int i = 0; i < 18; i++) {
            simpleAsyncService.executeAsyncTwo(i);
        }
    }
}
