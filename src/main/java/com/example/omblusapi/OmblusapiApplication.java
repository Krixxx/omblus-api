package com.example.omblusapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class OmblusapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmblusapiApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(AppUserRepository appUserRepository){
//		return args -> {
//			AppUser john = new AppUser("marge", "secret", "admin");
//
//			appUserRepository.save(john);
//		};
//	}
}
