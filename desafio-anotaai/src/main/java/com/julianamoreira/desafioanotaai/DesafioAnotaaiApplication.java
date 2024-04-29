package com.julianamoreira.desafioanotaai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories()
@SpringBootApplication
public class DesafioAnotaaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioAnotaaiApplication.class, args);
	}

}
