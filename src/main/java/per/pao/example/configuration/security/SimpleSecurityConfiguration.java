package per.pao.example.configuration.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SimpleSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers(SecurityUri.HTTP_PERMIT_URI).permitAll()
//                .antMatchers("/**").authenticated()
                .antMatchers("/**").permitAll()
                .and()
                .csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(SecurityUri.WEB_IGNORING_URI);
    }

    static class SecurityUri {
        static final String[] HTTP_PERMIT_URI = {
                "/api/**",
                "/oauth/**"
        };

        static final String[] WEB_IGNORING_URI = {
                "/actuator/**",
                "/swagger-ui/**",
                "/swagger-resources/**",
                "/v3/**"
        };
    }
}
