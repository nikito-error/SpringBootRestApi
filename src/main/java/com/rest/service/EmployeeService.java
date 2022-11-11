package com.rest.service;

import java.util.List;

import com.rest.model.Employee;

public interface EmployeeService {
	List<Employee> getEmployees();

	Employee saveEmployee(Employee employeee);

	Employee getSingleEmployee(Long id);

	void deleteEmployee(Long id);

	Employee updateEmployee(Employee employee);
}
