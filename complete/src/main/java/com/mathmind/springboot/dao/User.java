package com.mathmind.springboot.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mathmind.springboot.service.AuthService;
import com.mathmind.springboot.service.impl.AuthServiceImp;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {



    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int person_id;

    @Column
    private String userName;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate savedDate;
    @Column
    private String firstName;
    @Column
    private String secondName;
    @Column
    private  String email;

//    @Bean
//    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//    public Score scoreSingleton() {
//        return new Score();
//    }

    public User mapToUserEntity(UserModel userModel) {

        this.setUserName(userModel.getUserName());
        this.setSavedDate(LocalDate.parse(userModel.getSavedDate()));
        this.setFirstName(userModel.getFirstName());
        this.setSecondName(userModel.getSecondName());
        this.setEmail(userModel.getEmail());
        return this;
    }

}

