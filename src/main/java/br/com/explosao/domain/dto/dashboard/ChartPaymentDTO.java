package br.com.explosao.domain.dto.dashboard;

import java.util.List;

public class ChartPaymentDTO {

    String queryStart;
    String queryEnd;
    List<MonthRevenueDto> monthRevenueList;

    public String getQueryStart() {
        return queryStart;
    }

    public void setQueryStart(String queryStart) {
        this.queryStart = queryStart;
    }

    public String getQueryEnd() {
        return queryEnd;
    }

    public void setQueryEnd(String queryEnd) {
        this.queryEnd = queryEnd;
    }

    public List<MonthRevenueDto> getMonthRevenueList() {
        return monthRevenueList;
    }

    public void setMonthRevenueList(List<MonthRevenueDto> monthRevenueList) {
        this.monthRevenueList = monthRevenueList;
    }
}
