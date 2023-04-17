package br.com.explosao.application.controller;

import br.com.explosao.domain.dto.UserLoginDTO;
import br.com.explosao.application.resource.Response;
import br.com.explosao.domain.service.UserService;
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
    public ResponseEntity<Response> postLogin(
            @RequestBody final UserLoginDTO userLoginDto) throws Exception {
        return ResponseEntity.ok().
                body(new Response(200,
                        "Success",
                        userService.postLogin(userLoginDto))
                );
    }
}
