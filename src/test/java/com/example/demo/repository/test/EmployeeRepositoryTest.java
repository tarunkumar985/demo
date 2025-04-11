package com.example.demo.repository.test;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void testSearchByNameOrDepartment() {
    	BigDecimal salary = new BigDecimal(55000.00);
        Employee emp1 = new Employee(null, "John Doe", "Sales", 35, "test@email.com", salary, LocalDateTime.now(), LocalDateTime.now());
        Employee emp2 = new Employee(null, "Jane Smith", "Marketing", 32,"test2@email.com", salary, LocalDateTime.now(), LocalDateTime.now());
        employeeRepository.saveAll(List.of(emp1, emp2));
        List<Employee> found = employeeRepository.searchByNameOrDepartment("sales");
        assertEquals(1, found.size());
        assertEquals("John Doe", found.get(0).getName());
    }
}
