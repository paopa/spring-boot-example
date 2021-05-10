package per.pao.example.constroller;

import lombok.extern.slf4j.Slf4j;
import per.pao.example.objects.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Slf4j
@Controller
public class RSocketController {

    @MessageMapping("request-response")
    Mono<Message> requestResponse(final Message message) {
        log.info("Received request-response request:{}", message);
        return Mono.just(new Message("world"));
    }

    @MessageMapping("fire-and-forget")
    Mono<Void> fireAndForget(final Message message) {
        log.info("Received fire-and-forget request:{}", message);
        return Mono.empty();
    }

    @MessageMapping("request-stream")
    Flux<Message> stream(final Message message) {
        return Flux.interval(Duration.ofMillis(1000))
                .map(index -> new Message("You said: " + message.getMessage() + " Response #" + index))
                .log();
    }

    @MessageMapping("stream-stream")
    Flux<Message> channel(final Flux<Integer> settings) {
        return settings
                .doOnNext(setting -> System.out.println("Requested interval is {} seconds." + setting))
                .doOnCancel(() -> System.out.println("This client cancelled this channel."))
                .switchMap(setting -> Flux.interval(Duration.ofSeconds(setting))
                        .map(index -> new Message("Stream Response #" + index)))
                .log();
    }
}
