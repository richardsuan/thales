package com.prueba.thales.impl;

import com.prueba.thales.utils.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import com.prueba.thales.dto.EmployeeDto;


import java.net.URI;

public class EmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
    private  final String url ="https://dummy.restapiexample.com/api/v1";

    public EmployeeDto getHttpResponseOneEmployee(int id){
        String url = String.format("%s/employee/%s", this.url, id);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Connection", "keep-alive");
        HttpEntity entity = new HttpEntity<>(headers);
        logger.info("los datos son: {} {}", url, id);

        try {
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET,entity, String.class);
            logger.info("los datos son fin: {} ",responseEntity);
            logger.info("los datos son fin: {} {}",responseEntity.getBody(),responseEntity.getStatusCode());
            return null;
        }catch (Exception e){
            logger.info("error {}",e.getMessage());
        }

        return null;
    }
    public EmployeeDto getHttpResponseEmployees(){
        // String url = String.format("%s/employees/", this.url);
        String url = "https://run.mocky.io/v3/152ccd2f-0e83-4d11-b65a-a90be4d651f2";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Connection", "keep-alive");
        HttpEntity entity = new HttpEntity<>(headers);
        logger.info("los datos son: {}", url);

        try {
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET,entity, String.class);
            logger.info("los datos son fin employees: {} ",responseEntity);
            logger.info("los datos son fin: {} {}",responseEntity.getBody(),responseEntity.getStatusCode());
            return null;
        }catch (Exception e){
            logger.info("error {}",e.getMessage());
        }

        return null;
    }
}
