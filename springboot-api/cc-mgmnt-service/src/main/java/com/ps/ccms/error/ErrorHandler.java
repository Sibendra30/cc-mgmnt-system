package com.ps.ccms.error;

import com.ps.ccms.exception.InvalidCCNumberException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(value = {InvalidCCNumberException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Map<String, String> resourceNotFoundException(Exception ex) {
        return new HashMap() {{
            put("code", "invalidCCNumber");
            put("errorMessage", "Invalid credit card number");
        }};
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> genericExceptionhandler(Exception ex) {
        return new HashMap() {{
            put("error", "internalServerError");
            put("message", "Internal Server Error");
        }};
    }
}
