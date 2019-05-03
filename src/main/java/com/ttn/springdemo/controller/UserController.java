package com.ttn.springdemo.controller;

import com.ttn.springdemo.entity.User;
import com.ttn.springdemo.exception.CustomExceptionHandling;
import com.ttn.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Chandra Shekhar Paatni on 1/5/19
 */
@RestController
public class UserController extends Controller {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<User>> getUser() {
        return new ResponseEntity(userService.getUsers(), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user, BindingResult bindingResult) throws CustomExceptionHandling {
        if (bindingResult.hasErrors()) {
            throw new CustomExceptionHandling(getErrors(bindingResult));
        }
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);

    }
}
