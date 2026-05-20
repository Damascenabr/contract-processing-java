package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.service.ContractService;
import model.service.PaypalService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Enter the contract details:");
		System.out.print("Number Contract: ");
		int number = sc.nextInt();
		
		System.out.print("Date dd/MM/yyyy:");
		LocalDate date = LocalDate.parse(sc.next(), fmt);
		
		System.out.print("Value of Contract: ");
		double totalValue = sc.nextDouble();
		
		Contract contract = new Contract(number, date, totalValue);
		
		System.out.print("Enter the number of Installment: ");
		int n = sc.nextInt();
		
		ContractService contractService = new ContractService(new PaypalService());
		
		contractService.processContract(contract, n);
		
		System.out.println("Installments: ");
		
		for (Installment installment : contract.getInstallments()) {
			System.out.println(installment);
		}
		

	}

}
