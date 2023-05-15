package br.com.explosao.domain.service;

import br.com.explosao.domain.dto.StudentClassroomDTO;
import br.com.explosao.infrasctructure.exception.ResourceNotFoundException;

import java.util.List;

public interface StudentClassroomService {

    StudentClassroomDTO postStudentClassroom(StudentClassroomDTO studentClassroom) throws ResourceNotFoundException;

    List<StudentClassroomDTO> getStudentClassroomListByClassroomIdAndStatus(Long classroomId, Boolean showOnlyActive) throws Exception;

    List<StudentClassroomDTO> getStudentClassroomListByStudentIdAndStatus(Long studentId, Boolean showOnlyActive) throws Exception;

    List<StudentClassroomDTO> getStudentClassroomListWithNoPaymentIdOrMonthNotEquals(Integer currentMonth) throws ResourceNotFoundException;

    List<StudentClassroomDTO> getStudentClassroomListByStatus(Boolean status) throws ResourceNotFoundException;
}
