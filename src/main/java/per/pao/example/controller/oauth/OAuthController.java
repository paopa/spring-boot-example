package per.pao.example.controller.oauth;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(value = "OAuth 授權認證")
@RequiredArgsConstructor
@RequestMapping(path = "/oauth")
@RestController("OAuthController")
public class OAuthController {
}