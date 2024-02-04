package com.mathmind.springboot;

//import com.mathmind.springboot.repository.ScoreRepository;
//import com.mathmind.springboot.service.ScoreRepositoryImp;
import com.mathmind.springboot.dao.Scoreboard;
import com.mathmind.springboot.service.ScoreServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
public class HelloController {
	@Autowired
	ScoreServiceImp scoreRepository;


	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/score")
	public String score(){
		Scoreboard score = new Scoreboard();
		score.setAchived_date(new Date(System.currentTimeMillis()));
		score.setScore(123);
		return scoreRepository.saveScore(score).toString();
	}

}
