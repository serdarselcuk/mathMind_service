package com.mathmind.springboot.dao;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {

    @Column
    private int person_id;
    @Id
    @Column
    private String userName;
    @Column
    private Date savedDate;
    @Column
    private String firstName;
    @Column
    private String secondName;


//    @Bean
//    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//    public Score scoreSingleton() {
//        return new Score();
//    }

}

