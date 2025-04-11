package com.example.demo.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.demo.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private String jwtToken;

    @BeforeEach
    void setUp() {
        jwtToken = "Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbGljZSIsImlhdCI6MTc0NDM1NjIwMywiZXhwIjoxNzQ0MzU2MzExfQ.k36_OC_AIhuINvI1x1cWd2AevK5kaKizVeRqNUsjWXI";
    }

    @Test
    void testDeleteEmployeeWithJwtAuth() throws Exception {
        // First create an employee to delete
        Employee emp = new Employee(null, "TestDelete", "QA", 35, "test@email.com", null, null, null);
        String empJson = objectMapper.writeValueAsString(emp);

        MvcResult result = mockMvc.perform(post("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(empJson))
            .andExpect(status().isOk())
            .andReturn();

        Employee created = objectMapper.readValue(result.getResponse().getContentAsString(), Employee.class);

        // Now delete with admin token
        mockMvc.perform(delete("/api/employees/" + created.getId())
                .header("Authorization", jwtToken))
            .andExpect(status().isOk());
    }
}
