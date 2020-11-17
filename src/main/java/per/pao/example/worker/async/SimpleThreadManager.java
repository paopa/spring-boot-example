package per.pao.example.worker.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component("SimpleThreadManager")
public class SimpleThreadManager {

    private final List<Thread> pool = new ArrayList<>();
    private final int DELAY = 1_000;

    public boolean add(Thread thread) {
        try {
            pool.add(thread);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean remove(Thread thread) {
        try {
            pool.remove(thread);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//    @Scheduled(initialDelay = DELAY, fixedDelay = DELAY)
    public void checkPool() throws InterruptedException {
        log.info("pool count {}", pool.size());
        pool.forEach(thread -> log.info("Thread Name: {} Status {}", thread.getName(), thread.getState()));
    }

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
