package com.example.springbootpractice.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExceptionResponse {
  private  String message;
  private  String code;

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
