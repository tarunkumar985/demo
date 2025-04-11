package com.example.demo.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.auth.dto.UserRequestDTO;
import com.example.demo.auth.dto.UserResponseDTO;
import com.example.demo.auth.entity.Users;
import com.example.demo.auth.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService service;


    @PostMapping("/register")
    public UserResponseDTO register(@RequestBody UserRequestDTO requestDTO) {
        return service.register(requestDTO);

    }

    @PostMapping("/login")
    public String login(@RequestBody Users user) {

        return service.verify(user);
    }
}
