package com.ttn.springdemo.exception;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @author Chandra Shekhar Paatni on 1/5/19
 */
@Data
@NoArgsConstructor
public class ApiError {
    private int code;
    private String message;

    public ApiError(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
