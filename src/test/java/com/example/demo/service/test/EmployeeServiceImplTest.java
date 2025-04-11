package com.example.demo.service.test;

import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private Employee sampleEmp;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sampleEmp = new Employee();
        sampleEmp.setId(1L);
        sampleEmp.setName("Alice");
        sampleEmp.setDepartment("IT");
    }

    @Test
    void testGetEmployees() {
        when(employeeRepository.findAll()).thenReturn(List.of(sampleEmp));
        List<Employee> employees = employeeService.getEmployees();
        assertEquals(1, employees.size());
        verify(employeeRepository).findAll();
    }

    @Test
    void testSaveEmployee() {
        when(employeeRepository.save(any(Employee.class))).thenReturn(sampleEmp);
        Employee saved = employeeService.saveEmployee(sampleEmp);
        assertNotNull(saved);
        assertEquals("Alice", saved.getName());
    }

    @Test
    void testGetEmployeeByIdFound() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(sampleEmp));
        Employee found = employeeService.getEmployeeById(1L);
        assertEquals("Alice", found.getName());
    }

    @Test
    void testGetEmployeeByIdNotFound() {
        when(employeeRepository.findById(2L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> employeeService.getEmployeeById(2L));
    }

    @Test
    void testDeleteEmployeeById() {
        employeeService.deleteEmployeeById(1L);
        verify(employeeRepository).deleteById(1L);
    }

    @Test
    void testSearchByNameOrDepartment() {
        when(employeeRepository.searchByNameOrDepartment("IT")).thenReturn(List.of(sampleEmp));
        List<Employee> results = employeeService.searchByNameOrDepartment("IT");
        assertEquals(1, results.size());
    }
}
