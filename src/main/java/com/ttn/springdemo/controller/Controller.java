package com.ttn.springdemo.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * @author Chandra Shekhar Paatni on 1/5/19
 */
@Component
public class Controller {

    public String getErrors(BindingResult bindingResult) {
        StringBuilder stringBuilder = new StringBuilder();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            stringBuilder.append(fieldError.getDefaultMessage()).append(" ");
        }
        return stringBuilder.toString();
    }
}
