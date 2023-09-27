package com.example.springstarter.repository;

import com.example.springstarter.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CompanyRepository extends JpaRepository<Company, Integer> {
}

