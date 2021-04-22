package per.pao.example.constroller;

import lombok.extern.slf4j.Slf4j;
import per.pao.example.objects.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Slf4j
@Controller
public class RSocketController {

    @MessageMapping("request-response")
    Mono<Message> requestResponse(final Message request) {
        log.info("Received request-response request:{}", request);
        return Mono.just(new Message("server", "response"));
    }
}
