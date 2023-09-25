package com.example.springstarter.controller;

import com.example.springstarter.dto.UserReadDto;

import com.example.springstarter.dto.UserWriteDto;
import com.example.springstarter.entity.User;
import com.example.springstarter.repository.UserRepository;
import com.example.springstarter.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    @GetMapping("/{id}")
    public UserReadDto findById(@PathVariable Long id){
        return userService.getById(id)
                .orElseThrow(RuntimeException::new);
    }

    @GetMapping("/")
    public List<UserReadDto> findAll(){
        return userService.findAll();
    }

    @PostMapping()
    public UserReadDto create(@RequestBody UserWriteDto userWriteDto){
        return userService.create(userWriteDto);
    }
}
