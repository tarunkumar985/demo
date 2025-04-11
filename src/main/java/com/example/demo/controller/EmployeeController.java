package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@GetMapping
	public List<Employee> getEmployees() {
		return empService.getEmployees();
	}

	@PostMapping
	public Employee createEmployee(@RequestBody @Valid Employee emp) {
		return empService.saveEmployee(emp);

	}

	@PutMapping("/{id}")
	public Optional<Employee> updateEmployeeById(@PathVariable Long id, @RequestBody @Valid Employee updatedEmployee) {
		return empService.updateEmployeeById(id, updatedEmployee);

	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		empService.deleteEmployeeById(id);

	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		return empService.getEmployeeById(id);

	}

	@GetMapping("/custom")
	public Page<Employee> getCustomEmployees(
			@PageableDefault(page = 0, size = 5, sort = "name", direction = Direction.ASC) Pageable pageable) {
		return empService.getAllEmployees(pageable);
	}

	@GetMapping("/search")
	public List<Employee> searchEmployees(@RequestParam String query) {
		return empService.searchByNameOrDepartment(query);
	}

}