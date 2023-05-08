package br.com.explosao.domain.service.imp;

import br.com.explosao.domain.dto.PaymentDTO;
import br.com.explosao.domain.dto.StudentClassroomDTO;
import br.com.explosao.domain.entity.PaymentEntity;
import br.com.explosao.domain.repository.PaymentRepository;
import br.com.explosao.domain.service.PaymentService;
import br.com.explosao.domain.service.StudentClassroomService;
import br.com.explosao.infrasctructure.exception.RFC3339DateFormatConverterException;
import br.com.explosao.infrasctructure.exception.ResourceNotFoundException;
import br.com.explosao.infrasctructure.util.date.DateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    StudentClassroomService studentClassroomService;

    @Autowired
    PaymentRepository paymentRepository;

    
    @Override
    public PaymentDTO postPayment(PaymentDTO paymentDTO) throws Exception {
        List<StudentClassroomDTO> studentClassroomList = validatePaymentAndGetStudentClassroomList(paymentDTO);
        PaymentEntity paymentEntity = paymentRepository.save(makePaymentEntity(paymentDTO));
        mergeStudentClassroomListWithPayment(studentClassroomList, paymentEntity.getId());
        return makePaymentDTO(paymentEntity);
    }

    private List<StudentClassroomDTO> validatePaymentAndGetStudentClassroomList(PaymentDTO paymentDTO) throws Exception {
        if(paymentRepository.findOneByStudentIdAndMonthId(paymentDTO.getStudentId(), paymentDTO.getMonthId()).isPresent()){
            throw new ResourceNotFoundException("Payment for this student and month already realized");
        }

        List<StudentClassroomDTO> studentClassroomList = studentClassroomService.
                getStudentClassroomListByStudentIdAndStatus(
                        paymentDTO.getStudentId(),
                        true);
        if(studentClassroomList.isEmpty()){
            throw new ResourceNotFoundException("Student not found, possible he is not in any class");
        }
        return studentClassroomList;
    }

    @Override
    public PaymentDTO getPaymentById(Long paymentId) throws ResourceNotFoundException, RFC3339DateFormatConverterException {
        Optional<PaymentEntity> optionalPaymentEntity = paymentRepository.findById(paymentId);
        return makePaymentDTO(optionalPaymentEntity.orElseThrow(() -> new ResourceNotFoundException("Resource not found")));
    }

    @Override
    public Long getLastPaymentFromStudentId(Long studentId) throws ResourceNotFoundException {
        Optional<PaymentEntity> optionalPaymentEntity = paymentRepository.findLastIdByStudentId(studentId);
        return optionalPaymentEntity.orElseThrow(() -> new ResourceNotFoundException("Resource not found")).getId();
    }

    private PaymentEntity makePaymentEntity(PaymentDTO paymentDTO) {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setStudentId(paymentDTO.getStudentId());
        paymentEntity.setMonthId(paymentDTO.getMonthId());
        paymentEntity.setPaymentValue(paymentDTO.getPaymentValue());
        return paymentEntity;
    }
    private PaymentDTO makePaymentDTO(PaymentEntity paymentEntity) throws RFC3339DateFormatConverterException {
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setId(paymentEntity.getId());
        paymentDTO.setPaymentAt(DateFormatter.localDateTime2string(paymentEntity.getPaymentAt()));
        paymentDTO.setPaymentValue(paymentEntity.getPaymentValue());
        paymentDTO.setStudentId(paymentEntity.getStudentId());
        paymentDTO.setMonthId(paymentEntity.getMonthId());
        return paymentDTO;
    }

    private void mergeStudentClassroomListWithPayment(List<StudentClassroomDTO> studentClassroomList, Long lastPaymentId) throws ResourceNotFoundException {
        for (StudentClassroomDTO studentClassroom: studentClassroomList) {
            studentClassroom.setLastPaymentId(lastPaymentId);
            studentClassroom.setPaymentDue(false);
            studentClassroomService.postStudentClassroom(studentClassroom);
        }
    }
}
