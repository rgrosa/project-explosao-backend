package br.com.explosao.domain.dto;

import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class StudentClassroomDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    Long id;
    @NotNull
    Long classroomId;
    @NotNull
    Long studentId;
    Boolean status;
    Long lastPaymentId;
    LocalDateTime updatedAt;
    LocalDateTime insertedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Long classroomId) {
        this.classroomId = classroomId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getLastPaymentId() {
        return lastPaymentId;
    }

    public void setLastPaymentId(Long lastPaymentId) {
        this.lastPaymentId = lastPaymentId;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getInsertedAt() {
        return insertedAt;
    }

    public void setInsertedAt(LocalDateTime insertedAt) {
        this.insertedAt = insertedAt;
    }
}
