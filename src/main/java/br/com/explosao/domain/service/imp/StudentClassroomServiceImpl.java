package br.com.explosao.domain.service.imp;

import br.com.explosao.domain.dto.StudentClassroomDTO;
import br.com.explosao.domain.entity.StudentClassroomEntity;
import br.com.explosao.domain.repository.StudentClassroomRepository;
import br.com.explosao.domain.service.ClassroomService;
import br.com.explosao.domain.service.StudentClassroomService;
import br.com.explosao.domain.service.StudentService;
import br.com.explosao.infrasctructure.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentClassroomServiceImpl implements StudentClassroomService {

    @Autowired
    StudentClassroomRepository studentClassroomRepository;

    @Autowired
    StudentService studentService;

    @Autowired
    ClassroomService classroomService;

    @Override
    public StudentClassroomDTO postStudentClassroom(StudentClassroomDTO studentClassroom) throws ResourceNotFoundException {
        validateIfExistsStudentIdClassroomId(studentClassroom.getClassroomId(), studentClassroom.getStudentId());
        StudentClassroomEntity studentClassroomEntity = getStudentClassroomEntityOrCreateNew(studentClassroom);
        populateStudentClassroomEntity(studentClassroomEntity, studentClassroom);
        return makeStudentClassroomDTO(studentClassroomRepository.save(studentClassroomEntity));

    }

    private void validateIfExistsStudentIdClassroomId(Long classroomId, Long studentId) throws ResourceNotFoundException {
        studentService.findStudentById(studentId);
        classroomService.findClassroomById(classroomId);
    }

    @Override
    public List<StudentClassroomDTO> getStudentClassroomListByClassroomIdAndStatus(Long classroomId, Boolean showOnlyActive) throws Exception {
        Optional<List<StudentClassroomEntity>> optionalStudentClassroomEntityList =
                studentClassroomRepository.findAllByClassroomIdAndStatus(classroomId, showOnlyActive);
        return makeStudentClassroomDTOList(
                optionalStudentClassroomEntityList.orElseThrow(() -> new ResourceNotFoundException("Resource not found"))
        );
    }

    @Override
    public List<StudentClassroomDTO> getStudentClassroomListByStudentIdAndStatus(Long studentId, Boolean showOnlyActive) throws Exception {
        Optional<List<StudentClassroomEntity>> optionalStudentClassroomEntityList =
                studentClassroomRepository.findAllByStudentIdAndStatus(studentId, showOnlyActive);
        return makeStudentClassroomDTOList(
                optionalStudentClassroomEntityList.orElseThrow(() -> new ResourceNotFoundException("Resource not found"))
        );
    }

    private List<StudentClassroomDTO> makeStudentClassroomDTOList(List<StudentClassroomEntity> studentClassroomEntityList) {
        List<StudentClassroomDTO> studentClassroomDTOList = new ArrayList<>();
        for (StudentClassroomEntity student: studentClassroomEntityList){
            studentClassroomDTOList.add(makeStudentClassroomDTO(student));
        }
        return studentClassroomDTOList;
    }

    private StudentClassroomDTO makeStudentClassroomDTO(StudentClassroomEntity studentClassroomEntity) {
        StudentClassroomDTO studentClassroom = new StudentClassroomDTO();
        studentClassroom.setId(studentClassroomEntity.getId());
        studentClassroom.setClassroomId(studentClassroomEntity.getClassroomId());
        studentClassroom.setStudentId(studentClassroomEntity.getStudentId());
        studentClassroom.setStatus(studentClassroomEntity.getStatus());
        studentClassroom.setLastPaymentId(studentClassroomEntity.getLastPaymentId());
        studentClassroom.setInsertedAt(studentClassroomEntity.getInsertedAt());
        studentClassroom.setUpdatedAt(studentClassroomEntity.getUpdatedAt());
        return studentClassroom;
    }

    private void populateStudentClassroomEntity(StudentClassroomEntity studentClassroomEntity, StudentClassroomDTO studentClassroom) {
        studentClassroomEntity.setClassroomId(studentClassroom.getClassroomId());
        studentClassroomEntity.setStudentId(studentClassroom.getStudentId());
        studentClassroomEntity.setStatus(studentClassroom.getStatus());
    }

    private StudentClassroomEntity getStudentClassroomEntityOrCreateNew(StudentClassroomDTO studentClassroom) {
        Optional<StudentClassroomEntity> optionalStudentClassroomEntity;
        if(studentClassroom.getId() != null){
            optionalStudentClassroomEntity = studentClassroomRepository.findById(studentClassroom.getId());
        }else{
            optionalStudentClassroomEntity = studentClassroomRepository.findOneByStudentIdAndClassroomId(
                    studentClassroom.getStudentId(),
                    studentClassroom.getClassroomId()
            );
        }
        return optionalStudentClassroomEntity.orElse(new StudentClassroomEntity());
    }
}
