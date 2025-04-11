package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.entity.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees();

	public Employee saveEmployee(Employee empemp);

	public Optional<Employee> updateEmployeeById(Long id, Employee updatedEmployee);

	public void deleteEmployeeById(Long id);

	public Employee getEmployeeById(Long id);

	public Page<Employee> getAllEmployees(Pageable pageable);

	public List<Employee> searchByNameOrDepartment(String query);

}
