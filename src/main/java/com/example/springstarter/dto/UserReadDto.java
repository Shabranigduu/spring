package com.example.springstarter.dto;

import com.example.springstarter.entity.Company;
import lombok.Value;

import java.time.LocalDate;

@Value
public class UserReadDto {

    String username;
    LocalDate birthDate;
    String firstname;
    String lastname;
    CompanyReadDto companyReadDto;

}
