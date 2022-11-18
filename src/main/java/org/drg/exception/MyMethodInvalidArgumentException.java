package org.drg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public final class MyMethodInvalidArgumentException extends RuntimeException {

    public MyMethodInvalidArgumentException() {
        super();
    }

    public MyMethodInvalidArgumentException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public MyMethodInvalidArgumentException(final String message) {
        super(message);
    }

    public MyMethodInvalidArgumentException(final Throwable cause) {
        super(cause);
    }

}
