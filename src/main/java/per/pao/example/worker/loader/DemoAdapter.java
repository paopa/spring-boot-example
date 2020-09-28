package per.pao.example.worker.loader;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import per.pao.example.controller.simple.service.SimpleCacheService;
import per.pao.example.controller.simple.service.SimpleService;

import java.text.SimpleDateFormat;

import static org.apache.logging.log4j.util.Strings.isEmpty;

@RequiredArgsConstructor
@Component
public class DemoAdapter {

    private final SimpleService simpleService;
    private final SimpleCacheService simpleCacheService;

    public void demo(String demo) throws InterruptedException {
        if (isEmpty(demo)) {
            return;
        }
        switch (demo) {
            case Task.Retry:
                demoRetry();
                break;
            case Task.Cache:
                demoCache(generateSimpleDateFormat());
                break;
            case Task.Config:
                demoConfig();
        }
    }

    @Value("${simple.test.name}")
    private String name;
    @Value("${simple.test.age}")
    private String age;

    private void demoConfig() {
        System.out.println(name);
        System.out.println(age);
    }

    private SimpleDateFormat generateSimpleDateFormat() {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    }

    private void demoCache(SimpleDateFormat simpleDateFormat) throws InterruptedException {
        for (int i = 0; i < 30; i++) {
            System.out.println(simpleDateFormat.format(simpleCacheService.getDate()));
            Thread.sleep(1000);
        }
    }

    private void demoRetry() {
        simpleService.getSimpleDo();
    }

    class Task {
        public static final String Retry = "retry";
        public static final String Cache = "cache";
        public static final String Config = "config";
    }

}
