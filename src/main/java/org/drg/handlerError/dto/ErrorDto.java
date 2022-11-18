package org.drg.handlerError.dto;

import lombok.Data;

@Data
public class ErrorDto {

    private String code;
    private String message;
    private String detail;

}
