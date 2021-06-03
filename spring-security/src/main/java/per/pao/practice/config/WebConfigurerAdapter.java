package per.pao.practice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;
import per.pao.practice.api.vo.LoginVo;
import per.pao.practice.dao.UserDo;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@EnableWebSecurity(debug = true)
@Configuration
@RequiredArgsConstructor
public class WebConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.GET, SecurityUri.WEB.uri);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, SecurityUri.GET.uri).permitAll()
                .antMatchers(HttpMethod.POST, SecurityUri.POST.uri).permitAll()
                .antMatchers(HttpMethod.PUT, SecurityUri.PUT.uri).permitAll()
                .antMatchers(HttpMethod.DELETE, SecurityUri.DELETE.uri).permitAll()
                .antMatchers(HttpMethod.PATCH, SecurityUri.PATCH.uri).permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(loginFilter())
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
    private enum SecurityUri {
        WEB(List.of(
                "/swagger-ui/**",
                "/swagger-resources/**",
                "/v3/**",
                "/"
        )),
        GET(List.of()),
        POST(List.of(
                "/api/v1/login"
        )),
        PUT(List.of()),
        DELETE(List.of()),
        PATCH(List.of());

        private final String[] uri;

        SecurityUri(Collection<String> collection) {
            this(collection.toArray(String[]::new));
        }

    }
}

class LoginFilter extends UsernamePasswordAuthenticationFilter {

    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        LoginVo loginVo = new ObjectMapper().readValue(request.getInputStream(), LoginVo.class);
        System.out.println(loginVo);
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