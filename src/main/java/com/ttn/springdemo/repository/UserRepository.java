package com.ttn.springdemo.repository;

import com.ttn.springdemo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Chandra Shekhar Paatni on 29/4/19
 */
public interface UserRepository extends MongoRepository<User, String> {
}
