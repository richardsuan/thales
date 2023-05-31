package com.prueba.thales.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

public class ResponseEmployeeDto {
    private String status;
    @JsonProperty("data")
    @JsonDeserialize(using = EmployeeDtoDeserializer.class)
    private List<EmployeeDto> data;
    private String message;
    public ResponseEmployeeDto() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<EmployeeDto> getData() {
        return data;
    }

    public void setData(List<EmployeeDto> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
