package br.com.explosao.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "PAYMENT")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    @Column(name = "STUDENT_ID")
    Long studentId;

    @Column(name = "PAYMENT_VALUE")
    Double paymentValue;

    @Column(name = "MONTH_ID")
    Integer monthId;

    @Column(name = "PAYMENT_AT")
    LocalDateTime paymentAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
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

    public Integer getMonthId() {
        return monthId;
    }

    public void setMonthId(Integer monthId) {
        this.monthId = monthId;
    }

    @PrePersist
    private void prePersistFunction(){
        this.paymentAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "PaymentEntity{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", paymentValue=" + paymentValue +
                ", monthId=" + monthId +
                ", createdAt=" + paymentAt +
                '}';
    }
}
