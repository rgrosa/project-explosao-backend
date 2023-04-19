package br.com.explosao.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/report")
@Validated
public class ReportController {
}
