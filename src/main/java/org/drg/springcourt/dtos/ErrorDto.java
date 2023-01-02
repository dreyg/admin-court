package org.drg.springcourt.dtos;

import lombok.Data;

@Data
public class ErrorDto {

    private String code;
    private String message;
    private String detail;

}
