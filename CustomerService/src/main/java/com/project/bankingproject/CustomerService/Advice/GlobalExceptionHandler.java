package com.project.bankingproject.CustomerService.Advice;

import com.project.bankingproject.CustomerService.Exceptions.ConflictException;
import com.project.bankingproject.CustomerService.Exceptions.ExternalIdExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorDetail> handleConflictException(ConflictException ex){
        ErrorDetail globalError = ErrorDetail.builder()
                .code("CONFLICT")
                .message(ex.getMessage())
                .details(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(globalError);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDetail> handleExternalIdAlreadyExists(ExternalIdExistsException ex){
        ErrorDetail globalError = ErrorDetail.builder()
                .code("CONFLICT")
                .message(ex.getMessage())
                .details(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(globalError);
    }
}
