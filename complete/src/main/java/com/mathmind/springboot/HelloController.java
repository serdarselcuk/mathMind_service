package com.mathmind.springboot;

//import com.mathmind.springboot.repository.ScoreRepository;
//import com.mathmind.springboot.repository.ScoreRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//	ScoreRepositoryImp scoreRepository;


	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

//	@GetMapping("/score")
//	public Object score(){
//		return scoreRepository.find(123);
//	}

}
