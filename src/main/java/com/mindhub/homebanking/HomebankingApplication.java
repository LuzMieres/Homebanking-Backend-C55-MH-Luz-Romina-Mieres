package com.mindhub.homebanking;

import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.models.Transaction;
import com.mindhub.homebanking.models.TransactionType;
import com.mindhub.homebanking.repositories.AccountRepository;
import com.mindhub.homebanking.repositories.ClientRepository;
import com.mindhub.homebanking.repositories.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}
	// Create a date object

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository, TransactionRepository transactionRepository) {
		return args -> {
			Client melba = new Client("Melba", "Morel", "melbamorel@gmailcom");
			Account account1 = new Account("VIN001",5000.0, LocalDate.now());
			Account account2 = new Account("VIN002", 7500.0, LocalDate.now().plusDays(1));
			Transaction pagoServicioLuzMelba = new Transaction( TransactionType.DEBIT,-3000, "DEBIN PAGO SERVICIO", LocalDateTime.now());
			Transaction transferenciaRecibida1Melba = new Transaction(TransactionType.CREDIT,1500, "CR INTERBANK",LocalDateTime.now().plusDays(1));
			Transaction pagoInternetMelba = new Transaction( TransactionType.DEBIT,-1000, "DEBIN PAGO SERVICIO", LocalDateTime.now().plusDays(1));
			Transaction transferenciaRecibida2Melba = new Transaction( TransactionType.CREDIT,1000, "CR INTERBANK",LocalDateTime.now().plusDays(2));
			Client ana = new Client("Ana", "Gonzalez", "anagonzalez@gmail.com");
			Account account3 = new Account("VIN003", 2000.0, LocalDate.now());
			Account account4 = new Account("VIN004", 3000.0, LocalDate.now().plusDays(2));
			Transaction pagoServicioAguaAna = new Transaction( TransactionType.DEBIT,-2000, "DEBIN PAGO SERVICIO", LocalDateTime.now());
			Transaction transferenciaRecibida1Ana = new Transaction(TransactionType.CREDIT,1000, "CR INTERBANK",LocalDateTime.now().plusDays(2));
			Transaction pagoInternetAna = new Transaction( TransactionType.DEBIT,-1000, "DEBIN PAGO SERVICIO", LocalDateTime.now().plusDays(1));
			Transaction transferenciaRecibida2Ana = new Transaction( TransactionType.CREDIT,1000, "CR INTERBANK",LocalDateTime.now().plusDays(2));
			Client luz = new Client("Luz", "Mieres", "luzmieres@gmail.com");
			Account account5 = new Account("VIN005", 4000.0, LocalDate.now());
			Account account6 = new Account("VIN006", 5000.0, LocalDate.now().plusDays(3));
			Transaction transferenciaEnviadaLuz = new Transaction( TransactionType.DEBIT,-3000, "DEBIN PAGO SERVICIO", LocalDateTime.now());
			Transaction transferenciaRecibida1Luz = new Transaction(TransactionType.CREDIT,2000, "CR INTERBANK",LocalDateTime.now().plusDays(3));
			Transaction pagoInternetLuz = new Transaction( TransactionType.DEBIT,-1000, "DEBIN PAGO SERVICIO", LocalDateTime.now().plusDays(1));
			Transaction transferenciaRecibida2Luz = new Transaction( TransactionType.CREDIT,1000, "CR INTERBANK",LocalDateTime.now().plusDays(2));

			melba.addAccount(account1);
			melba.addAccount(account2);
			clientRepository.save(melba);
			account1.addTransaction(pagoServicioLuzMelba);
			account1.addTransaction(transferenciaRecibida1Melba);
			account2.addTransaction(transferenciaRecibida2Melba);
			account2.addTransaction(pagoInternetMelba);
			accountRepository.save(account1);
			accountRepository.save(account2);
			transactionRepository.save(pagoServicioLuzMelba);
			transactionRepository.save(transferenciaRecibida1Melba);
			transactionRepository.save(transferenciaRecibida2Melba);
			transactionRepository.save(pagoInternetMelba);



			ana.addAccount(account3);
			ana.addAccount(account4);
			clientRepository.save(ana);
			account3.addTransaction(pagoServicioAguaAna);
			account3.addTransaction(transferenciaRecibida1Ana);
			account4.addTransaction(transferenciaRecibida2Ana);
			account4.addTransaction(pagoInternetAna);

			accountRepository.save(account3);
			accountRepository.save(account4);
			transactionRepository.save(pagoServicioAguaAna);
			transactionRepository.save(transferenciaRecibida1Ana);
			transactionRepository.save(transferenciaRecibida2Ana);
			transactionRepository.save(pagoInternetAna);


			luz.addAccount(account5);
			luz.addAccount(account6);
			clientRepository.save(luz);
			account5.addTransaction(transferenciaEnviadaLuz);
			account5.addTransaction(transferenciaRecibida1Luz);
			account6.addTransaction(transferenciaRecibida2Luz);
			account6.addTransaction(pagoInternetLuz);

			accountRepository.save(account5);
			accountRepository.save(account6);
			transactionRepository.save(transferenciaEnviadaLuz);
			transactionRepository.save(transferenciaRecibida1Luz);
			transactionRepository.save(transferenciaRecibida2Luz);
			transactionRepository.save(pagoInternetLuz);


			System.out.println(melba);
			System.out.println(ana);
			System.out.println(luz);
		};
	}
}