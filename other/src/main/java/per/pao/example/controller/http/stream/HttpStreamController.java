package per.pao.example.controller.http.stream;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@RequiredArgsConstructor
@RestController("httpStreamController")
@RequestMapping("stream")
public class HttpStreamController {

    private final StreamTestService streamTestService = this.new StreamTestService();

    @GetMapping("test")
    public ResponseEntity<StreamingResponseBody> test() {
        return streamTestService.request();
    }

    private class StreamTestService {
        public ResponseEntity<StreamingResponseBody> request() {
            StreamingResponseBody responseBody = outputStream -> {
                for (int i = 1; i <= 100000; i++) {
                    try {
                        Thread.sleep(10);
                        outputStream.write(("Data stream line - " + i + "\n").getBytes());
                        outputStream.flush();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            return ResponseEntity.ok()
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(responseBody);
        }
    }
}
