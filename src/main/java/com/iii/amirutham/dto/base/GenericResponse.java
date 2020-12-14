package com.iii.amirutham.dto.base;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class GenericResponse {
    private String message;
    private String error;
    private Date timestamp;

    public GenericResponse(final String message) {
        super();
        this.message = message;
        this.timestamp = new Date();
    }

    public GenericResponse(final String message, final String error) {
        super();
        this.message = message;
        this.error = error;
        this.timestamp = new Date();
    }

    public GenericResponse(List<ObjectError> allErrors, String error) {
        this.error = error;
        String temp = allErrors.stream().map(e -> {
            if (e instanceof FieldError) {
                return "{\"field\":\"" + ((FieldError) e).getField() + "\",\"defaultMessage\":\"" + e.getDefaultMessage() + "\"}";
            } else {
                return "{\"object\":\"" + e.getObjectName() + "\",\"defaultMessage\":\"" + e.getDefaultMessage() + "\"}";
            }
        }).collect(Collectors.joining(","));
        this.message = "[" + temp + "]";
    }

  
}