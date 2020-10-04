package per.pao.example.worker.loader.adapter.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SimpleYamlService {

    @Value("${simple.test.name}")
    private String name;
    @Value("${simple.test.age}")
    private String age;

    public void demoConfig() {
        System.out.println(name);
        System.out.println(age);
    }
}
