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
public class Scoreboard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Person_id;
    @Column
    private int score;
    @Column
    private Date achived_date;

//    @Bean
//    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//    public Score scoreSingleton() {
//        return new Score();
//    }

}

