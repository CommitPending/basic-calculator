package com.calculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    
    private LocalDateTime timestamp;
    private String message;
    private String details;
    
    public static ErrorResponse of(String message, String details) {
        return new ErrorResponse(LocalDateTime.now(), message, details);
    }
}
