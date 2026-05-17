package com.calculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculationResponse {
    
    private Double result;
    
    public static CalculationResponse of(Double result) {
        return new CalculationResponse(result);
    }
}
