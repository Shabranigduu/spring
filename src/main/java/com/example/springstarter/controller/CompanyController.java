package com.example.springstarter.controller;

import com.example.springstarter.dto.CompanyReadDto;
import com.example.springstarter.dto.CompanyWriteUpdateDto;
import com.example.springstarter.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/{id}")
    public CompanyReadDto getById(@PathVariable Integer id) {
        return companyService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyReadDto create(@RequestBody @Validated CompanyWriteUpdateDto companyWriteUpdateDto) {
        return companyService.create(companyWriteUpdateDto);
    }

    @GetMapping()
    public List<CompanyReadDto> getAll() {
        return companyService.getAll();
    }

    @PutMapping("/{id}")
    public CompanyReadDto update(@PathVariable @RequestBody Integer id, CompanyWriteUpdateDto companyWriteUpdateDto) {
        return companyService.update(id, companyWriteUpdateDto);
    }
}
