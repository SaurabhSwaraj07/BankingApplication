package com.project.bankingproject.CustomerService.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerRequest {
    @NotBlank
    @Size(max=80)
    private String firstName;

    @NotBlank
    @Size(max=80)
    private String lastName;

    @Email @NotBlank @Size(max=254)
    private String email;

    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Phone number must be a valid 10-digit Indian mobile number")
    private String phone;

    @NotBlank @Size(max=512)
    private String address;

    @NotBlank @Size
    private String externalId;

}
