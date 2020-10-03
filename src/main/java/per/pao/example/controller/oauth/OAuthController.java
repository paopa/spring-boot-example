package per.pao.example.controller.oauth;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = "OAuth")
@RequiredArgsConstructor
@RequestMapping(path = "/oauth")
@RestController("OAuthController")
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
}