package br.com.explosao.domain.service.imp;

import br.com.explosao.domain.dto.ClassroomDTO;
import br.com.explosao.domain.entity.ClassroomEntity;
import br.com.explosao.domain.repository.ClassroomRepository;
import br.com.explosao.domain.service.ClassroomService;
import br.com.explosao.infrasctructure.exception.MultipleResourceException;
import br.com.explosao.infrasctructure.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    ClassroomRepository classroomRepository;

    @Override
    public ClassroomDTO postClassroom(ClassroomDTO classroom) throws MultipleResourceException {
        ClassroomEntity classroomEntity = getClassroomEntityOrCreateNew(classroom);
        if(classroomEntity.getId() == null){
            validateInsert(classroom);
        }
        populateClassroomEntity(classroomEntity, classroom);
        return makeClassroomDTO(classroomRepository.save(classroomEntity));
    }

    private static void populateClassroomEntity(ClassroomEntity classroomEntity, ClassroomDTO classroom) {
        classroomEntity.setClassroomName(classroom.getClassroomName());
        classroomEntity.setClassroomTime(classroom.getClassroomTime());
        classroomEntity.setProfessorName(classroom.getProfessorName());
        classroomEntity.setWeekDay(classroom.getWeekDay());
        classroomEntity.setStatus(classroom.getStatus());
    }

    private ClassroomEntity getClassroomEntityOrCreateNew(ClassroomDTO classroom) {
        ClassroomEntity classroomEntity;
        if(classroom.getId() != null){
            Optional<ClassroomEntity> optionalClassroomEntity = classroomRepository.findById(classroom.getId());
            classroomEntity = optionalClassroomEntity.orElse(new ClassroomEntity());
        }else{
            classroomEntity = new ClassroomEntity();
        }
        return classroomEntity;
    }

    private void validateInsert(ClassroomDTO classroom) throws MultipleResourceException {
        Optional<List<ClassroomEntity>> optionalClassroomEntity = classroomRepository.
                findAllByWeekDayAndStatus(
                        classroom.getWeekDay(),
                        true
                );
        if(optionalClassroomEntity.isPresent()){
            if(isHourRangeInClassroomList(classroom.getClassroomTime(), optionalClassroomEntity.get())){
                throw new MultipleResourceException("A active classroom is already valid for the week and time informed! (each class takes 1 hour)");
            }
        }
    }

    private static boolean isHourRangeInClassroomList(String newHour, List<ClassroomEntity> classroomEntityList) {
        LocalDateTime dateToValidate = LocalDateTime.parse("2000-01-01T"+newHour+":00");
        LocalDateTime dateRegisterStart;
        LocalDateTime dateRegisterEnd;
        for (ClassroomEntity classroomEntity: classroomEntityList) {
            dateRegisterStart  = LocalDateTime.parse("2000-01-01T"+classroomEntity.getClassroomTime()+":00");
            dateRegisterEnd = LocalDateTime.parse("2000-01-01T"+classroomEntity.getClassroomTime()+":00").plusHours(1);
            if(isDateToValidateBetweenTwoOtherDates(dateToValidate, dateRegisterStart, dateRegisterEnd)){
                return true;
            }
        }
        return false;
    }

    private static boolean isDateToValidateBetweenTwoOtherDates(LocalDateTime dateToValidate, LocalDateTime dateRegisterStart, LocalDateTime dateRegisterEnd) {
        return (dateToValidate.isAfter(dateRegisterStart) && dateToValidate.isBefore(dateRegisterEnd)) || (dateToValidate.isEqual(dateRegisterStart));
    }

    @Override
    public ClassroomDTO findClassroomById(Long classroomId) throws ResourceNotFoundException {
        Optional<ClassroomEntity> optionalClassroomEntity = classroomRepository.findById(classroomId);
        return makeClassroomDTO(optionalClassroomEntity.orElseThrow(() -> new ResourceNotFoundException("Resource not found")));
    }

    @Override
    public List<ClassroomDTO> findAll(Boolean showOnlyActive){
        return makeClassroomDTOList(
                showOnlyActive?
                classroomRepository.findAllByStatus(true):
                classroomRepository.findAll()
        );
    }

    private List<ClassroomDTO> makeClassroomDTOList(List<ClassroomEntity> all) {
        List<ClassroomDTO> classroomDTOList = new ArrayList<>();
        for (ClassroomEntity classroom: all) {
            classroomDTOList.add(makeClassroomDTO(classroom));
        }
        return classroomDTOList;
    }

    private ClassroomDTO makeClassroomDTO(ClassroomEntity classroomEntity) {
        ClassroomDTO classroom = new ClassroomDTO();
        classroom.setId(classroomEntity.getId());
        classroom.setClassroomName(classroomEntity.getClassroomName());
        classroom.setClassroomTime(classroomEntity.getClassroomTime());
        classroom.setWeekDay(classroomEntity.getWeekDay());
        classroom.setProfessorName(classroomEntity.getProfessorName());
        classroom.setInsertedAt(classroomEntity.getInsertedAt());
        classroom.setUpdatedAt(classroomEntity.getUpdatedAt());
        classroom.setStatus(classroomEntity.getStatus());
        return classroom;
    }


}
