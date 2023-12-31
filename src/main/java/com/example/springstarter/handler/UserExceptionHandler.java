package com.example.springstarter.handler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import org.webjars.NotFoundException;

@RestControllerAdvice
@Slf4j
public class UserExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResponseStatusException.class)
    public String handlerNotFoundException(ResponseStatusException exception){
        log.error("User not found tratata {}", exception.getClass());
        return exception.getLocalizedMessage();
    }
}
