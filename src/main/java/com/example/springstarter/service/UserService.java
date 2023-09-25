package com.example.springstarter.service;

import com.example.springstarter.dto.UserReadDto;
import com.example.springstarter.dto.UserWriteDto;
import com.example.springstarter.mappers.UserReadMapper;
import com.example.springstarter.mappers.UserWriteMapper;
import com.example.springstarter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserReadMapper userReadMapper;
    private final UserWriteMapper userWriteMapper;

    public Optional<UserReadDto> getById(Long id) {
        return userRepository.findById(id).map(userReadMapper::map);

    }

    public List<UserReadDto> findAll() {
        return userRepository.findAll().stream()
                .map(userReadMapper::map)
                .toList();
    }

    public UserReadDto create(UserWriteDto userWriteDto) {
        return Optional.of(userWriteDto)
                .map(userWriteMapper::map)
                .map(userRepository::save)
                .map(userReadMapper::map)
                .orElseThrow(RuntimeException::new);
    }
}
