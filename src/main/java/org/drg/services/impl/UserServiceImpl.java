package org.drg.services.impl;

import org.drg.dtos.responses.UserResponseDto;
import org.drg.models.UserEntity;
import org.drg.repositories.UserRepository;
import org.drg.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public Collection<UserResponseDto> findAll() {
        return userRepository.findAll().stream()
                .map(user -> UserResponseDto.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .surname(user.getSurname())
                        .address(user.getAddress())
                        .username(user.getUsername())
                        .mail(user.getMail())
                        .password(user.getPassword())
                        .floor(user.getFloor())
                        .door(user.getDoor())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public void saveUser(UserEntity user) {
        userRepository.save(user);
    }
}
