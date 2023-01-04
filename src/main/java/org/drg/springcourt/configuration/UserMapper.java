package org.drg.springcourt.configuration;

import org.drg.springcourt.dtos.responses.UserResponseDto;
import org.drg.springcourt.models.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = AddressMapper.class)
public interface UserMapper {

    List<UserResponseDto> map(List<UserEntity> userEntityList);

    default UserResponseDto map(UserEntity userEntity) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(userEntity.getId());
        userResponseDto.setName(userEntity.getName());
        userResponseDto.setMail(userEntity.getMail());
        userResponseDto.setSurname(userEntity.getSurname());
        userResponseDto.setUsername(userEntity.getUsername());
        userResponseDto.setPassword(userEntity.getPassword());

        //userResponseDto.setAddress(userEntity.getAddress());

        return userResponseDto;
    }


}