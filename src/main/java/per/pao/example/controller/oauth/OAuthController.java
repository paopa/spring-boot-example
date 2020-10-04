package per.pao.example.controller.oauth;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(tags = "OAuth")
@RequiredArgsConstructor
@RequestMapping(path = "/oauth")
@RestController
public class OAuthController {

    @ApiOperation(value = "login via OAuth2")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "/login")
    public String login() {
        return "login";
    }

    @ApiOperation(value = "logout via OAuth2")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "/logout")
    public String logout() {
        return "login";
    }

    @ApiOperation(value = "test endpoint for OAuth2")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/test/{id}")
    public String textEndpoint(@PathVariable(value = "id") Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "test" + id;
    }
}