package per.pao.example.worker.log;

import org.springframework.stereotype.Component;

@Component
public class TestWorker implements ILogWorker{

    @Override
    public void print() {
        System.out.println("test print");
    }
}
