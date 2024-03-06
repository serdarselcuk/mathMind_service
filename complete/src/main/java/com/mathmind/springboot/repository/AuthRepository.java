package com.mathmind.springboot.repository;

import com.mathmind.springboot.dao.Password;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends CrudRepository<Password, Integer> {
}
