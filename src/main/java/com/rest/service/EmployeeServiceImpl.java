package com.rest.service;

import java.util.ArrayList;
import java.util.List;

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
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

}
