package com.rest.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.model.Employee;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
	List<Employee> findByName(String name);

	// SELECT * FROM table WHERE name="Hulk" AND department="6";
	List<Employee> findByNameAndDepartment(String name, String department);

	// SELECT * FROM table WHERE name LIKE %ram%
	List<Employee> findByNameContaining(String keyword, Sort sort);

	@Query("From Employee Where department=:department")
	List<Employee> getEmployeeByDepartment(String department);

	@Transactional
	@Modifying
	@Query("Delete From Employee Where name=:name")
	Integer deleteEmployeeByName(String name);
}
