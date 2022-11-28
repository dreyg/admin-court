package org.drg.dtos;

import lombok.Data;
import org.drg.dtos.ErrorDto;

import java.util.List;

@Data
public class ErrorsDto {

    private List<ErrorDto> errorDtoList;

}
