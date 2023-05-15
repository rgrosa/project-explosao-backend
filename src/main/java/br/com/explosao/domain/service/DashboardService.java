package br.com.explosao.domain.service;

import br.com.explosao.domain.dto.dashboard.ChartPaymentDTO;
import br.com.explosao.domain.dto.dashboard.ChartStudentsDTO;
import br.com.explosao.domain.dto.dashboard.DashboardStudentDueDTO;
import br.com.explosao.infrasctructure.exception.RFC3339DateFormatConverterException;
import br.com.explosao.infrasctructure.exception.ResourceNotFoundException;
import br.com.explosao.infrasctructure.exception.ResourceSizeException;

import java.util.List;

public interface DashboardService {

    List<DashboardStudentDueDTO> getStudentPaymentDue() throws ResourceNotFoundException;

    ChartStudentsDTO getStudentChart() throws ResourceNotFoundException;

    ChartPaymentDTO getPaymentChart(String queryStart, String queryEnd) throws RFC3339DateFormatConverterException, ResourceNotFoundException, ResourceSizeException;


}
