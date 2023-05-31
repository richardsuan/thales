package com.prueba.thales.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"employee_name", "id", "employee_salary", "employee_age", "profile_image"})
public class EmployeeDto {
    public EmployeeDto(Data data){
        this.id = data.getId();
        this.employeeAge = data.getEmployee_age();
        this.employeeName = data.getEmployee_name();
        this.employeeSalary = data.getEmployee_salary();
        this.profileImage = data.getProfile_image();
    }
    public EmployeeDto(){

    }
    @JsonProperty("employee_name")
    public String getEmployeeName() {
        return sanitizingString(employeeName);
    }
    @JsonProperty("employee_name")
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public float getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
    @JsonProperty("employee_name")
    private String employeeName;

    @JsonProperty("id")
    private float id;
    @JsonProperty("employee_salary")
    private int employeeSalary;
    @JsonProperty("employee_age")
    private int employeeAge;
    @JsonProperty("profile_image")
    private String profileImage;
    public static String sanitizingString(String string){
        if (string==null)
            return null;
        else
            return string.replaceAll("[\n|\r|\t]", "_");//NOSONAR
    }
}
