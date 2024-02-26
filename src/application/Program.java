package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter department's name: ");
		String department = sc.nextLine();
		
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Level: ");
		String level = sc.next();
		
		System.out.print("Base Salary: ");
		Double basesalary = sc.nextDouble();
		
		Worker 	worker = new Worker(name, WorkerLevel.valueOf(level), basesalary, new Department(department));
		System.out.println();
		
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Enter contract #"+(i+1)+ " data:");
			
			System.out.print("Date (DD/MM/YYYY): ");
			String data1 = sc.next();
			LocalDate contractDate = LocalDate.parse(data1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			System.out.print("Value per hour: ");
			double vPerHour = sc.nextDouble();
			
			System.out.print("Duration (hours): ");
			int duration = sc.nextInt();
			
			HourContract contract = new HourContract(contractDate, vPerHour, duration);
			worker.addContract(contract);
		}
		
		System.out.println();
		
		System.out.println("Enter month and year to calculate income (MM/YYYY): ");
		String date2 = sc.next();
		int month = Integer.parseInt(date2.substring(0, 2));
		int year = Integer.parseInt(date2.substring(3));
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + date2 + ": " + String.format("%.2f", worker.income(year, month)));
		
		sc.close();
		
	}

}
