package org.drg.springcourt.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "User with format mail not valid")
public class ConstraintViolationException extends RuntimeException {

    private static final long serialVersionUID = -5763510899245664744L;

}
