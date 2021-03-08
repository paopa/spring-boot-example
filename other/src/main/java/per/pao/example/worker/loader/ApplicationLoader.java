package per.pao.example.worker.loader;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import per.pao.example.worker.loader.adapter.DemoAdapter;

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
