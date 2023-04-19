package br.com.explosao.domain.service;

import br.com.explosao.domain.dto.PaymentDTO;
import br.com.explosao.infrasctructure.exception.ResourceNotFoundException;

public interface PaymentService {

    PaymentDTO postPayment(PaymentDTO paymentDTO) throws ResourceNotFoundException;


}
