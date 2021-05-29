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
        return new HashMap(){{put("invalidCCNumber", "Invalid credit card number");}};
    }
}
