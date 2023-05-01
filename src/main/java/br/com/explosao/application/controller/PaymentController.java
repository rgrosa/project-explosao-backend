package br.com.explosao.application.controller;

import br.com.explosao.application.resource.Response;
import br.com.explosao.domain.dto.PaymentDTO;
import br.com.explosao.domain.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/payment")
@Validated
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response> postPaymentController(
            @RequestBody @Valid PaymentDTO payment, Errors errors) throws Exception {
        return ResponseEntity.ok().
                body(new Response(
                        200,
                        "Success",
                        paymentService.postPayment(payment)
                ));
    }

    @GetMapping("/by-id")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response> getPaymentController(
            @RequestParam Long paymentId) throws Exception {
        return ResponseEntity.ok().
                body(new Response(
                        200,
                        "Success",
                        paymentService.getPaymentById(paymentId)
                ));
    }
}
