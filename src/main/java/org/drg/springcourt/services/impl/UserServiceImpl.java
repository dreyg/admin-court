package org.drg.springcourt.services.impl;

import org.drg.springcourt.configuration.UserMapper;
import org.drg.springcourt.dtos.requests.UserRequestDto;
import org.drg.springcourt.dtos.responses.UserResponseDto;
import org.drg.springcourt.exceptions.UserNotFoundException;
import org.drg.springcourt.exceptions.UserWithSameUsernameException;
import org.drg.springcourt.models.UserEntity;
import org.drg.springcourt.repositories.UserRepository;
import org.drg.springcourt.services.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public Collection<UserResponseDto> findAll() {
        return this.userRepository.findAll().stream()
                .map(user -> userMapper.map(user))
                .collect(Collectors.toList());
    }

    public UserResponseDto findById(long userId) {
        UserEntity user = this.userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        return UserResponseDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .mail(user.getMail())
                .build();
    }

    public UserResponseDto findByUsername(String username) {
        UserEntity user = this.userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        return UserResponseDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .mail(user.getMail())
                .build();
    }

    @Override
    public UserResponseDto saveUser(UserRequestDto userRequestDto) {
        if (Boolean.TRUE.equals(this.userRepository.existsByUsername(userRequestDto.getUsername()))) {
            throw new UserWithSameUsernameException();
        }
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(userRequestDto, user);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user = this.userRepository.save(user);
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .username(user.getUsername())
                .mail(user.getMail())
                .password(user.getPassword())
                //.address(user.getAddress())
                .build();
    }

}
