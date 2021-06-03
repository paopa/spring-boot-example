package per.pao.practice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.GenericFilterBean;
import per.pao.practice.api.vo.LoginVo;
import per.pao.practice.dao.UserDo;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validation;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@EnableWebSecurity(debug = true)
@Configuration
@RequiredArgsConstructor
public class WebConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.GET, SecurityUrl.WEB.getUrl());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, SecurityUrl.GET.getUrl()).permitAll()
                .antMatchers(HttpMethod.POST, SecurityUrl.POST.getUrl()).permitAll()
                .antMatchers(HttpMethod.PUT, SecurityUrl.PUT.getUrl()).permitAll()
                .antMatchers(HttpMethod.DELETE, SecurityUrl.DELETE.getUrl()).permitAll()
                .antMatchers(HttpMethod.PATCH, SecurityUrl.PATCH.getUrl()).permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(loginFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new AuthenticationFilter(), LoginFilter.class)
                .addFilterAfter(new AFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new BFilter(), BasicAuthenticationFilter.class)
                .exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    public LoginFilter loginFilter() throws Exception {
        return new LoginFilter() {{
            this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/api/v1/login", "POST"));
            this.setAuthenticationManager(authenticationManager());
        }};
    }

    private final UserDetailsService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new DaoAuthenticationProvider() {{
            this.setUserDetailsService(userService);
            this.setPasswordEncoder(new PasswordEncoder() {
                @Override
                public String encode(CharSequence rawPassword) {
                    return String.valueOf(rawPassword);
                }

                @Override
                public boolean matches(CharSequence rawPassword, String encodedPassword) {
                    return true;
                }
            });
        }});
    }

    @RequiredArgsConstructor
    private enum SecurityUrl {
        WEB(List.of(
                "/swagger-ui/**",
                "/swagger-resources/**",
                "/v3/**",
                "/"
        )),
        GET(List.of(
                "/api/v1/hello"
        )),
        POST(List.of(
                "/api/v1/login",
                "/api/v1/authenticate",
                "/api/v1/authenticate2",
                "/api/v1/authenticate3",
                "/api/v1/authenticate4"
        )),
        PUT(List.of()),
        DELETE(List.of()),
        PATCH(List.of());

        @Getter
        private final String[] url;

        SecurityUrl(Collection<String> collection) {
            this(collection.toArray(String[]::new));
        }

    }

    @Data
    public static class AuthPrinciple {
        private final String message;
        private final String description;
    }
}

class AFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println(this.getClass().getName() + " start");
        chain.doFilter(request, response);
        System.out.println(this.getClass().getName() + " end");
    }
}

class BFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println(this.getClass().getName() + " start");
        chain.doFilter(request, response);
        System.out.println(this.getClass().getName() + " end");
    }
}

class AuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        SecurityContextHolder.getContext()
                .setAuthentication(new UsernamePasswordAuthenticationToken(
                        new WebConfigurerAdapter.AuthPrinciple("hello ", "principal-yo"),
                        "credentials-yo",
                        List.of()));
        chain.doFilter(request, response);
    }
}

class LoginFilter extends UsernamePasswordAuthenticationFilter {

    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        LoginVo loginVo = new ObjectMapper().readValue(request.getInputStream(), LoginVo.class);
        System.out.println(loginVo);
        Validation.buildDefaultValidatorFactory().getValidator().validate(loginVo)
                .forEach(action -> {
                    throw new IllegalArgumentException(action.getPropertyPath() + " " + action.getMessage());
                });
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginVo.getUsername(), loginVo.getPassword());
        setDetails(request, token);
        return this.getAuthenticationManager().authenticate(token);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        response.addHeader("access-token", "access-token yo");
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed)
            throws IOException, ServletException {
        super.unsuccessfulAuthentication(request, response, failed);
    }

}

@Service
@RequiredArgsConstructor
class UserService implements UserDetailsService {

    private final UserDo.UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDo user = userRepository.findByUserName(username);
        System.out.println(user);
        return new User(user.getUsername(), user.getPassword(), List.of());
    }
}