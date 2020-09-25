package per.pao.example.worker.loader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import per.pao.example.controller.simple.service.SimpleCacheService;
import per.pao.example.controller.simple.service.SimpleService;

import java.text.SimpleDateFormat;

import static org.apache.logging.log4j.util.Strings.isEmpty;

@Slf4j
@RequiredArgsConstructor
@Component
public class ApplicationLoader implements CommandLineRunner {

    private final SimpleService simpleService;
    private final SimpleCacheService simpleCacheService;

    @Override
    public void run(String... args) throws Exception {
        try {
            demo("cache");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void demo(String demo) throws InterruptedException {
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
        }
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
    }
}
