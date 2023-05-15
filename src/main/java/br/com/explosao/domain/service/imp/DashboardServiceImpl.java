package br.com.explosao.domain.service.imp;

import br.com.explosao.domain.dto.PaymentDTO;
import br.com.explosao.domain.dto.dashboard.ChartPaymentDTO;
import br.com.explosao.domain.dto.dashboard.ChartStudentsDTO;
import br.com.explosao.domain.dto.StudentClassroomDTO;
import br.com.explosao.domain.dto.dashboard.DashboardStudentDueDTO;
import br.com.explosao.domain.dto.dashboard.MonthRevenueDto;
import br.com.explosao.domain.entity.DashboardStudentDueEntity;
import br.com.explosao.domain.repository.DashboardStudentDueRepository;
import br.com.explosao.domain.service.PaymentService;
import br.com.explosao.domain.service.DashboardService;
import br.com.explosao.domain.service.StudentClassroomService;
import br.com.explosao.infrasctructure.exception.RFC3339DateFormatConverterException;
import br.com.explosao.infrasctructure.exception.ResourceNotFoundException;
import br.com.explosao.infrasctructure.exception.ResourceSizeException;
import br.com.explosao.infrasctructure.util.date.DateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    DashboardStudentDueRepository dashboardStudentDueRepository;

    @Autowired
    StudentClassroomService studentClassroomService;

    @Autowired
    PaymentService paymentService;

    private final static long YEAR_IN_MILLISECONDS = 31557600000L;
    private final static int[] MONTH_OF_YEAR = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    @Override
    public List<DashboardStudentDueDTO> getStudentPaymentDue() throws ResourceNotFoundException {
        return makeDashboardStudentDue(dashboardStudentDueRepository.findAll());
    }

    private List<DashboardStudentDueDTO> makeDashboardStudentDue(List<DashboardStudentDueEntity> dueStudentClassroomList) {
        List<DashboardStudentDueDTO> dashboardStudentDueList = new ArrayList<>();
        for (DashboardStudentDueEntity dashboardStudentDueEntity :dueStudentClassroomList) {
            DashboardStudentDueDTO dashboardStudentDue = new DashboardStudentDueDTO();
            dashboardStudentDue.setStudentId(dashboardStudentDueEntity.getStudentId());
            dashboardStudentDue.setStudentName(dashboardStudentDueEntity.getStudentName());
            dashboardStudentDue.setStudentBirthday(dashboardStudentDueEntity.getStudentBirthday());
            dashboardStudentDue.setLastPayment(dashboardStudentDueEntity.getLastPayment());
            dashboardStudentDue.setTotalClassEnlisted(dashboardStudentDueEntity.getTotalClassEnlisted());
            dashboardStudentDueList.add(dashboardStudentDue);
        }

    return dashboardStudentDueList;
    }


    @Override
    public ChartStudentsDTO getStudentChart() throws ResourceNotFoundException {
       return makeChartStudentsDTO(studentClassroomService.getStudentClassroomListByStatus(true));

    }

    private ChartStudentsDTO makeChartStudentsDTO(List<StudentClassroomDTO> studentClassroomListByStatus) {
        Set<Long> studentList = new HashSet<>();
        Set<Long> studentDueList = new HashSet<>();
        ChartStudentsDTO chartStudents = new ChartStudentsDTO();
        for (StudentClassroomDTO studentClassroom: studentClassroomListByStatus) {
            if(studentClassroom.getPaymentDue() == null){
                studentDueList.add(studentClassroom.getStudentId());
            }else if(studentClassroom.getPaymentDue()){
                studentDueList.add(studentClassroom.getStudentId());
            }
                studentList.add(studentClassroom.getStudentId());
        }
        chartStudents.setTotalStudents(studentList.size());
        chartStudents.setDuePaymentStudents(studentDueList.size());
        return chartStudents;
    }

    @Override
    public ChartPaymentDTO getPaymentChart(String queryStart, String queryEnd) throws RFC3339DateFormatConverterException, ResourceNotFoundException, ResourceSizeException {
        LocalDateTime fromDate = DateFormatter.string2LocalDateTime(
                queryStart,
                "yyyy-MM-dd'T'HH:mm:ss'Z'"
        );
        LocalDateTime toDate = DateFormatter.string2LocalDateTime(
                queryEnd,
                "yyyy-MM-dd'T'HH:mm:ss'Z'"
        );

        validateDateRange(fromDate, toDate);

        List<PaymentDTO> paymentList = paymentService.getPaymentListFromDate(fromDate, toDate);

        return makeChartPayment(queryStart, queryEnd, paymentList);
    }

    private ChartPaymentDTO makeChartPayment(String queryStart, String queryEnd, List<PaymentDTO> paymentList) {
        ChartPaymentDTO chartPayment = new ChartPaymentDTO();
        chartPayment.setQueryStart(queryStart);
        chartPayment.setQueryEnd(queryEnd);
        chartPayment.setMonthRevenueList(makeMonthRevenueList(paymentList));
        return chartPayment;

    }

    private List<MonthRevenueDto> makeMonthRevenueList(List<PaymentDTO> paymentList) {
        List<MonthRevenueDto> monthRevenueList = new ArrayList<>();
        for (int monthId :MONTH_OF_YEAR) {
            List<PaymentDTO> paymentPerMonth = paymentList.stream().filter(e -> getCurrentMonth(e.getPaymentAt()) == monthId).toList();
            MonthRevenueDto monthRevenue = new MonthRevenueDto();
            monthRevenue.setMonthId(monthId);
            Double totalValue = 0D;
            for (PaymentDTO payment: paymentPerMonth){
                totalValue += payment.getPaymentValue();
            }
            monthRevenue.setPaymentTotal(totalValue);
            monthRevenueList.add(monthRevenue);
        }
        return monthRevenueList;
    }

    private void validateDateRange(LocalDateTime fromDate, LocalDateTime toDate) throws ResourceSizeException {
        long fromDateEpoch = fromDate.atZone(ZoneId.systemDefault()).toEpochSecond();
        long toDateEpoch = toDate.atZone(ZoneId.systemDefault()).toEpochSecond();
        if(toDateEpoch - fromDateEpoch > YEAR_IN_MILLISECONDS){
            throw new ResourceSizeException("Range bigger than 1 year");
        }
    }

    private int getCurrentMonth(String currentDate) {
        try{
            return DateFormatter.string2LocalDateTime(currentDate,"yyyy-MM-dd'T'HH:mm:ss").getMonthValue();
        }catch(Exception ex){
            return 0;
        }

    }
}