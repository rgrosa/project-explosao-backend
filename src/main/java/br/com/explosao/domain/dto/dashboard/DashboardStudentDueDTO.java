package br.com.explosao.domain.dto.dashboard;

public class DashboardStudentDueDTO {

    Long studentId;
    String studentName;
    String studentBirthday;
    Integer totalClassEnlisted;
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
