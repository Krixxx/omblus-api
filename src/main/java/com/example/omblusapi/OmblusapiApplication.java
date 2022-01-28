package com.example.omblusapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class OmblusapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmblusapiApplication.class, args);
	}

	@GetMapping("/")
	public String main(){
		return String.format("welcome");
	}
}
