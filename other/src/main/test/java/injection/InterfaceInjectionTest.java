package injection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import per.pao.example.Application;
import per.pao.example.worker.log.ILogWorker;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InterfaceInjectionTest {

    @Autowired
    private ILogWorker consoleWorker;

    @Test
    public void testThread() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            try {
                consoleWorker.print();
            } catch (Exception e) {

            }
        }
        System.out.println("finished");
    }
}
