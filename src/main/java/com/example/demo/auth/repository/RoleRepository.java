package com.example.demo.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.auth.entity.Role;

public interface RoleRepository extends JpaRepository<Role, String> {}