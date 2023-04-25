package br.com.explosao.domain.repository;

import br.com.explosao.domain.entity.ClassroomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassroomRepository extends JpaRepository<ClassroomEntity, Long> {

    Optional<ClassroomEntity> findOneByWeekDayAndClassroomTimeAndStatus(Integer weekDay, String classroomTime, Boolean status);

    List<ClassroomEntity> findAllByStatus(Boolean status);
}
