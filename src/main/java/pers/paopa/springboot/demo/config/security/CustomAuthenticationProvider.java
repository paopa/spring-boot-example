package pers.paopa.springboot.demo.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pers.paopa.springboot.demo.service.auth.UserAuthenticationService;

@Service("CustomAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserAuthenticationService userAuthenticationService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserDetails user =  userAuthenticationService.loadUserByUsername(name);
        if (name.equals(user.getUsername()) && password.equals(user.getPassword())) {
            Authentication auth = new UsernamePasswordAuthenticationToken(name, password, user.getAuthorities());
            return auth;
        } else {
            throw new BadCredentialsException("Password error");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
