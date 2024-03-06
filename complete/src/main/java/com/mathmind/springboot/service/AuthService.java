package com.mathmind.springboot.service;

import com.mathmind.springboot.dao.Password;
import com.mathmind.springboot.dao.User;

public interface AuthService {

    String savePassword(Password password);

}
