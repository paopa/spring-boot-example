package per.pao.example.controller.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service("SimpleAsyncService")
public class SimpleAsyncService {

    @Async(value = "simpleAsyncExecutor")
    public void execute(Integer i) throws InterruptedException {
        log.info("Async Test：{} ", i);
        Thread.sleep(1000);
    }

}
