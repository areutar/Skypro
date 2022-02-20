package ru.hogwarts.school.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnableToDeleteException extends ApiException {
    public UnableToDeleteException(String message) {
        super(message);
    }

    public UnableToDeleteException(String message, Throwable cause) {
        super(message, cause);
    }
}
