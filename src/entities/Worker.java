package entities;

import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Departament department;
	//lista pois são vários contratos
	private List<HourContract> contracts;
	
	public Worker() {
		
	}
	//não marcar atributos que sejam da lista, ex.contracts

	public Worker(String name, WorkerLevel level, Double baseSalary, Departament department) {
	
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

}
