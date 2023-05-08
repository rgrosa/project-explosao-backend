package br.com.explosao.domain.repository;

import br.com.explosao.domain.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

    @Query(value = "select * from payment where id = (select max(id) from PAYMENT where student_id  = :studentId )",nativeQuery = true)
    Optional<PaymentEntity> findLastIdByStudentId(@Param("studentId")Long studentId);

    Optional<PaymentEntity> findOneByStudentIdAndMonthId(Long studentId, Integer monthId);

}
