package com.mathmind.springboot.dao;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Password {

    @Column (name = "hashed_password")
    String hashedPassword;

    @Column(name = "hash_key")
    String hashKey;

    @Id
    @Column (name = "person_id")
    int person_id;
}
