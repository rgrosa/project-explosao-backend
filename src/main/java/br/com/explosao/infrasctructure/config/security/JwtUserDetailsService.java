package br.com.explosao.infrasctructure.config.security;

import br.com.explosao.infrasctructure.exception.ResourceNotFoundException;
import br.com.explosao.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = null;

        try {
            userDetails = userService.loadUserByUsername(username);

        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        }

        return userDetails;
    }
}
