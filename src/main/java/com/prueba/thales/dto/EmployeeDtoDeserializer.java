package com.prueba.thales.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDtoDeserializer extends JsonDeserializer<List<EmployeeDto>> {
    @Override
    public List<EmployeeDto> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        if (jsonParser.isExpectedStartArrayToken()) {
            return jsonParser.readValueAs(ArrayList.class);
        } else {
            EmployeeDto employeeDto = jsonParser.readValueAs(EmployeeDto.class);
            List<EmployeeDto> employees = new ArrayList<>();
            employees.add(employeeDto);
            return employees;
        }
    }
}
