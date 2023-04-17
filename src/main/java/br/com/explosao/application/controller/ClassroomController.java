package br.com.explosao.application.controller;

import br.com.explosao.domain.dto.ClassroomDTO;
import br.com.explosao.application.resource.Response;
import br.com.explosao.domain.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/classroom")
@Validated
public class ClassroomController {

    @Autowired
    ClassroomService classroomservice;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response> postClassroom(
            @RequestBody @Valid ClassroomDTO classroom, Errors errors) throws Exception {
        return ResponseEntity.ok().
                body(new Response(
                        200,
                        "Success",
                        classroomservice.postClassroom(classroom)
                ));
    }

    @GetMapping("/by-id")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response> findClassroomById(
            @RequestParam @Valid Long classroomId) throws Exception {
        return ResponseEntity.ok().
                body(new Response(
                        200,
                        "Success",
                        classroomservice.findClassroomById(classroomId)
                ));
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response> findAll(){
        return ResponseEntity.ok().
                body(new Response(
                        200,
                        "Success",
                        classroomservice.findAll()
                ));
    }

}
