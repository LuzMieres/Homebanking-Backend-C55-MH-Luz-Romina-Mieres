package com.mindhub.homebanking;

import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.repositories.AccountRepository;
import com.mindhub.homebanking.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}
	// Create a date object

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository) {
		return args -> {
			Client melba = new Client("Melba", "Morel", "melbamorel@gmailcom");
			Account account1 = new Account("VIN001",5000.0, LocalDate.now());
			Account account2 = new Account("VIN002", 7500.0, LocalDate.now().plusDays(1));
			Client ana = new Client("Ana", "Gonzalez", "anagonzalez@gmail.com");
			Account account3 = new Account("VIN003", 2000.0, LocalDate.now());
			Account account4 = new Account("VIN004", 3000.0, LocalDate.now().plusDays(2));
			Client luz = new Client("Luz", "Mieres", "luzmieres@gmail.com");
			Account account5 = new Account("VIN005", 4000.0, LocalDate.now());
			Account account6 = new Account("VIN006", 5000.0, LocalDate.now().plusDays(3));

			melba.addAccount(account1);
			melba.addAccount(account2);
			clientRepository.save(melba);
			accountRepository.save(account1);
			accountRepository.save(account2);

			ana.addAccount(account3);
			ana.addAccount(account4);
			clientRepository.save(ana);
			accountRepository.save(account3);
			accountRepository.save(account4);

			luz.addAccount(account5);
			luz.addAccount(account6);
			clientRepository.save(luz);
			accountRepository.save(account5);
			accountRepository.save(account6);

			System.out.println(melba);
			System.out.println(ana);
			System.out.println(luz);
		};
	}
}