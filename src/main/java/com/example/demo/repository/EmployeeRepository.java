package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository
	public interface EmployeeRepository 
				extends JpaRepository<Employee, Long> {
	
	@Query("SELECT e FROM Employee e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :query, '%')) " +
	           "OR LOWER(e.department) LIKE LOWER(CONCAT('%', :query, '%'))")
	    List<Employee> searchByNameOrDepartment(@Param("query") String query);

	}


