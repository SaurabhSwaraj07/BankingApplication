package com.project.bankingproject.CustomerService.DTO;

import com.project.bankingproject.CustomerService.Enum.KycStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomerCreatedResponse {

    private String externalId;
    private KycStatus kycStatus;
    private Integer version;
    private LocalDateTime createdAt;

}

