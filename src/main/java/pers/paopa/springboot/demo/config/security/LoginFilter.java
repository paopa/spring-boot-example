package pers.paopa.springboot.demo.config.security;

import com.google.gson.Gson;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import pers.paopa.springboot.demo.controller.auth.dio.LoginInputEntity;
import pers.paopa.springboot.demo.util.JwtUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class LoginFilter extends AbstractAuthenticationProcessingFilter {

    public LoginFilter(String url, AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException, IOException {

        Gson gson = new Gson();
        String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        LoginInputEntity inputEntity = gson.fromJson(body, LoginInputEntity.class);

        String username = inputEntity.getName();
        String password = inputEntity.getPassword();

        if (username == null) {
            username = "";
        }

        if (password == null) {
            password = "";
        }

        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest req,
            HttpServletResponse res, FilterChain chain,
            Authentication auth) throws IOException, ServletException {
        // 登入成功，將token透過JwtUtil放到res中
        JwtUtil.addAuthentication(res, auth);
    }
}
