package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	 private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
//	@Cacheable(value = "employee")
	public List<Employee> getEmployees() {
		logger.info("fetching all employees data");
		List<Employee> emp = (List<Employee>) employeeRepository.findAll();
		return (emp.size() > 0 ? emp : null);
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		logger.info("create employee {}", employee);
		employee.setUpdatedAt(LocalDateTime.now());
		employee.setCreatedAt(LocalDateTime.now());
		return employeeRepository.save(employee);
	}

	@Override
	public Optional<Employee> updateEmployeeById(Long id, Employee updatedEmployee) {
		logger.info("update employee by id {}", id);
		return employeeRepository.findById(id).map(employee -> {
			employee.setName(updatedEmployee.getName());
			employee.setEmail(updatedEmployee.getEmail());
			employee.setDepartment(updatedEmployee.getDepartment());
			employee.setAge(updatedEmployee.getAge());
			employee.setSalary(updatedEmployee.getSalary());
			employee.setUpdatedAt(LocalDateTime.now());
			return employeeRepository.save(employee);
		});
	}

	@Override
//	@Caching( evict = {@CacheEvict(value = "employee", allEntries = true), @CacheEvict(value="employee", key="#id")
//			}) 
	public void deleteEmployeeById(Long id) {
		logger.info("delete employee by id {}", id);
		employeeRepository.deleteById(id);
	}

	@Override
	@Cacheable(value = "employee", key = "#id")
	public Employee getEmployeeById(Long id) {
		logger.info("fetch employee by id {}", id);
		return employeeRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));
	}

	@Override
	public Page<Employee> getAllEmployees(Pageable pageable) {
		logger.info("fetch employee using pagination  {}", pageable);
		return employeeRepository.findAll(pageable);
	}

	@Override
	public List<Employee> searchByNameOrDepartment(String query) {
		logger.info("fetch employee by query {}", query);
		return employeeRepository.searchByNameOrDepartment(query);

	}

}
