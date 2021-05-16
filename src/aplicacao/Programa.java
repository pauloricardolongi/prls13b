package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Entre com o nome do departamento:");
		String departmentName = sc.nextLine();

		System.out.print("Entre com os dados do trabalhador:");
		System.out.print("Nome:");

		String workerName = sc.nextLine();
		System.out.print("Nivel:");
		String workerLevel = sc.nextLine();
		System.out.print("Salário Base:");
		double baseSalary = sc.nextDouble();
		// instanciar o trabalhador

		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary,
				new Departament(departmentName));
		System.out.print("Quantos contratos este trabalhador vai ter");
		int n = sc.nextInt();
		for (int i = 1; i < n; i++) {
			System.out.println("Entre contratos #" + i + "data:");
			System.out.print("Date (DD/MM/YYYY):");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Valor por hora");
			double valuePerHour= sc.nextDouble();
			System.out.print("Duração(hora)");
			int hours= sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		System.out.println();
		System.out.print("Entre com o mês e ano para calcular o salário(MM/YYYY):");
		String monthAndYear= sc.next();
		int month= Integer.parseInt(monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println(" Nome: " + worker.getName());
        System.out.println("Departamento:" + worker.getDepartment().getName());
        System.out.println("Quanto trabalhador ganhou: "+ monthAndYear + ": " + 
        String.format("%.2f", worker.income(year, month)));
        
		sc.close();

	}

}
