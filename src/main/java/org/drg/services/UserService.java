package org.drg.services;

import org.drg.dtos.requests.UserRequestDto;
import org.drg.dtos.responses.UserResponseDto;
import org.drg.models.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface UserService {

    Collection<UserResponseDto> findAll ();

    UserResponseDto saveUser(UserRequestDto user);

    Collection<UserResponseDto> findAllUsersSameStreet(UserRequestDto userRequestStreetDto);
}
