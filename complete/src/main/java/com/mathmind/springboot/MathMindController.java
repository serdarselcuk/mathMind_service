package com.mathmind.springboot;

//import com.mathmind.springboot.repository.ScoreRepository;
//import com.mathmind.springboot.service.ScoreRepositoryImp;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mathmind.springboot.dao.Scoreboard;
import com.mathmind.springboot.dao.User;
import com.mathmind.springboot.service.ScoreServiceImp;
import com.mathmind.springboot.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;

@RestController
public class MathMindController {
	@Autowired
	ScoreServiceImp scoreRepository;
	@Autowired
	UserServiceImp userService;

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/score")
	public Scoreboard score(){
		Scoreboard score = new Scoreboard();
		score.setAchived_date(new Date(System.currentTimeMillis()));
		score.setScore(123);
		score.setPerson_id(2);
		return score;
//		return scoreRepository.getTopScoreList();
	}

	@PostMapping("/user/validate")
	public boolean userExist(@RequestParam("param_1") String param_1){
		return userService.validateUser(param_1);
	}

	@PostMapping("/user/save")
	public String saveUser(@RequestBody User user){
		return userService.saveUser(user).getPerson_id()+"";
	}



}
