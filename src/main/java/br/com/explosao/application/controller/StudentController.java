package br.com.explosao.application.controller;


import br.com.explosao.application.resource.Response;
import br.com.explosao.domain.dto.StudentDTO;
import br.com.explosao.domain.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/student")
@Validated
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response> postStudent(
            @RequestBody @Valid StudentDTO student, Errors errors) throws Exception {
        return ResponseEntity.ok().
                body(new Response(
                        200,
                        "Success",
                        studentService.postStudent(student)
                ));
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response> findAll(){
        return ResponseEntity.ok().
                body(new Response(
                        200,
                        "Success",
                        studentService.findAll()
                ));
    }

    @GetMapping("/by-id")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response> findStudentById(
            @RequestParam @Valid Long studentId) throws Exception {
        return ResponseEntity.ok().
                body(new Response(
                        200,
                        "Success",
                        studentService.findStudentById(studentId)
                ));
    }

}
