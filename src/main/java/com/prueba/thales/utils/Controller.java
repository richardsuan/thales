package com.prueba.thales.utils;

import com.prueba.thales.dto.EmployeeDto;
import com.prueba.thales.impl.EmployeeService;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@CrossOrigin(origins = "*")
public class Controller {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> validateIp(@PathVariable int id) {
        EmployeeDto objRes = new EmployeeDto();
        EmployeeService rest = new EmployeeService();


        objRes.setEmployeeName("soy el rey");
        rest.getHttpResponseOneEmployee(id);
        rest.getHttpResponseEmployees();
        return new ResponseEntity<>(objRes, HttpStatus.OK);



    }
}
