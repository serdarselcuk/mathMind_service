package com.mathmind.springboot.service.impl;

import com.mathmind.springboot.dao.Password;
import com.mathmind.springboot.dao.User;
import com.mathmind.springboot.dao.UserModel;
import com.mathmind.springboot.repository.AuthRepository;
import com.mathmind.springboot.repository.UserRepository;
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

    @Autowired
    AuthRepository authRepo;

    @Transactional
    public void saveUser(UserModel userModel) {
        // Save user details
        User savedUser = saveUser(mapToUserEntity(userModel));

        // Use the generated personId from savedUser to save password info
        if (savedUser != null) {
            Password passwordTable = mapToPasswordTableEntity(savedUser.getPerson_id(), userModel);
            authRepo.save(passwordTable);
        }
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User getUser(String username) {
        return  userRepo.findById(username).orElse(null);
    }

    @Override
    public boolean validateUser(String username) {
        return userRepo.findByUserName(username).isPresent();
    }

    @Override
    public void deleteUser(@NonNull String username) {
        userRepo.deleteById(username);
    }

    private User mapToUserEntity(UserModel userModel) {
        User user = new User();
        user.setUserName(userModel.getUserName());
        user.setSavedDate(LocalDate.parse(userModel.getSavedDate()));
        user.setFirstName(userModel.getFirstName());
        user.setSecondName(userModel.getSecondName());
        user.setEmail(userModel.getEmail());
        return user;
    }

    private Password mapToPasswordTableEntity(Integer personId, UserModel userModel) {
        Password passwordTable = new Password();
        passwordTable.setPerson_id(personId);
        passwordTable.setHashKey(userModel.getHashCode());
        passwordTable.setHashedPassword(userModel.getPassword());
        return passwordTable;
    }
}
