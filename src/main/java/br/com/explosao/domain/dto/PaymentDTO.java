package br.com.explosao.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PaymentDTO {

    Long id;
    @NotNull
    Long studentClassroomId;
    Double paymentValue;
    @NotBlank
    String paymentAt;

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

    public String getPaymentAt() {
        return paymentAt;
    }

    public void setPaymentAt(String paymentAt) {
        this.paymentAt = paymentAt;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "id=" + id +
                ", studentClassroomId=" + studentClassroomId +
                ", paymentValue=" + paymentValue +
                ", paymentAt='" + paymentAt + '\'' +
                '}';
    }
}
