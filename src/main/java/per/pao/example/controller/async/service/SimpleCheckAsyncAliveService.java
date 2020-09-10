package per.pao.example.controller.async.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import per.pao.example.worker.async.SimpleThreadManager;

@Slf4j
@RequiredArgsConstructor
@Service("SimpleCheckAsyncAliveService")
public class SimpleCheckAsyncAliveService {

    private final SimpleThreadManager threadManager;

    @Async(value = "simpleAsyncExecutor")
    public void execute() throws InterruptedException {
        log.info("Thread Name: {} Start", Thread.currentThread().getName());
        threadManager.add(Thread.currentThread());
        while (true) {
            if (Integer.MAX_VALUE == 1) break;
        }
        log.info("Thread Name: {} End", Thread.currentThread().getName());
        threadManager.remove(Thread.currentThread());
    }

}
