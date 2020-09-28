package per.pao.example.worker.loader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class ApplicationLoader implements CommandLineRunner {

    private final DemoAdapter demoAdapter;

    @Override
    public void run(String... args) {
        try {
            demo("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void demo(String type) throws InterruptedException {
        demoAdapter.demo(type);
    }

}
