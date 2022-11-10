package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Employee;
import com.rest.service.EmployeeService;

//@RequestMapping("/api/v1")  - address from localhost:8080 become localhost:8080/api/v1
// another path to do it in application properties and write server.servlet.context-path=/api/v1
@RestController // @Controller + @ResponseBody
public class EmployeeController {

	@Autowired
	private EmployeeService eService;

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return eService.getEmployees();
	}

	@GetMapping("employees/{id}")
	public String getEemployeesById(@PathVariable Long id) {
		return "send the employee id " + id;
	}

	@DeleteMapping("employees")
	public String deleteEmployee(@RequestParam Long id) {
		return "DeleteEmployee with id " + id;
	}

	@PostMapping("/employees")
	public String saveEmployee(@RequestBody Employee employee) {
		return "Save employee details to database " + employee;
	}

	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		System.out.println("updating the employee data with id " + id);
		return employee;
	}

}
