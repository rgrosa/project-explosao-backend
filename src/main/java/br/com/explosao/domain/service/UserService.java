package br.com.explosao.domain.service;

import br.com.explosao.domain.dto.LoggedUserDTO;
import br.com.explosao.domain.dto.UserLoginDTO;
import br.com.explosao.infrasctructure.exception.PasswordException;
import br.com.explosao.infrasctructure.exception.ResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    LoggedUserDTO postLogin(UserLoginDTO userLoginDto) throws PasswordException;

    UserDetails loadUserByUsername(String username) throws ResourceNotFoundException;
}
