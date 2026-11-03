package com.project.bankingproject.CustomerService.Service;

import com.project.bankingproject.CustomerService.DTO.CustomerCreatedResponse;
import com.project.bankingproject.CustomerService.DTO.CustomerRequest;
import com.project.bankingproject.CustomerService.Enum.KycStatus;
import com.project.bankingproject.CustomerService.Mapper.CustomerMapper;
import com.project.bankingproject.CustomerService.Model.Customer;
import com.project.bankingproject.CustomerService.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private  final CustomerMapper mapper;

    public CustomerCreatedResponse create(CustomerRequest request){
        Customer entity =  mapper.toEntity(request);
        entity.setActive(false);
        entity.setKycStatus(KycStatus.PENDING);
        entity.setRequestFingerprint("abc");
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        Customer saved = repository.saveAndFlush(entity);
        return mapper.toCreateResponse(saved);
    }
}

