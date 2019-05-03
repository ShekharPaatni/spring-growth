package com.ttn.springdemo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * @author Chandra Shekhar Paatni on 28/4/19
 */
@Data
public class BaseEntity {

    @Id
    @Field("_id")
    @JsonProperty("id")
    private String id;

    @CreatedDate
    @Field("created_date")
    @JsonProperty("created_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date createdDate;

    @LastModifiedDate
    @Field("updated_date")
    @JsonProperty(value = "updated_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date updatedDate;

    @CreatedBy
    @Field("created_by")
    @JsonProperty("created_by")
    private String createdBy;
}
