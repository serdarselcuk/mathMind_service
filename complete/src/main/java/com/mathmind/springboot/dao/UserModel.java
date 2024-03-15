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

    public UserModel mapToUserModel(User user) {

        this.setUserName(user.getUserName());
        this.setSavedDate(user.getSavedDate().toString());
        this.setFirstName(user.getFirstName());
        this.setSecondName(user.getSecondName());
        this.setEmail(user.getEmail());

        return this;
    }

    public UserModel mapToUserModel(Password password, UserModel user) {
        user.setHashCode(password.getHashKey());
        user.setPassword(password.getHashedPassword());
        return user;
    }
}
