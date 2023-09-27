package com.example.springstarter.repository;

import com.example.springstarter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM users u JOIN company c ON u.company_id = c.id WHERE c.name = :name",
    nativeQuery = true)
    public List<User> findAllByCompanyName(String name);
}
