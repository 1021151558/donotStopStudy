package com.zjut.noStopStudy.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    private String userName;

    private String password;

    private String type;

    public User(){
        super();
    }
    public User(String userName, String password, String type) {
        this.userName = userName;
        this.password = password;
        this.type = type;
    }
}
