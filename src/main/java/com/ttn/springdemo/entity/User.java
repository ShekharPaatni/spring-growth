package com.ttn.springdemo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;

/**
 * @author Chandra Shekhar Paatni on 28/4/19
 */
@Document(collection = "user")
@Data
@NoArgsConstructor
public class User extends BaseEntity {

    private static final long serialVersionUID = -122323332112L;

    @Field("user_id")
    @JsonProperty("user_id")
    private Integer userId;
    @Field("user_name")
    @NotNull(message = "{name.NotNull}")
    @JsonProperty("user_name")
    private String userName;
    @Field("password")
    @JsonProperty("password")
    private String password;
    @Field("email")
    @NotNull(message = "{email.NotNull}")
    @JsonProperty("email")
    private String email;
    @Field("is_enabled")
    @JsonProperty("is_enabled")
    private Boolean isEnabled = false;

    public User(Integer userId, String userName, String password, String email, Boolean isEnabled) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.isEnabled = isEnabled;
        this.email = email;
    }

}
