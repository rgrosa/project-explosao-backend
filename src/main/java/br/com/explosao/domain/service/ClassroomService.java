package br.com.explosao.domain.service;

import br.com.explosao.domain.dto.ClassroomDTO;
import br.com.explosao.infrasctructure.exception.MultipleResourceException;
import br.com.explosao.infrasctructure.exception.ResourceNotFoundException;

import java.util.List;

public interface ClassroomService {

    ClassroomDTO postClassroom(ClassroomDTO classroom) throws MultipleResourceException;

    ClassroomDTO findClassroomById(Long classroomId) throws ResourceNotFoundException;

    List<ClassroomDTO> findAll(Boolean showOnlyActive);
}
