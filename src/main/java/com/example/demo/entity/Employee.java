package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

	@Entity
	@Table(name = "employees")
	public class Employee {
	    @Id
	    @GeneratedValue(strategy  = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(nullable = false)
	    private String name;

	    @Column(nullable = false)
	    private String department;

	    @Column
	    @Min(value = 18, message = "Age must be at least 18")
	    private int age;

	    @Column
	    @Email(message = "Email should be valid")
	    @NotBlank(message = "Email is required")
	    private String email;
	    
	    @Column
	    @DecimalMin(value = "30000.00")
	    private BigDecimal salary;

	    
	    @Column
	    @CreatedDate
	    private LocalDateTime createdAt;

	    @Column
	    @LastModifiedDate
	    private LocalDateTime updatedAt;
	    
	    
	    public Employee()
	    {
	    	
	    }
		public Employee(Long id, String name, String department,
				@Min(value = 18, message = "Age must be at least 18") int age,
				@Email(message = "Email should be valid") @NotBlank(message = "Email is required") String email,
				@DecimalMin("30000.00") BigDecimal salary, LocalDateTime createdAt, LocalDateTime updatedAt) {
			super();
			this.id = id;
			this.name = name;
			this.department = department;
			this.age = age;
			this.email = email;
			this.salary = salary;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public BigDecimal getSalary() {
			return salary;
		}

		public void setSalary(BigDecimal salary) {
			this.salary = salary;
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}

		public LocalDateTime getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(LocalDateTime updatedAt) {
			this.updatedAt = updatedAt;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", age=" + age + ", email="
					+ email + ", salary=" + salary + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
		}

		
		

}
