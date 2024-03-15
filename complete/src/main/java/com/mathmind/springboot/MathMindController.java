package com.mathmind.springboot;

import com.mathmind.springboot.dao.Scoreboard;
import com.mathmind.springboot.dao.User;
import com.mathmind.springboot.dao.UserModel;
import com.mathmind.springboot.service.impl.AuthServiceImp;
import com.mathmind.springboot.service.impl.ScoreServiceImp;
import com.mathmind.springboot.service.impl.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
public class MathMindController {
	@Autowired
	ScoreServiceImp scoreRepository;
	@Autowired
	UserServiceImp userService;
	@Autowired
	AuthServiceImp authService;

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
	public ResponseEntity<String> saveUser(@RequestBody UserModel userModel){
		try {
			userService.saveUser(userModel);
			return ResponseEntity.ok("success");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(e.getLocalizedMessage());
		}
	}

	@GetMapping("/user")
	public ResponseEntity<String> getUser(@RequestParam("param_1") String param_1){
		try {
			User user = userService.getUser(param_1);
			return ResponseEntity.ok(user.toString());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(e.getLocalizedMessage());
		}
	}


}
