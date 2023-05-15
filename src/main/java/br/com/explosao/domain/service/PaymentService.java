package br.com.explosao.domain.service;

import br.com.explosao.domain.dto.PaymentDTO;
import br.com.explosao.infrasctructure.exception.RFC3339DateFormatConverterException;
import br.com.explosao.infrasctructure.exception.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.List;

public interface PaymentService {

    PaymentDTO postPayment(PaymentDTO paymentDTO) throws Exception;

    PaymentDTO getPaymentById(Long paymentId) throws ResourceNotFoundException, RFC3339DateFormatConverterException;

    Long getLastPaymentFromStudentId(Long studentId) throws ResourceNotFoundException;

    List<PaymentDTO> getPaymentListFromDate(LocalDateTime fromDate, LocalDateTime toDate) throws ResourceNotFoundException, RFC3339DateFormatConverterException;

}
