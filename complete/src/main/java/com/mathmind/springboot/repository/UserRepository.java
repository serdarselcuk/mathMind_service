package com.mathmind.springboot.repository;

import com.mathmind.springboot.dao.Scoreboard;
import com.mathmind.springboot.dao.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
