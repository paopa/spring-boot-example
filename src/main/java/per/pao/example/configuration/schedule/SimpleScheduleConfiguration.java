package per.pao.example.configuration.schedule;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@Configuration("SimpleScheduleConfiguration")
@ConditionalOnProperty(value = "scheduler.enable")
public class SimpleScheduleConfiguration {
}
