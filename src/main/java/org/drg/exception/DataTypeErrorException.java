package org.drg.exception;

import lombok.Data;
import org.drg.handlerError.dto.ErrorsDto;

import java.util.List;

@Data
public class DataTypeErrorException extends RuntimeException{


    private List<ErrorsDto> errors;
    private Integer code;

    public DataTypeErrorException() {super(); }

    public static DataTypeErrorException create(List<ErrorsDto> errors){
        DataTypeErrorException obj = new DataTypeErrorException();
        obj.setErrors(errors);
        return obj;
    }

}
