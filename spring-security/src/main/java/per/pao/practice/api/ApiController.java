package per.pao.practice.api;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import per.pao.practice.api.vo.LoginVo;
import per.pao.practice.config.WebConfigurerAdapter;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.PreDestroy;
import javax.validation.Valid;
import java.security.Principal;
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

    @PostMapping("authenticate2")
    public ResponseEntity<String> authenticate2(@ApiIgnore Principal principal) {
        return ResponseEntity.ok("ok2");
    }

    @PostMapping("authenticate3")
    public ResponseEntity<String> authenticate3(@ApiIgnore Authentication authentication) {
        return ResponseEntity.ok("ok3");
    }

    @PostMapping("authenticate4")
    public ResponseEntity<String> authenticate4(@ApiIgnore @AuthenticationPrincipal WebConfigurerAdapter.AuthPrinciple principal) {
        return ResponseEntity.ok("ok4");
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
