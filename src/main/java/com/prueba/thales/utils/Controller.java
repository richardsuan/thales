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

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class Controller {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
    @GetMapping(value = "/employees")
    public ResponseEntity<List<EmployeeDto>> getEmployees() {
        EmployeeService rest = new EmployeeService();
        List<EmployeeDto> objRes = rest.getHttpResponseEmployees();
        rest.getHttpResponseEmployees();
        return new ResponseEntity<>(objRes, HttpStatus.OK);
    }
    @GetMapping(value = "/employee/{id}")
    public ResponseEntity<List<EmployeeDto>> getEmployee(@PathVariable int id) {
        EmployeeService rest = new EmployeeService();
        List<EmployeeDto> objRes = rest.getHttpResponseOneEmployee(id);
        return new ResponseEntity<>(objRes, HttpStatus.OK);
    }

}
