package br.com.explosao.domain.service;

import br.com.explosao.domain.dto.StudentDTO;
import br.com.explosao.infrasctructure.exception.ResourceNotFoundException;

import java.util.List;

public interface StudentService {

    StudentDTO postStudent(StudentDTO studentDTO) throws Exception;

    List<StudentDTO> findAll();

    StudentDTO findStudentById(Long studentId) throws ResourceNotFoundException;
}
