package com.sevenre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Runner {

	public static void main(String[] args) {
		SpringApplication.run(Runner.class, args);
	}

	@RequestMapping(value = "/")
	public String getStartedMsg(){
		return "Application Started!!";
	}
}
