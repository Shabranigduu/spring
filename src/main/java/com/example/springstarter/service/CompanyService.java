package com.example.springstarter.service;

import com.example.springstarter.dto.CompanyReadDto;
import com.example.springstarter.dto.CompanyWriteUpdateDto;
import com.example.springstarter.mappers.CompanyReadMapper;
import com.example.springstarter.mappers.CompanyWriteUpdateMapper;
import com.example.springstarter.repository.CompanyRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyWriteUpdateMapper companyWriteUpdateMapper;
    private final CompanyReadMapper companyReadMapper;

    public CompanyReadDto getById(Integer id) {
        return companyRepository.findById(id)
                .map(companyReadMapper::map)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public CompanyReadDto create(CompanyWriteUpdateDto companyWriteUpdateDto) {
        return Optional.of(companyWriteUpdateDto)
                .map(companyWriteUpdateMapper::map)
                .map(companyRepository::save)
                .map(companyReadMapper::map)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE));
    }

    public List<CompanyReadDto> getAll() {
        return companyRepository.findAll().stream()
                .map(companyReadMapper::map)
                .toList();
    }

    public CompanyReadDto update(Integer id, CompanyWriteUpdateDto companyWriteUpdateDto) {
        return companyRepository.findById(id)
                .map(entity -> companyWriteUpdateMapper.map(companyWriteUpdateDto, entity))
                .map(companyRepository::saveAndFlush)
                .map(companyReadMapper::map)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
