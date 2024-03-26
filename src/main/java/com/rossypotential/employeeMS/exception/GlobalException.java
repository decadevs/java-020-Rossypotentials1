package com.rossypotential.employeeMS.exception;

import com.rossypotential.employeeMS.exception.GlobalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

public class GlobalException {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorDetails> EmployeeNotFoundException(final EmployeeNotFoundException e) {
        ErrorDetails errorResponse = new ErrorDetails();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setErrorDetails(String.valueOf(HttpStatus.BAD_REQUEST));
        errorResponse.setErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
