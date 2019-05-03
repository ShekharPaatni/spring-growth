package com.ttn.springdemo.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

/**
 * @author Chandra Shekhar Paatni on 1/5/19
 */

public class CustomExceptionHandling extends Exception {
    private String message;
    private HttpStatus statusCode;
    private List<String> errors;

    public CustomExceptionHandling() {
    }

    public CustomExceptionHandling(String message) {
        super(message);
        this.message = message;
    }

    public CustomExceptionHandling(String message, HttpStatus statusCode, List<String> errors) {
        super();
        this.message = message;
        this.statusCode = statusCode;
        this.errors = errors;
    }

    public CustomExceptionHandling(String message, HttpStatus statusCode, String error) {
        super();
        this.message = message;
        this.statusCode = statusCode;
        this.errors = Arrays.asList(error);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
