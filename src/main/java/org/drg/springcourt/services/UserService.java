package org.drg.springcourt.services;

import org.drg.springcourt.dtos.requests.UserRequestDto;
import org.drg.springcourt.dtos.responses.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface UserService {

    Collection<UserResponseDto> findAll();

    UserResponseDto findById(long userId);

    UserResponseDto saveUser(UserRequestDto user);

    UserResponseDto findByUsername(String s);
}
