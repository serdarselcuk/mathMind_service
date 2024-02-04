package com.mathmind.springboot.service;

import com.mathmind.springboot.dao.Scoreboard;

import java.util.ArrayList;


public interface ScoreService {

    Scoreboard saveScore(Scoreboard score);

     ArrayList<Scoreboard> getScoreBoardForUser();

     ArrayList<Scoreboard> getTopScoreList();

}
