package com.calculator.service;

import com.calculator.exception.DivisionByZeroException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {
    
    private CalculatorService calculatorService;
    
    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }
    
    @Test
    void testAddition() {
        Double result = calculatorService.add(10.0, 5.0);
        assertEquals(15.0, result);
    }
    
    @Test
    void testAdditionWithNegativeNumbers() {
        Double result = calculatorService.add(-10.0, 5.0);
        assertEquals(-5.0, result);
    }
    
    @Test
    void testSubtraction() {
        Double result = calculatorService.subtract(10.0, 5.0);
        assertEquals(5.0, result);
    }
    
    @Test
    void testSubtractionWithNegativeResult() {
        Double result = calculatorService.subtract(5.0, 10.0);
        assertEquals(-5.0, result);
    }
    
    @Test
    void testMultiplication() {
        Double result = calculatorService.multiply(10.0, 5.0);
        assertEquals(50.0, result);
    }
    
    @Test
    void testMultiplicationByZero() {
        Double result = calculatorService.multiply(10.0, 0.0);
        assertEquals(0.0, result);
    }
    
    @Test
    void testDivision() {
        Double result = calculatorService.divide(10.0, 5.0);
        assertEquals(2.0, result);
    }
    
    @Test
    void testDivisionWithDecimals() {
        Double result = calculatorService.divide(10.0, 3.0);
        assertEquals(3.3333333333333335, result);
    }
    
    @Test
    void testDivisionByZeroThrowsException() {
        assertThrows(DivisionByZeroException.class, () -> {
            calculatorService.divide(10.0, 0.0);
        });
    }
    
    @Test
    void testDivisionByZeroExceptionMessage() {
        Exception exception = assertThrows(DivisionByZeroException.class, () -> {
            calculatorService.divide(10.0, 0.0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
