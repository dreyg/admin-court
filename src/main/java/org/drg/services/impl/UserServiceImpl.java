package org.drg.services.impl;

import org.drg.dtos.requests.UserRequestDto;
import org.drg.dtos.responses.UserResponseDto;
import org.drg.exceptions.UserWithSameUsernameException;
import org.drg.models.UserEntity;
import org.drg.repositories.UserRepository;
import org.drg.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /*@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;*/


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
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto saveUser(UserRequestDto userRequestDto) {
        if (this.userRepository.existsByUsername(userRequestDto.getUsername())) {
            throw new UserWithSameUsernameException();
        }
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(userRequestDto, user);
        //TODO user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user = this.userRepository.save(user);
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .address(user.getAddress())
                .username(user.getUsername())
                .mail(user.getMail())
                .password(user.getPassword())
                .floor(user.getFloor())
                .door(user.getDoor())
                .build();
    }

    @Override
    public Collection<UserResponseDto> findAllUsersSameStreet(UserRequestDto userRequestStreetDto) {
        Collection<UserResponseDto> usersWithSameStreet = userRepository.findAll().stream()
                .filter(userEntity -> userEntity.getAddress().contains(userRequestStreetDto.getAddress()))
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

        return usersWithSameStreet;
    }


}
