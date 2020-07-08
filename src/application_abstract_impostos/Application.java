package application_abstract_impostos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Application {	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<Pessoa> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.print("Individual or company ? (i/c): ");
			sc.nextLine();
			char chr = sc.next().charAt(0);
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.print("Anual income: ");
			double ai = sc.nextDouble();
			
			if (chr == 'i') {
				System.out.print("Health expenditures: ");
				double he = sc.nextDouble();
				
				list.add(new PessoaFisica(name, ai, he));
				
			} else {
				System.out.print("Number of employees:");
				int ne = sc.nextInt();
				list.add(new PessoaJuridica(name, ai, ne));
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID: ");
		double sum = 0.0;
		for (Pessoa p : list) {
			System.out.println(p.getNome() + " $" + String.format("%.2f", p.imposto()));
			sum += p.imposto();
		}
		
		System.out.println("TOTAL TAXES: " + String.format("%.2f",sum));
		
		sc.close();
	}
	
}
