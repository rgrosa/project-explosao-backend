package br.com.explosao.domain.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component

public class PaymentDueJob {

    @Scheduled(cron = "${job.payment.cron}")
    public void updateDuePayments(){
       /* Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Integer month = localDate.getMonthValue();
        Integer month*/
    }
}
