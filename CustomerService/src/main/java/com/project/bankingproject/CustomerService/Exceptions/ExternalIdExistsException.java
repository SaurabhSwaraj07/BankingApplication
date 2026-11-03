package com.project.bankingproject.CustomerService.Exceptions;

public class ExternalIdExistsException extends RuntimeException{
    public ExternalIdExistsException(String message){
        super(message);
    }
}
