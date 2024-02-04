package com.mathmind.springboot.repository;

import com.mathmind.springboot.dao.Scoreboard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends CrudRepository<Scoreboard, Long> {
}
