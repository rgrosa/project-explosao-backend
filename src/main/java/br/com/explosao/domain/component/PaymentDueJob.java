package br.com.explosao.domain.component;

import br.com.explosao.domain.dto.StudentClassroomDTO;
import br.com.explosao.domain.service.StudentClassroomService;
import br.com.explosao.infrasctructure.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Component
public class PaymentDueJob {

    @Autowired
    StudentClassroomService studentClassroomService;

    @Scheduled(cron = "${job.payment.cron}")
    public void updateDuePayments() throws ResourceNotFoundException {
        Integer currentMonth = getCurrentMonth();
        List<StudentClassroomDTO> dueStudentClassroomList =
                studentClassroomService.getStudentClassroomListWithNoPaymentIdOrMonthNotEquals(currentMonth);

        for (StudentClassroomDTO studentClassroomDTO:dueStudentClassroomList) {
            studentClassroomDTO.setPaymentDue(true);
            studentClassroomService.postStudentClassroom(studentClassroomDTO);
        }
    }

    private Integer getCurrentMonth() {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate.getMonthValue();
    }
}
