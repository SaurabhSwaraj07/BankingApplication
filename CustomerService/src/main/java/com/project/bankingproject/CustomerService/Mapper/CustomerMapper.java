package com.project.bankingproject.CustomerService.Mapper;

import com.project.bankingproject.CustomerService.DTO.CustomerCreatedResponse;
import com.project.bankingproject.CustomerService.DTO.CustomerRequest;
import com.project.bankingproject.CustomerService.Model.Customer;
import lombok.Data;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toEntity(CustomerRequest customerRequest);

    CustomerCreatedResponse toCreateResponse(Customer saved);
//    CustomerResponse toResponse(Customer customer);

//    @BeanMapping(nullValueMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    void updateCustomerFromRequest(UpdateCustomerRequest request, @MappingTarget Customer customer);

}
