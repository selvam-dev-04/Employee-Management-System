package com.example.employeemanagement.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


//--------------------------------------------------------------------------
import jakarta.persistence.Column;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;

@Entity
public class Employee
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "Name cannot be empty")
	private String name;

	@NotBlank(message = "Email cannot be empty")
	@Email(message = "Enter a valid email address")
	@Column(unique = true)
	private String email;

	@NotBlank(message = "Department cannot be empty")
	private String department;

	@Min(value = 1, message = "Salary must be greater than zero")
	private double salary;
	
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String name, String email, String department, double salary) {
		super();
		this.name = name;
		this.email = email;
		this.department = department;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}




//Default constructor: JPA/Hibernate object create panna use aagum
//Parameterized constructor: Employee details-ah object create pannumbodhu pass panna use aagum
//Getters: Private variables oda values-ah retrieve panna
//Setters: Private variables oda values-ah modify panna
