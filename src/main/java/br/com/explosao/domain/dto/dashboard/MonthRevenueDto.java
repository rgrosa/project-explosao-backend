package br.com.explosao.domain.dto.dashboard;

public class MonthRevenueDto {

    Integer monthId;
    Double paymentTotal;

    public Integer getMonthId() {
        return monthId;
    }

    public void setMonthId(Integer monthId) {
        this.monthId = monthId;
    }

    public Double getPaymentTotal() {
        return paymentTotal;
    }

    public void setPaymentTotal(Double paymentTotal) {
        this.paymentTotal = paymentTotal;
    }
}
