package com.javasteams;

import java.util.Arrays;
import java.util.List;

class Employee {
	int id;
	String name;
	int sal;

	public Employee(int id, String name, int sal) {
		this.id = id;
		this.name = name;
		this.sal = sal;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", sal=" + sal + "]";
	}

}

public class MapFilterTogether {

	public static void main(String[] args) {

		List<Employee> employeeList = Arrays.asList(new Employee(101,"John",25000),
				new Employee(102,"Adam",20000),
				new Employee(103,"Bond",45000),
				new Employee(104,"Mike",15000),
				new Employee(105,"Chris",125000));
		
		employeeList.stream()
		.filter(e->e.sal>25000)
		.map(e->e.sal+10000)
		.forEach(System.out::println);
	}

	
}
