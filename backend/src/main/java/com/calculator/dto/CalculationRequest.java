package com.calculator.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculationRequest {
    
    @NotNull(message = "First operand (a) is required")
    private Double a;
    
    @NotNull(message = "Second operand (b) is required")
    private Double b;
}
