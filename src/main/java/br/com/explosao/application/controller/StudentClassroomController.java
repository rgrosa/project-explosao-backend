package br.com.explosao.application.controller;

import br.com.explosao.application.resource.Response;
import br.com.explosao.domain.dto.ClassroomDTO;
import br.com.explosao.domain.dto.StudentClassroomDTO;
import br.com.explosao.domain.service.ClassroomService;
import br.com.explosao.domain.service.StudentClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/student-classroom")
public class StudentClassroomController {

    @Autowired
    StudentClassroomService studentClassroomService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response> postStudentController(
            @RequestBody @Valid StudentClassroomDTO studentClassroom, Errors errors) throws Exception {
        return ResponseEntity.ok().
                body(new Response(
                        200,
                        "Success",
                        studentClassroomService.postStudentClassroom(studentClassroom)
                ));
    }
}
