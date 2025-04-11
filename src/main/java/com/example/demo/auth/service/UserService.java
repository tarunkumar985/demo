package com.example.demo.auth.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.auth.dto.UserRequestDTO;
import com.example.demo.auth.dto.UserResponseDTO;
import com.example.demo.auth.entity.Users;
import com.example.demo.auth.mapper.UserMapper;
import com.example.demo.auth.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private UserRepo repo;


    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    
    
    
    
    @Autowired
    private UserMapper userMapper;

    public UserResponseDTO register(UserRequestDTO requestDTO) {
        Users users = userMapper.toEntity(requestDTO);
        users.setPassword(encoder.encode(users.getPassword()));
        Users saved = repo.save(users);
        return userMapper.toDTO(saved);
    }
    
    

    public String verify(Users user) {    	
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        } else {
            return "fail";
        }
    }
}
