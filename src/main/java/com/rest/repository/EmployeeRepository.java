package com.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<Employee> findByName(String name);

	// SELECT * FROM table WHERE name="Hulk" AND department="6";
	List<Employee> findByNameAndDepartment(String name, String department);
	
	//SELECT * FROM table WHERE name LIKE %ram%
	List<Employee> findByNameContaining(String keyword);
}
