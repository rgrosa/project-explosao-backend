package br.com.explosao.controller;

import br.com.explosao.resource.ResponseResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
@Controller
@RequestMapping(value = "/classroom")
public class ClassroomController {

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseResource> postLogin() throws Exception {
        return ResponseEntity.ok().
                body(null);
    }
}
