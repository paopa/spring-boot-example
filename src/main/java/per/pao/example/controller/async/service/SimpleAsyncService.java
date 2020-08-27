package per.pao.example.controller.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service("SimpleAsyncService")
public class SimpleAsyncService {

    @Async(value = "simpleAsyncExecutor")
    public void executeAsync(Integer i){
        log.info("Async Test：{}" , i);
    }

    @Async(value = "simpleTwoAsyncExecutor")
    public void executeAsyncTwo(Integer i){
        log.info("Async Test Two：{}" , i);
    }

}
