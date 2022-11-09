package com.rest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Employee;

@RestController //@Controller + @ResponseBody
public class EmployeeController {
	@GetMapping("/employees")
	public String getEmployees() {
		return "display the list of employees";
	}
	@GetMapping("employees/{id}")
	public String getEemployeesById(@PathVariable Long id) {
		return "send the employee id "+id;
	}
	@DeleteMapping("employees")
	public String deleteEmployee(@RequestParam Long id) {
		return "DeleteEmployee with id " + id;
	}
	@PostMapping("/employees")
	public String saveEmployee(@RequestBody Employee employee) {
		return "Save employee details to database "+employee;
	}

}
