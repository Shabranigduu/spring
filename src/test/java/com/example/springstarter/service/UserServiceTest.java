package com.example.springstarter.service;

import com.example.springstarter.dto.CompanyReadDto;
import com.example.springstarter.dto.UserReadDto;
import com.example.springstarter.dto.UserWriteUpdateDto;
import com.example.springstarter.entity.User;
import com.example.springstarter.mappers.UserReadMapper;
import com.example.springstarter.mappers.UserWriteUpdateMapper;
import com.example.springstarter.repository.UserRepository;
import net.bytebuddy.dynamic.DynamicType;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
@Mock
    private UserRepository userRepository;
    @Mock
    private UserReadMapper userReadMapper;
    @Mock
    private UserWriteUpdateMapper userWriteUpdateMapper;
    @InjectMocks
    private UserService userService;

    @Test
    void shouldGetAllUsers(){
        when(userRepository.findAll()).thenReturn(List.of(new User(), new User()));
        when(userReadMapper.map(any())).thenReturn(new UserReadDto("1", LocalDate.MIN, "2", "3", new CompanyReadDto("companyName")));

        List<UserReadDto> expectedList = userService.findAll();

        Assertions.assertEquals(2, expectedList.size());
}
}