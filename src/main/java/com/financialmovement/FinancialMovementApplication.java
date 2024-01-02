package com.financialmovement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.financialmovement.entities.FinancialMethod;
import com.financialmovement.services.FinancialMethodService;

@SpringBootApplication
public class FinancialMovementApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialMovementApplication.class, args);
	}
	/*
	 * public CommandLineRunner initializerData(FinancialMethodService service) {
	 * return args -> {
	 * FinancialMethod method = new FinancialMethod(50, "Necessidades Essenciais");
	 * FinancialMethod method1 = new FinancialMethod(30, "Despesas Pessoais");
	 * FinancialMethod method2 = new FinancialMethod(20,
	 * "Poupança e Investimentos");
	 * service.saveOrdUpdate(method);
	 * service.saveOrdUpdate(method1);
	 * service.saveOrdUpdate(method2);
	 * };
	 * }
	 */

}
