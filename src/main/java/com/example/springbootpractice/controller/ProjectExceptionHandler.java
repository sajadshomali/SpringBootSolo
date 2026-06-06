package com.example.springbootpractice.controller;

import com.example.springbootpractice.dto.response.ExceptionResponse;
import com.example.springbootpractice.exceptions.MyExceptions;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class ProjectExceptionHandler {
    private final MessageSourceAccessor messageSourceAccessor;

    public ProjectExceptionHandler(MessageSourceAccessor messageSourceAccessor) {
        this.messageSourceAccessor = messageSourceAccessor;
    }

    @ExceptionHandler(MyExceptions.class)
    public ResponseEntity<List<ExceptionResponse>> myException(MyExceptions myExceptions){
        return ResponseEntity.status(404).body(Arrays.asList(mapMyExceptionToExceptionResponse(myExceptions)));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionResponse>>methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        return ResponseEntity.status(404).body(mapValidatorToExceptionResponse(methodArgumentNotValidException));
    }

    private ExceptionResponse mapMyExceptionToExceptionResponse(MyExceptions myExceptions){
        return ExceptionResponse.builder()
                .message(messageSourceAccessor.getMessage(myExceptions.getMessage()))
                .code(messageSourceAccessor.getMessage(myExceptions.getMessage()))
                .build();
    }

    private List<ExceptionResponse> mapValidatorToExceptionResponse(MethodArgumentNotValidException methodArgumentNotValidException){
        return methodArgumentNotValidException.getFieldErrors().stream().map((error)->
                ExceptionResponse.builder()
                        .message(error.getDefaultMessage())
                        .build()
                ).toList();
    }

}
