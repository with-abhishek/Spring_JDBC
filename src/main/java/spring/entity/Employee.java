package spring.entity;

import lombok.Data;

@Data
public class Employee {
	
	private int id;
	private String name;
	private String gender;
	private int salary;
	public Employee(int id, String name, String gender, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.salary = salary;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
