package com.prueba.thales.dto;

public class ResponseEmployeeDto {
    private String status;
    Data DataObject;
    private String message;


    // Getter Methods

    public String getStatus() {
        return status;
    }

    public Data getData() {
        return DataObject;
    }

    public String getMessage() {
        return message;
    }

    // Setter Methods

    public void setStatus( String status ) {
        this.status = status;
    }

    public void setData( Data dataObject ) {
        this.DataObject = dataObject;
    }

    public void setMessage( String message ) {
        this.message = message;
    }
}
