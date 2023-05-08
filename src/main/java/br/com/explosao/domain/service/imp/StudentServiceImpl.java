package br.com.explosao.domain.service.imp;

import br.com.explosao.domain.dto.StudentDTO;
import br.com.explosao.domain.entity.StudentEntity;
import br.com.explosao.domain.repository.StudentRepository;
import br.com.explosao.domain.service.StudentService;
import br.com.explosao.infrasctructure.exception.RFC3339DateFormatConverterException;
import br.com.explosao.infrasctructure.exception.ResourceNotFoundException;
import br.com.explosao.infrasctructure.exception.ResourceSizeException;
import br.com.explosao.infrasctructure.util.date.DateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    private static final int C_MAX_BYTES_SIZE_PERMITTED = 10485760;

    @Override
    public StudentDTO postStudent(StudentDTO student) throws Exception {
        validateSignatureSize(student.getGuardianSignature());
        StudentEntity studentEntity = getStudentEntityOrCreateNew(student);
        populateStudentEntity(studentEntity, student);
        return makeStudentDTO(studentRepository.save(studentEntity));
    }

    @Override
    public List<StudentDTO> findAll() {
        return makeStudentDTOList(studentRepository.findAll());
    }

    @Override
    public StudentDTO findStudentById(Long studentId) throws ResourceNotFoundException {
        Optional<StudentEntity> optionalStudentEntity = studentRepository.findById(studentId);
        return makeStudentDTO(optionalStudentEntity.orElseThrow(() -> new ResourceNotFoundException("Resource not found")));
    }

    private List<StudentDTO> makeStudentDTOList(List<StudentEntity> all) {
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (StudentEntity student: all) {
            studentDTOList.add(makeStudentDTO(student));
        }
        return studentDTOList;
    }

    private static void populateStudentEntity(StudentEntity studentEntity, StudentDTO student) throws RFC3339DateFormatConverterException {
        LocalDateTime studentBirthday = DateFormatter.string2LocalDateTime(
                student.getBirthday(),
                "yyyy-MM-dd'T'HH:mm:ss'Z'"
        );
        studentEntity.setName(student.getName());
        studentEntity.setBirthday(studentBirthday);
        studentEntity.setPhoneNumber(student.getPhoneNumber());
        studentEntity.setGuardianPhoneNumber(student.getGuardianPhoneNumber());
        studentEntity.setCpf(student.getCpf());
        studentEntity.setRegistration(student.getRegistration());
        studentEntity.setGuardianName(student.getGuardianName());
        studentEntity.setGuardianSignature(student.getGuardianSignature());
        studentEntity.setCity(student.getCity());
        studentEntity.setStudentNotes(student.getStudentNotes());
        studentEntity.setAddress(student.getAddress());
        studentEntity.setNeighborhood(student.getNeighborhood());
    }

    private void validateSignatureSize(String guardianSignature) throws ResourceSizeException {
        if(guardianSignature != null) {
            if (guardianSignature.getBytes(StandardCharsets.UTF_8).length > C_MAX_BYTES_SIZE_PERMITTED) {
                throw new ResourceSizeException("User signature exceeded the max size of 10mb");
            }
        }
    }

    private StudentDTO makeStudentDTO(StudentEntity studentEntity) {
        StudentDTO student = new StudentDTO();
        student.setId(studentEntity.getId());
        student.setName(studentEntity.getName());
        student.setBirthday(studentEntity.getBirthday().toString());
        student.setCpf(studentEntity.getCpf());
        student.setRegistration(studentEntity.getRegistration());
        student.setPhoneNumber(studentEntity.getPhoneNumber());
        student.setGuardianName(studentEntity.getGuardianName());
        student.setGuardianSignature(studentEntity.getGuardianSignature());
        student.setInsertedAt(studentEntity.getInsertedAt());
        student.setUpdatedAt(studentEntity.getUpdatedAt());
        student.setCity(studentEntity.getCity());
        student.setStudentNotes(studentEntity.getStudentNotes());
        student.setAddress(studentEntity.getAddress());
        student.setNeighborhood(studentEntity.getNeighborhood());
        student.setGuardianPhoneNumber(studentEntity.getGuardianPhoneNumber());
        return student;
    }

    private StudentEntity getStudentEntityOrCreateNew(StudentDTO student) {
        StudentEntity studentEntity;
        if(student.getId() != null){
            Optional<StudentEntity> optionalStudentEntity = studentRepository.findById(student.getId());
            studentEntity = optionalStudentEntity.orElse(new StudentEntity());
        }else{
            studentEntity = new StudentEntity();
        }
        return studentEntity;
    }

}
