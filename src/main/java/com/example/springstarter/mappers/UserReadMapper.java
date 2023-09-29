package com.example.springstarter.mappers;

import com.example.springstarter.dto.CompanyReadDto;
import com.example.springstarter.dto.UserReadDto;
import com.example.springstarter.entity.Company;
import com.example.springstarter.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserReadMapper implements Mapper<User, UserReadDto> {
    private final CompanyReadMapper companyReadMapper;

    @Override
    public UserReadDto map(User from) {
        CompanyReadDto companyReadDto = Optional.ofNullable(from.getCompany())
                .map(companyReadMapper::map)
                .orElse(null);

        return new UserReadDto(from.getUsername(), from.getBirthDate(), from.getFirstname(), from.getLastname(), companyReadDto);
    }
}
