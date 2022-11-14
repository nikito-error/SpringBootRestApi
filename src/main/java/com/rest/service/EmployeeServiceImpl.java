package com.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.model.Employee;
import com.rest.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getEmployees() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}

	@Override
	public Employee getSingleEmployee(Long id) {

		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		}
		throw new RuntimeException("Employee is not present with id " + id);

	}

	@Override
	public void deleteEmployee(Long id) {

		employeeRepository.deleteById(id);
	}

	@Override
	public Employee updateEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {

		return employeeRepository.findByName(name);
	}

	@Override
	public List<Employee> getEmployeeByNameAndDepartment(String name, String department) {
		return employeeRepository.findByNameAndDepartment(name, department);
	}

	@Override
	public List<Employee> getEmployeeByKeyword(String name) {
		return employeeRepository.findByNameContaining(name);
	}
	

}
