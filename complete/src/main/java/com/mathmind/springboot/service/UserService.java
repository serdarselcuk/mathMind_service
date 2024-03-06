package com.mathmind.springboot.service;

import com.mathmind.springboot.dao.Password;
import com.mathmind.springboot.dao.User;

public interface UserService {

    User saveUser(User user);
    User getUser(String username);

    void deleteUser(String username);

    boolean validateUser(String userName);

}
