package com.ttn.springdemo.exception;

import org.apache.tomcat.util.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



/**
 * @author Chandra Shekhar Paatni on 1/5/19
 */
@ControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception e) {
        logging(e);
        return new ResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = CustomExceptionHandling.class)
    public ResponseEntity customExceptionHandling(CustomExceptionHandling customException) {
        logging(customException);
        return new ResponseEntity(new ApiError(HttpStatus.BAD_REQUEST.value(), customException.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity nullPointerException(NullPointerException nullPointer) {
        logging(nullPointer);
        return new ResponseEntity(new ApiError(HttpStatus.BAD_REQUEST.value(), nullPointer.getLocalizedMessage()), HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity illegalArgumentException(IllegalArgumentException e) {
        logging(e);
        return new ResponseEntity(new ApiError(HttpStatus.BAD_REQUEST.value(), e.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
    }

    private void logging(Throwable  throwable) {
        logger.error("stack trace : {}",  throwable);
    }
}
