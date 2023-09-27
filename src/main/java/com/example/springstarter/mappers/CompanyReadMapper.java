package com.example.springstarter.mappers;

import com.example.springstarter.dto.CompanyReadDto;
import com.example.springstarter.entity.Company;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Component
public class CompanyReadMapper implements Mapper<Company, CompanyReadDto> {
    @Override
    public CompanyReadDto map(Company from) {
        return new CompanyReadDto(from.getName());
    }
}
