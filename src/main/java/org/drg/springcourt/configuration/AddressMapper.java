package org.drg.springcourt.configuration;

import org.drg.springcourt.dtos.responses.AddressResponseDto;
import org.drg.springcourt.models.AddressEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper {

    AddressResponseDto map(AddressEntity addressEntity);

    List<AddressResponseDto> map(List<AddressEntity> addressEntityList);


}