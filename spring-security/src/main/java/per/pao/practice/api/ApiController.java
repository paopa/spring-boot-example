package per.pao.practice.api;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import per.pao.practice.api.vo.LoginVo;

import javax.annotation.PreDestroy;
import javax.validation.Valid;
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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.of(Optional.ofNullable("ok"));
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginVo loginVo) {
        return ResponseEntity.ok("get token");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("before bean destroy");
    }
}
