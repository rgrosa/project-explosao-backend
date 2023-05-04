package br.com.explosao.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ReportStudentPaymentDueDTO {

    LocalDateTime queryStart;
    LocalDateTime queryEnd;
    Integer numberOfStudentsDue;
    List<StudentDTO> studentDueList;

    public LocalDateTime getQueryStart() {
        return queryStart;
    }

    public void setQueryStart(LocalDateTime queryStart) {
        this.queryStart = queryStart;
    }

    public LocalDateTime getQueryEnd() {
        return queryEnd;
    }

    public void setQueryEnd(LocalDateTime queryEnd) {
        this.queryEnd = queryEnd;
    }

    public Integer getNumberOfStudentsDue() {
        return numberOfStudentsDue;
    }

    public void setNumberOfStudentsDue(Integer numberOfStudentsDue) {
        this.numberOfStudentsDue = numberOfStudentsDue;
    }

    public List<StudentDTO> getStudentDueList() {
        return studentDueList;
    }

    public void setStudentDueList(List<StudentDTO> studentDueList) {
        this.studentDueList = studentDueList;
    }
}
