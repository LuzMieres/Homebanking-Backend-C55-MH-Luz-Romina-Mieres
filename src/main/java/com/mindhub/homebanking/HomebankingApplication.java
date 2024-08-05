package com.mindhub.homebanking;

import com.mindhub.homebanking.models.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.mindhub.homebanking.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData (ClientRepository clientRepository){
		return args -> {
			Client melba = new Client("Melba", "Morel", "melba@mindhub.com");
			Client ana = new Client("Ana", "Gonzalez", "anaGonzalez@gmail.com");
			Client luz = new Client("Luz", "Mieres", "luzmieres@gmail.com");
			clientRepository.save(melba);
			clientRepository.save(ana);
			clientRepository.save(luz);
			System.out.println(melba);
			System.out.println(ana);
			System.out.println(luz);

		};
	}
}

