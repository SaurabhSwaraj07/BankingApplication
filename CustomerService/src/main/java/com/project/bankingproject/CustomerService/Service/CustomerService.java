package com.project.bankingproject.CustomerService.Service;

import com.project.bankingproject.CustomerService.DTO.CustomerCreatedResponse;
import com.project.bankingproject.CustomerService.DTO.CustomerRequest;
import com.project.bankingproject.CustomerService.Enum.KycStatus;
import com.project.bankingproject.CustomerService.Exceptions.ConflictException;
import com.project.bankingproject.CustomerService.Exceptions.ExternalIdExistsException;
import com.project.bankingproject.CustomerService.Mapper.CustomerMapper;
import com.project.bankingproject.CustomerService.Model.Customer;
import com.project.bankingproject.CustomerService.Repository.CustomerRepository;
import com.project.bankingproject.CustomerService.Util.Fingerprint;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;
    private final Fingerprint fingerprint;


    public CustomerCreatedResponse create(CustomerRequest request){

        String externalId = request.getExternalId();
        String fp = fingerprint.customerCreate(request.getFirstName(), request.getLastName(), request.getEmail(), request.getPhone(), request.getAddress());
        Optional<Customer> byExt = repository.findByExternalId(externalId);
//        if(byExt.isPresent() && byExt.get().getRequestFingerprint().equals(fp)) return mapper.toCreateResponse(byExt.get());

        if(byExt.isPresent()){
            if(byExt.get().getRequestFingerprint().equals(fp)) throw new ConflictException("User Alreaday Created Before");
            throw new ExternalIdExistsException("External Id Occupied by another user");
        }

        Customer entity =  mapper.toEntity(request);
        entity.setActive(false);
        entity.setKycStatus(KycStatus.PENDING);
        entity.setRequestFingerprint(fp);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        Customer saved = repository.saveAndFlush(entity);
        return mapper.toCreateResponse(saved);
    }
}

