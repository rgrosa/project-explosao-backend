package br.com.explosao.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DASHBOARD_STUDENT_DUE")
public class DashboardStudentDueEntity {

    @Id
    @Column(name = "ID")
    Long studentId;
    @Column(name = "STUDENT_NAME")
    String studentName;
    @Column(name = "STUDENT_BIRTHDAY")
    String studentBirthday;
    @Column(name = "TOTAL_CLASSROOM_ENLISTED")
    Integer totalClassEnlisted;
    @Column(name = "LAST_PAYMENT")
    String lastPayment;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentBirthday() {
        return studentBirthday;
    }

    public void setStudentBirthday(String studentBirthday) {
        this.studentBirthday = studentBirthday;
    }

    public Integer getTotalClassEnlisted() {
        return totalClassEnlisted;
    }

    public void setTotalClassEnlisted(Integer totalClassEnlisted) {
        this.totalClassEnlisted = totalClassEnlisted;
    }

    public String getLastPayment() {
        return lastPayment;
    }

    public void setLastPayment(String lastPayment) {
        this.lastPayment = lastPayment;
    }
}
