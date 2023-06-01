package com.prueba.thales.impl;

import com.prueba.thales.dto.ResponseEmployeeDto;
import com.prueba.thales.utils.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import com.prueba.thales.dto.EmployeeDto;

import java.util.ArrayList;
import java.util.List;
public class EmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
    private  String url ="https://dummy.restapiexample.com/api/v1";
    private  String urlEmployees = "https://run.mocky.io/v3/152ccd2f-0e83-4d11-b65a-a90be4d651f2";
    private  String urlEmployee = "https://run.mocky.io/v3/40e14ba1-ee48-4dc3-8d05-c0e5e2799cc6";

    public List<EmployeeDto> getHttpResponseOneEmployee(int id) {
        String url = String.format("%s/employee/%s", this.urlEmployee, id);
        // String url = "https://run.mocky.io/v3/40e14ba1-ee48-4dc3-8d05-c0e5e2799cc6";
        logger.info(String.format("el id a buscar es %s %s", id, url));
        RestTemplate restTemplate = new RestTemplate();
        List<EmployeeDto> objRes = getEmployeeDtos(urlEmployee, restTemplate);
        if (!objRes.isEmpty()){
            return getEmployeeDtos(urlEmployee, restTemplate);
        }
        return getHttpResponseEmployees();
    }

    public List<EmployeeDto> getHttpResponseEmployees(){
        // String url = String.format("%s/employees/", this.url);
        RestTemplate restTemplate = new RestTemplate();
        return getEmployeeDtos(urlEmployees, restTemplate);
    }
    private List<EmployeeDto> getEmployeeDtos(String url, RestTemplate restTemplate) {
        List<EmployeeDto> employeeList = new ArrayList<>();
        logger.info(String.format("getEmployeeDtos url %s", url));
        try {
            ResponseEmployeeDto response = restTemplate.getForObject(url, ResponseEmployeeDto.class);
            if (response != null && response.getStatus().equals("success")) {
                List<EmployeeDto> dataList = response.getData();
                employeeList.addAll(dataList);
            }
        } catch (Exception e) {
            logger.info("error {}", e.getMessage());
        }
        return employeeList;
    }
}
