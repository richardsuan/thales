package com.prueba.thales.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.thales.dto.Data;
import com.prueba.thales.dto.ResponseEmployeeDto;
import com.prueba.thales.utils.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import com.prueba.thales.dto.EmployeeDto;


import java.net.URI;
import java.util.ArrayList;
import java.util.Objects;

public class EmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
    private  final String url ="https://dummy.restapiexample.com/api/v1";

    public ArrayList<EmployeeDto> getHttpResponseOneEmployee(int id){
        // String url = String.format("%s/employee/%s", this.url, id);
        String url = "https://run.mocky.io/v3/40e14ba1-ee48-4dc3-8d05-c0e5e2799cc6";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Connection", "keep-alive");
        HttpEntity entity = new HttpEntity<>(headers);
        logger.info("los datos son: {} {}", url, id);
        ArrayList<EmployeeDto> employeeList = new ArrayList<EmployeeDto>();
        try {
            ResponseEntity<ResponseEmployeeDto> responseEntity = restTemplate.exchange(url, HttpMethod.GET,entity, ResponseEmployeeDto.class);
            EmployeeDto employee = new EmployeeDto(Objects.requireNonNull(responseEntity.getBody()).getData());
            if (employeeList.add(employee)){
                return employeeList;
            }



        }catch (Exception e){
            logger.info("error {}",e.getMessage());
        }

        return null;
    }
    public String getHttpResponseEmployees(){
        // String url = String.format("%s/employees/", this.url);
        String url = "https://run.mocky.io/v3/152ccd2f-0e83-4d11-b65a-a90be4d651f2";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Connection", "keep-alive");
        HttpEntity entity = new HttpEntity<>(headers);
        logger.info("los datos son: {}", url);
        try {
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
            logger.info("response {} \n {}", responseEntity, responseEntity.getBody());
            return responseEntity.getBody();
        }catch (Exception e){
            logger.info("error {}",e.getMessage());
        }

        return null;
    }
}
