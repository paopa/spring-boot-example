package per.pao.practice.api;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Api(value = "APIv1")
@RequiredArgsConstructor
@RequestMapping("api/v1")
@Controller
public class ApiController {

    @GetMapping("hello")
    public ResponseEntity<String> test() {
        return ResponseEntity.of(Optional.ofNullable("hello world"));
    }

    @PostMapping("authenticate")
    public ResponseEntity<String> authenticate() {
        return ResponseEntity.of(Optional.ofNullable("ok"));
    }

}
