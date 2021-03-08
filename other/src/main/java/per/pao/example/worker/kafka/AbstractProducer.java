package per.pao.example.worker.kafka;

public abstract class AbstractProducer {

    public abstract void send(String topic, String message);
}
