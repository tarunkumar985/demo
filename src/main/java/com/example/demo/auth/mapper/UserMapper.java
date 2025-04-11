package com.example.demo.auth.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.auth.dto.UserRequestDTO;
import com.example.demo.auth.dto.UserResponseDTO;
import com.example.demo.auth.entity.Users;

@Mapper(componentModel  = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    Users toEntity(UserRequestDTO dto);

    UserResponseDTO toDTO(Users user);
}
