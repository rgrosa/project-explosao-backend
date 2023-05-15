package br.com.explosao.domain.dto.dashboard;

public class ChartStudentsDTO {

    int totalStudents;
    int duePaymentStudents;

    public int getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }

    public int getDuePaymentStudents() {
        return duePaymentStudents;
    }

    public void setDuePaymentStudents(int duePaymentStudents) {
        this.duePaymentStudents = duePaymentStudents;
    }
}
