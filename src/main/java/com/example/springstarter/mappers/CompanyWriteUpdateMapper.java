package com.example.springstarter.mappers;

import com.example.springstarter.dto.CompanyReadDto;
import com.example.springstarter.dto.CompanyWriteUpdateDto;
import com.example.springstarter.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyWriteUpdateMapper implements Mapper<CompanyWriteUpdateDto, Company> {
    @Override
    public Company map(CompanyWriteUpdateDto from) {
        return Company.builder()
                .name(from.getName())
                .build();
    }

    @Override
    public Company map(CompanyWriteUpdateDto from, Company toObject) {
        toObject.setName(from.getName());
        return toObject;
    }
}
