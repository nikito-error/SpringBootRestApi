package com.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Employee>> getEmployees() {
		return new ResponseEntity<List<Employee>>(eService.getEmployees(),HttpStatus.OK);
	}

	@GetMapping("employees/{id}")
	public ResponseEntity<Employee> getEmployeesById(@PathVariable Long id) {
		return new ResponseEntity<Employee>(eService.getSingleEmployee(id),HttpStatus.OK);
	}

	@DeleteMapping("employees")
	public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam Long id) {
		eService.deleteEmployee(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(eService.saveEmployee(employee),HttpStatus.CREATED);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		employee.setId(id);
		return new ResponseEntity<Employee>(eService.updateEmployee(employee),HttpStatus.OK);
	}
	
	@GetMapping("/employees/filterName")
	public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name){
		return new ResponseEntity<List<Employee>>(eService.getEmployeeByName(name),HttpStatus.OK);
	}
	
	@GetMapping("/employees/filterNameAndDepartment")
	public ResponseEntity<List<Employee>> getEmployeesByNameAndDepartment(@RequestParam String name,@RequestParam String department){
		return new ResponseEntity<List<Employee>>(eService.getEmployeeByNameAndDepartment(name,department),HttpStatus.OK);
	}
	@GetMapping("/employees/filterNameLike")
	public ResponseEntity<List<Employee>> getEmployeesByKeywords(@RequestParam String name){
		return new ResponseEntity<List<Employee>>(eService.getEmployeeByKeyword(name),HttpStatus.OK);
	}
	

}
