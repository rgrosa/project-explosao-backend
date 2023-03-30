package br.com.explosao.controller;

import br.com.explosao.dto.UserLoginDTO;
import br.com.explosao.resource.ResponseResource;
import br.com.explosao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseResource> postLogin(
            @RequestBody UserLoginDTO userLoginDto) throws Exception {
        return ResponseEntity.ok().
                body(userService.postLogin(userLoginDto));
    }
}
