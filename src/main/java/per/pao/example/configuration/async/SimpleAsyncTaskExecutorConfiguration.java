package per.pao.example.configuration.async;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

import static java.lang.Integer.MAX_VALUE;

@EnableAsync
@Configuration("SimpleAsyncTaskExecutorConfiguration")
public class SimpleAsyncTaskExecutorConfiguration implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(MAX_VALUE);
        executor.setMaxPoolSize(MAX_VALUE);
        executor.setQueueCapacity(MAX_VALUE);
        executor.setKeepAliveSeconds(1000);
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}

