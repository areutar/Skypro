package ru.hogwarts.school.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnableToCreateException extends RuntimeException{
    public UnableToCreateException(Throwable cause) {
        super(cause);
    }
}
