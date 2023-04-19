package br.com.explosao.domain.service;

import br.com.explosao.domain.dto.StudentClassroomDTO;
import br.com.explosao.infrasctructure.exception.ResourceNotFoundException;

import java.util.List;

public interface StudentClassroomService {

    StudentClassroomDTO postStudentClassroom(StudentClassroomDTO studentClassroom) throws ResourceNotFoundException;

    List<StudentClassroomDTO> getStudentClassroomListByClassroomId(Long classroomId) throws Exception;

    List<StudentClassroomDTO> getStudentClassroomListByStudentId(Long studentId) throws Exception;

}
