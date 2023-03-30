package br.com.explosao.config.security;

import br.com.explosao.exception.ResourceNotFoundException;
import br.com.explosao.service.UserService;
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
