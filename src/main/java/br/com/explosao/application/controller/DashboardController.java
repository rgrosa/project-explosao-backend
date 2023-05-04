package br.com.explosao.application.controller;

import br.com.explosao.application.resource.Response;
import br.com.explosao.domain.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(value = "/report")
@Validated
public class DashboardController {

    @Autowired
    DashboardService dashboardService;

    @GetMapping("/students-due")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response> getPaymentController() throws Exception {

        return ResponseEntity.ok().
                body(new Response(
                        200,
                        "Success",
                        dashboardService.studentPaymentDue()
                ));
    }
}
