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


    public Password mapToPasswordEntity(Integer personId, UserModel userModel) {
        this.setPerson_id(personId);
        this.setHashKey(userModel.getHashCode());
        this.setHashedPassword(userModel.getPassword());
        return this;
    }

}
