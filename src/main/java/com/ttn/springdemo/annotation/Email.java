package com.ttn.springdemo.annotation;

import com.ttn.springdemo.annotation.validator.EmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Chandra Shekhar Paatni on 1/5/19
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = EmailValidator.class)
public @interface Email {
    String message() default "Email id is not valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
