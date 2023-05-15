package br.com.explosao.domain.repository;

import br.com.explosao.domain.entity.PaymentEntity;
import br.com.explosao.domain.entity.StudentClassroomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentClassroomRepository extends JpaRepository<StudentClassroomEntity, Long> {

    Optional<List<StudentClassroomEntity>> findAllByClassroomIdAndStatus(Long classroomId, Boolean status);

    Optional<List<StudentClassroomEntity>> findAllByStudentIdAndStatus(Long studentId, Boolean status);

    Optional<StudentClassroomEntity> findOneByStudentIdAndClassroomId(Long studentId, Long classroomId);


    @Query(value = "select sc.* " +
            "from student_classroom sc " +
            "left join payment p on sc.last_payment_id = p.id " +
            "where sc.status is true and sc.is_payment_due is false and sc.last_payment_id is null or p.month_id < :monthId ",nativeQuery = true)
    Optional<List<StudentClassroomEntity>> findAllNoPaymentIdOrMonthNotEquals(@Param("monthId")Integer monthId);

    Optional<List<StudentClassroomEntity>> findAllByStatus(Boolean status);

    List<StudentClassroomEntity> findAllByIsPaymentDueAndLastPaymentId(Boolean isPaymentDue,Long lastPaymentId);
}
