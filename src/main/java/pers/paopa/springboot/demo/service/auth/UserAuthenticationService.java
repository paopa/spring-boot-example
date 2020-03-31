package pers.paopa.springboot.demo.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pers.paopa.springboot.demo.dao.entity.UserDaoEntity;
import pers.paopa.springboot.demo.dao.repository.UserRepository;

@Component("UserAuthenticationService")
public class UserAuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDaoEntity user = userRepository.findByName(username);

        if(user.getName() == null){
            throw new UsernameNotFoundException("Username "+username+" not found");
        }

        return user;
    }
}
