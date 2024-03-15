package com.mathmind.springboot.service.impl;

import com.mathmind.springboot.dao.Password;
import com.mathmind.springboot.dao.User;
import com.mathmind.springboot.dao.UserModel;
import com.mathmind.springboot.repository.AuthRepository;
import com.mathmind.springboot.repository.UserRepository;
import com.mathmind.springboot.service.AuthService;
import com.mathmind.springboot.service.UserService;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

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
      return userRepo.findByUserName(username).orElse(null);

    }

    @Override
    public boolean validateUser(String username) {
        return userRepo.findByUserName(username).isPresent();
    }

    @Override
    public void deleteUser(@NonNull String username) {
        userRepo.deleteById(username);
    }

}
