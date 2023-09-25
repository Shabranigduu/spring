package com.example.springstarter.mappers;

import com.example.springstarter.dto.UserWriteDto;
import com.example.springstarter.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserWriteMapper implements Mapper<UserWriteDto, User> {

    @Override
    public User map(UserWriteDto from) {
        return User.builder()
                .username(from.getUsername())
                .birthDate(from.getBirthDate())
                .firstname(from.getFirstname())
                .lastname(from.getLastname())
                .build();
    }
}
