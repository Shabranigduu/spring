package com.example.springstarter.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class CompanyWriteUpdateDto {
    @NotNull
    String name;
}
