package com.luizreis.ecommerce.infrastructure.api.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class SignupRequest {

    @NotBlank
    private String fullName;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String zipCode;
    private String complement;
    private String number;

    public SignupRequest(String fullName, String email, String password, String phoneNumber, String zipCode, String complement, String number) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.zipCode = zipCode;
        this.complement = complement;
        this.number = number;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getComplement() {
        return complement;
    }

    public String getNumber() {
        return number;
    }
}
