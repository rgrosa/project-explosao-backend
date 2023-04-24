package br.com.explosao.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "STUDENT_CLASSROOM")
public class StudentClassroomEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    @Column(name = "CLASSROOM_ID")
    Long classroomId;
    @Column(name = "STUDENT_ID")
    Long studentId;
    @Column(name = "STATUS")
    Boolean status;
    @Column(name = "LAST_PAYMENT_ID")
    Long lastPaymentId;
    @Column(name = "UPDATED_AT")
    LocalDateTime updatedAt;
    @Column(name = "INSERTED_AT")
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

    @PrePersist
    private void prePersistFunction(){
        this.updatedAt = LocalDateTime.now();
        this.insertedAt = LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdateFunction(){
        this.updatedAt = LocalDateTime.now();
    }


    @Override
    public String toString() {
        return "StudentClassroomEntity{" +
                "id=" + id +
                ", classroomId=" + classroomId +
                ", studentId=" + studentId +
                ", status=" + status +
                ", lastPaymentId=" + lastPaymentId +
                ", updatedAt=" + updatedAt +
                ", insertedAt=" + insertedAt +
                '}';
    }
}

