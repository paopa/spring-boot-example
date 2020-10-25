package per.pao.example.worker.kafka;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@ConditionalOnProperty(value = "spring.kafka.enable", matchIfMissing = false, havingValue = "true")
@Component
public class SimpleConsumer {

    @KafkaListener(topics = {"test"})
    public void receive(String message) {
        System.out.println("收到訊息： " + message);
    }
}
