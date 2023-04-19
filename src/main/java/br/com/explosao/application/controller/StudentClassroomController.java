package br.com.explosao.application.controller;

import br.com.explosao.application.resource.Response;
import br.com.explosao.domain.dto.StudentClassroomDTO;
import br.com.explosao.domain.service.StudentClassroomService;
import br.com.explosao.infrasctructure.exception.ResourceNotFoundException;
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
@RequestMapping(value = "/student-classroom")
@Validated
public class StudentClassroomController {

    @Autowired
    StudentClassroomService studentClassroomService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response> postStudentClassroom(
            @RequestBody @Valid StudentClassroomDTO studentClassroom, Errors errors) throws ResourceNotFoundException {
        return ResponseEntity.ok().
                body(new Response(
                        200,
                        "Success",
                        studentClassroomService.postStudentClassroom(studentClassroom)
                ));
    }
    //TODO: Testar
    @GetMapping("/find-by-student-id")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response> getStudentClassroomListByStudentIdController(
            @RequestParam @Valid Long studentId) throws Exception {
        return ResponseEntity.ok().
                body(new Response(
                        200,
                        "Success",
                        studentClassroomService.getStudentClassroomListByStudentId(studentId)
                ));
    }

    //TODO: Testar
    @GetMapping("/find-by-classroom-id")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response> getStudentClassroomListByClassroomIdController(
            @RequestParam @Valid Long classroomId) throws Exception {
        return ResponseEntity.ok().
                body(new Response(
                        200,
                        "Success",
                        studentClassroomService.getStudentClassroomListByClassroomId(classroomId)
                ));
    }


}
