package br.com.explosao.domain.service.imp;

import br.com.explosao.domain.dto.PaymentDTO;
import br.com.explosao.domain.service.PaymentService;
import br.com.explosao.infrasctructure.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public PaymentDTO postPayment(PaymentDTO paymentDTO) throws ResourceNotFoundException {

        //TODO um pagamento paga todas as aulas
        return null;
    }
}
