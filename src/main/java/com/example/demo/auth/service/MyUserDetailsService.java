package com.example.demo.auth.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.auth.entity.Users;
import com.example.demo.auth.repository.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;


//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Users user = userRepo.findByUsername(username);
//        if (user == null) {
//            System.out.println("User Not Found");
//            throw new UsernameNotFoundException("user not found");
//        }
//        
//        return new UserPrincipal(user);
//    }
    
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Users user = userRepo.findByUsername(username);
    	 if (user == null) {
           throw new UsernameNotFoundException("user not found");
       }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream()
                    .map(role -> new SimpleGrantedAuthority(role.getName()))
                    .collect(Collectors.toSet())
        );
    }
}
