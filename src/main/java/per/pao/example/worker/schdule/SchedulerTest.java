package per.pao.example.worker.schdule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("schedulerTest")
public class SchedulerTest {

    private final int DELAY = 1_000;

    @Scheduled(initialDelay = DELAY, fixedDelay = DELAY)
    public void test1() throws InterruptedException {
        System.out.println("test1 123");
        Thread.sleep(10000);
    }

    @Scheduled(initialDelay = DELAY, fixedDelay = DELAY)
    public void test2() throws InterruptedException {
        System.out.println("test2 456");
        Thread.sleep(3000);
    }

    @Scheduled(initialDelay = DELAY, fixedDelay = DELAY)
    public void test3() throws InterruptedException {
        System.out.println("test3 789");
        Thread.sleep(1000);
    }
}
