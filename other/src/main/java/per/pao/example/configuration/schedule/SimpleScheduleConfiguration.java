package per.pao.example.configuration.schedule;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@EnableScheduling
@Configuration("SimpleScheduleConfiguration")
@ConditionalOnProperty(value = "scheduler.enable", matchIfMissing = true, havingValue = "true")
public class SimpleScheduleConfiguration {

    @Bean("simpleTaskScheduler")
    public TaskScheduler taskScheduler(){
        ThreadPoolTaskScheduler taskExecutor = new ThreadPoolTaskScheduler();
        taskExecutor.setPoolSize(50);
        return taskExecutor;
    }
}
