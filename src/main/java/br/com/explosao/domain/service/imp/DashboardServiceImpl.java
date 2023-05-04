package br.com.explosao.domain.service.imp;

import br.com.explosao.domain.dto.ReportStudentPaymentDueDTO;
import br.com.explosao.domain.service.PaymentService;
import br.com.explosao.domain.service.DashboardService;
import br.com.explosao.domain.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    PaymentService paymentService;

    @Autowired
    StudentService studentService;

    @Override
    public ReportStudentPaymentDueDTO studentPaymentDue() {
        return null;
    }
}
