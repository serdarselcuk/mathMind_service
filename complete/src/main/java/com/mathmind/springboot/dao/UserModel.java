package com.mathmind.springboot.dao;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserModel {
    private String person_id;
    private String userName;
    private String savedDate;
    private String firstName;
    private String secondName;
    private String email;
    private String password;
    private String hashCode;
}
