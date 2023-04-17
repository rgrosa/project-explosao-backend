package br.com.explosao.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "PAYMENT")
public class PaymentEntity {

    @Id
    Long id;

    @Column(name = "STUDENT_CLASSROOM_ID")
    Long studentClassroomId;

    @Column(name = "PAYMENT_VALUE")
    Double paymentValue;

    @Column(name = "PAYMENT_AT")
    LocalDateTime paymentAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentClassroomId() {
        return studentClassroomId;
    }

    public void setStudentClassroomId(Long studentClassroomId) {
        this.studentClassroomId = studentClassroomId;
    }

    public Double getPaymentValue() {
        return paymentValue;
    }

    public void setPaymentValue(Double paymentValue) {
        this.paymentValue = paymentValue;
    }

    public LocalDateTime getPaymentAt() {
        return paymentAt;
    }

    public void setPaymentAt(LocalDateTime paymentAt) {
        this.paymentAt = paymentAt;
    }


    @PrePersist
    private void prePersistFunction(){
        this.paymentAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "PaymentEntity{" +
                "id=" + id +
                ", studentClassroomId=" + studentClassroomId +
                ", paymentValue=" + paymentValue +
                ", paymentAt=" + paymentAt +
                '}';
    }
}
