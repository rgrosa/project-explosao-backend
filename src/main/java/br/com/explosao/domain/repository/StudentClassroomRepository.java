package br.com.explosao.domain.repository;

import br.com.explosao.domain.entity.StudentClassroomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentClassroomRepository extends JpaRepository<StudentClassroomEntity, Long> {
}
