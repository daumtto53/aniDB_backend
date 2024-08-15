package com.aniDB.aniDB_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AniDbBackendApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AniDbBackendApplication.class);
		app.setAdditionalProfiles("test_local");
		app.run(args);
//		SpringApplication.run(AniDbBackendApplication.class, args);
	}

}
