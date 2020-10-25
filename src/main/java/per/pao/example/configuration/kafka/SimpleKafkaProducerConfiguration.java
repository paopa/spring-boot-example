package per.pao.example.configuration.kafka;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@ConditionalOnProperty(value = "spring.kafka.enable", matchIfMissing = false, havingValue = "true")
//@EnableKafka
@Configuration
public class SimpleKafkaProducerConfiguration {
}
