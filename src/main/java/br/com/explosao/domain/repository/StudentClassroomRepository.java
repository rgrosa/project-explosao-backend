package br.com.explosao.domain.repository;

import br.com.explosao.domain.entity.StudentClassroomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentClassroomRepository extends JpaRepository<StudentClassroomEntity, Long> {

    Optional<List<StudentClassroomEntity>> findAllByClassroomId(Long classroomId);

    Optional<List<StudentClassroomEntity>> findAllByStudentId(Long studentId);

    Optional<StudentClassroomEntity> findOneByStudentIdAndClassroomId(Long studentId, Long classroomId);
}
