package br.com.explosao.domain.repository;

import br.com.explosao.domain.entity.DashboardStudentDueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardStudentDueRepository extends JpaRepository<DashboardStudentDueEntity, Long> {


}
