package com.example.omblusapi;

import com.example.omblusapi.model.AppUser;
import com.example.omblusapi.repository.AppUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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

	@Bean
	CommandLineRunner commandLineRunner(AppUserRepository appUserRepository){
		return args -> {
			AppUser john = new AppUser("123", "secret", "worker");

			appUserRepository.save(john);
		};
	}
}
