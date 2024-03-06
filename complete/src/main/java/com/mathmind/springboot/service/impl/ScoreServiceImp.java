package com.mathmind.springboot.service.impl;

import com.mathmind.springboot.dao.Scoreboard;
import com.mathmind.springboot.repository.ScoreRepository;
import com.mathmind.springboot.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ScoreServiceImp implements ScoreService {

    @Autowired
    ScoreRepository scoreRepo;

    @Override
    public Scoreboard saveScore(Scoreboard score) {
        return scoreRepo.save(score);
    }

    @Override
    public ArrayList<Scoreboard> getScoreBoardForUser() {
        return null;
    }

    @Override
    public String getTopScoreList() {
        return "hi";
    }
}
