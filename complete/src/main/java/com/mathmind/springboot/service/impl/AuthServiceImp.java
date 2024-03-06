package com.mathmind.springboot.service.impl;

import com.mathmind.springboot.dao.Password;
import com.mathmind.springboot.repository.AuthRepository;
import com.mathmind.springboot.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImp implements AuthService {

    @Autowired
    AuthRepository authRepo;

    @Override
    public String savePassword(Password password) {
        try{
            return "saved" + authRepo.save(password).getPerson_id();
        }catch ( Exception e){
            return e.getLocalizedMessage();
        }
    }
}
