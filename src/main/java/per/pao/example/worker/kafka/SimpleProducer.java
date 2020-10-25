package per.pao.example.worker.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;

@ConditionalOnProperty(value = "spring.kafka.enable", matchIfMissing = false, havingValue = "true")
@RequiredArgsConstructor
@Component
public class SimpleProducer extends AbstractProducer {

    private final KafkaTemplate kafkaTemplate;

    @Override
    public void send(String topic, String message) {
        ListenableFuture future = kafkaTemplate.send(topic, message);
        future.addCallback(
                o -> System.out.printf("發送成功: %s\n", o),
                throwable -> System.out.printf("發送失敗: %s\n", throwable)
        );
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void producerScheduleTest() {
        send("test", UUID.randomUUID().toString());
    }
}
