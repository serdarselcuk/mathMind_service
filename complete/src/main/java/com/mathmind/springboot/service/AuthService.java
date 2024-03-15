package com.mathmind.springboot.service;

import com.mathmind.springboot.dao.Password;

public interface AuthService {

    Password savePassword(Password password);

    Password getPassword(int id);

}
