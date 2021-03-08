package per.pao.example.worker.loader.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import per.pao.example.worker.loader.adapter.service.SimpleCacheService;
import per.pao.example.worker.loader.adapter.service.SimpleRetryService;
import per.pao.example.worker.loader.adapter.service.SimpleYamlService;

import static org.apache.logging.log4j.util.Strings.isEmpty;

@RequiredArgsConstructor
@Component
public class DemoAdapter {

    private final SimpleRetryService simpleRetryService;
    private final SimpleYamlService simpleYamlService;
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
                demoCache();
                break;
            case Task.Yaml:
                demoConfig();
        }
    }

    private void demoConfig() {
        simpleYamlService.demoConfig();
    }

    private void demoCache() throws InterruptedException {
        simpleCacheService.demoCache();
    }

    private void demoRetry() {
        simpleRetryService.getSimpleDo();
    }

    static class Task {
        static final String Retry = "retry";
        static final String Cache = "cache";
        static final String Yaml = "yaml";
    }

}
