package br.com.explosao.service;

import br.com.explosao.dto.UserLoginDTO;
import br.com.explosao.exception.PasswordException;
import br.com.explosao.exception.ResourceNotFoundException;
import br.com.explosao.resource.ResponseResource;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {


    ResponseResource postLogin(UserLoginDTO userLoginDto) throws PasswordException;

    UserDetails loadUserByUsername(String username) throws ResourceNotFoundException;
}
