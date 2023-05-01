package br.com.explosao.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PaymentDTO {

    Long id;
    @NotNull
    Long studentId;
    Double paymentValue;
    @NotBlank
    String paymentAt;

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
                ", studentClassroomId=" + studentId +
                ", paymentValue=" + paymentValue +
                ", paymentAt='" + paymentAt + '\'' +
                '}';
    }
}
