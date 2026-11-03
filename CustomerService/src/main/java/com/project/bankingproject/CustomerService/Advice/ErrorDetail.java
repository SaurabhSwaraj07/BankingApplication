package com.project.bankingproject.CustomerService.Advice;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDetail {
    private String code;
    private String message;
    private String details;
}
