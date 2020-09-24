package per.pao.example.worker.loader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import per.pao.example.controller.simple.service.SimpleCacheService;
import per.pao.example.controller.simple.service.SimpleService;

import java.text.SimpleDateFormat;

@Slf4j
@RequiredArgsConstructor
@Component
public class ApplicationLoader implements CommandLineRunner {

    private final SimpleService simpleService;
    private final SimpleCacheService simpleCacheService;

    @Override
    public void run(String... args) throws Exception {
        try{
            demoCache(generateSimpleDateFormat());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private SimpleDateFormat generateSimpleDateFormat() {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    }

    private void demoCache(SimpleDateFormat simpleDateFormat) throws InterruptedException {
        for(int i=0;i<30;i++ ){
            System.out.println(simpleDateFormat.format(simpleCacheService.getDate()));
            Thread.sleep(1000);
        }
    }

    private void demoRetry() {
        simpleService.getSimpleDo();
    }
}
