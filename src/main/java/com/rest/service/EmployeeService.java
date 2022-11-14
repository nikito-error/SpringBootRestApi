package com.rest.service;

import java.util.List;

import com.rest.model.Employee;

public interface EmployeeService {
	List<Employee> getEmployees();

	Employee saveEmployee(Employee employeee);

	Employee getSingleEmployee(Long id);

	void deleteEmployee(Long id);

	Employee updateEmployee(Employee employee);
	
	List<Employee> getEmployeeByName(String name);
	
	List<Employee> getEmployeeByNameAndDepartment(String name,String department);
	
	List<Employee> getEmployeeByKeyword(String name);
}
