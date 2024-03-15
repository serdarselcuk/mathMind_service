package com.mathmind.springboot;

import com.mathmind.springboot.dao.*;
import com.mathmind.springboot.service.impl.AuthServiceImp;
import com.mathmind.springboot.service.impl.ScoreServiceImp;
import com.mathmind.springboot.service.impl.UserServiceImp;
import jakarta.transaction.Transactional;
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
	@Transactional
	public ResponseEntity<String> saveUser(@RequestBody UserModel userModel){
		try {
			User savedUser = userService.saveUser(new User().mapToUserEntity(userModel));
			if (savedUser != null) {
				Password passwordTable = new Password().mapToPasswordEntity(savedUser.getPerson_id(), userModel);
				authService.savePassword(passwordTable);
			}

			return ResponseEntity.ok("success");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(e.getLocalizedMessage());
		}
	}

	@GetMapping("/user")
	@Transactional
	public ResponseEntity<ServiceResponse<UserModel>> getUser(@RequestParam("param_1") String param_1){
		try {
			UserModel userModel;
			User user = userService.getUser(param_1);

			if(user != null){
				Password password = authService.getPassword(user.getPerson_id());

				if(password != null ){
					userModel =  new UserModel().mapToUserModel(user);
					userModel.mapToUserModel(password, userModel);

				}else throw new RuntimeException("password not found: "+ user.getPerson_id());

			}else throw new RuntimeException("user not found: "+ param_1);

			return ResponseEntity.ok(new ServiceResponse<>(userModel));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ServiceResponse<>(e.getLocalizedMessage()));
		}
	}


}
