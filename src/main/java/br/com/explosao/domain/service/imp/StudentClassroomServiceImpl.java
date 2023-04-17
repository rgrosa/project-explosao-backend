package br.com.explosao.domain.service.imp;

import br.com.explosao.domain.dto.StudentClassroomDTO;
import br.com.explosao.domain.entity.StudentClassroomEntity;
import br.com.explosao.domain.repository.StudentClassroomRepository;
import br.com.explosao.domain.service.StudentClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentClassroomServiceImpl implements StudentClassroomService {

    @Autowired
    StudentClassroomRepository studentClassroomRepository;

    @Override
    public StudentClassroomDTO postStudentClassroom(StudentClassroomDTO studentClassroom) throws Exception {
        StudentClassroomEntity studentClassroomEntity = getStudentClassroomEntityOrCreateNew(studentClassroom);
        populateStudentClassroomEntity(studentClassroomEntity, studentClassroom);
        return makeClassroomDTO(studentClassroomRepository.save(studentClassroomEntity));

    }

    private StudentClassroomDTO makeClassroomDTO(StudentClassroomEntity save) {
        //TODO
        return null;
    }

    private void populateStudentClassroomEntity(StudentClassroomEntity studentClassroomEntity, StudentClassroomDTO studentClassroom) {
        studentClassroomEntity.setClassroomId(studentClassroom.getClassroomId());
        studentClassroomEntity.setStudentId(studentClassroom.getStudentId());
        studentClassroomEntity.setStatus(studentClassroom.getStatus());
    }

    private StudentClassroomEntity getStudentClassroomEntityOrCreateNew(StudentClassroomDTO studentClassroom) {
        StudentClassroomEntity studentClassroomEntity;
        if(studentClassroom.getId() != null){
            Optional<StudentClassroomEntity> optionalStudentClassroomEntity =
                    studentClassroomRepository.findById(studentClassroom.getId());
            studentClassroomEntity = optionalStudentClassroomEntity.orElse(new StudentClassroomEntity());
        }else{
            studentClassroomEntity = new StudentClassroomEntity();
        }
        return studentClassroomEntity;

    }
}
