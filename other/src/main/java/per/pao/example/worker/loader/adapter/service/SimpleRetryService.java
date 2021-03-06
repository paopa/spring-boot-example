package per.pao.example.worker.loader.adapter.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import per.pao.example.entity.SimpleDo;

@Slf4j
@Service
public class SimpleRetryService {

    private int count = 0;

    @Retryable(include = {NumberFormatException.class}, maxAttempts = 5, backoff = @Backoff(value = 2000))
    public SimpleDo getSimpleDo() {
        log.info("time: {}", count);
        count++;
        recoverDemo();
        return new SimpleDo();
    }

    private void recoverDemo() {
        Double.parseDouble("#$%#");
    }

    @Recover
    public SimpleDo recover(NumberFormatException e) {
        log.info("get NumberFormatException & return null");
        return null;
    }
}
