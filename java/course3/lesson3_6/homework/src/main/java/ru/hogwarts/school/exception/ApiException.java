package ru.hogwarts.school.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ApiException extends RuntimeException {
    public static final String UNABLE_TO_UPDATE = "Unable to update exception";
    public static final String UNABLE_TO_CREATE = "Unable to create exception";
    public static final String UNABLE_TO_UPLOAD = "Unable to upload file exception";
    public static final String FIRST_AGE_MORE_THAN_SECOND_ERROR =
            "The second age value must be no less than the first!";
    public static final String ALL_FIELDS_ARE_NULL = "At least one field must not be null!";
    protected final transient Logger logger = Logger.getLogger(String.valueOf(ApiException.class));

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Level level) {
        super(message);
        logger.log(level, message);
    }

}