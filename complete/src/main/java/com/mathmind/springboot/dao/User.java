package com.mathmind.springboot.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int person_id;
    @Id
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

}

