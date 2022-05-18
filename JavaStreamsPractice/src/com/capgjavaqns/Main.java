package com.capgjavaqns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		List<EmployeeUS> employees = Arrays.asList(
				new EmployeeUS("Andrew",20,25000),
				new EmployeeUS("Bond",19,35000),
				new EmployeeUS("Chris",30,45000),
				new EmployeeUS("David",18,15000),
				new EmployeeUS("Frank",26,18000));

		//Sorting using Lambda expression
		System.out.println("Sorted Employee list by Salary_Using Lambda expression");
		
		employees.stream().sorted((o1,o2)->(int)o1.getSalary()-(int)o2.getSalary()).forEach(System.out::println);
		
		// Update Salary based on Age_Increment by 50%
		System.out.println("Before Salary Increment");
		System.out.println(employees);
		System.out.println("=============");
		System.out.println("After Salary Increment by 50%");
		employees.stream().
		filter(e->e.getAge()>25).
		map(e->{
			e.setSalary(e.getSalary()*1.5);
			return e;}).forEach(System.out::println);


		System.out.println("=============");

		// Sorting employees by Salary using Comparator
		System.out.println("Sorted Employee list by Salary _ Using Comparator");
		List<EmployeeUS> list_emp = employees.stream().sorted(new Comparator<EmployeeUS>() {

		@Override
		public int compare(EmployeeUS e1, EmployeeUS e2){
			return (int)e1.getSalary()-(int)e2.getSalary();
		}
		}).collect(Collectors.toList());

		System.out.println(list_emp);
}

}
