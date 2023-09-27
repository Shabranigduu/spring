package com.example.springstarter.controller;

import com.example.springstarter.dto.UserReadDto;

import com.example.springstarter.dto.UserWriteUpdateDto;
import com.example.springstarter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    @GetMapping("/{id}")
    public UserReadDto findById(@PathVariable Long id){
        return userService.getById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping()
    public List<UserReadDto> findAll(){
        return userService.findAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UserReadDto create(@RequestBody @Validated UserWriteUpdateDto userWriteUpdateDto){
        return userService.create(userWriteUpdateDto);
    }

    @PutMapping("/{id}")
    public UserReadDto update(@PathVariable Long id,
                              @RequestBody @Validated UserWriteUpdateDto userWriteUpdateDto){
        return userService.update(id, userWriteUpdateDto)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        if (!userService.delete(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
