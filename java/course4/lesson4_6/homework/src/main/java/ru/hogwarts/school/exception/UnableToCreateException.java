package ru.hogwarts.school.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.apache.logging.log4j.Level;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnableToCreateException extends ApiException {
    public UnableToCreateException(Throwable cause) {
        super(UNABLE_TO_CREATE, cause, Level.ERROR);
    }
}