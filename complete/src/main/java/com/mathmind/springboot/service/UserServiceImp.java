package com.mathmind.springboot.service;

import com.mathmind.springboot.dao.Scoreboard;
import com.mathmind.springboot.dao.User;
import com.mathmind.springboot.repository.ScoreRepository;
import com.mathmind.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepo;

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public boolean validateUser(String username) {
        return userRepo.findById(username).isPresent();
    }

    @Override
    public User deleteUser(String username) {
        return null;
    }

}
