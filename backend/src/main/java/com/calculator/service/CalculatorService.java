package com.calculator.service;

import com.calculator.exception.DivisionByZeroException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    
    private static final Logger logger = LoggerFactory.getLogger(CalculatorService.class);
    
    public Double add(Double a, Double b) {
        logger.info("Performing addition: {} + {}", a, b);
        Double result = a + b;
        logger.info("Addition result: {}", result);
        return result;
    }
    
    public Double subtract(Double a, Double b) {
        logger.info("Performing subtraction: {} - {}", a, b);
        Double result = a - b;
        logger.info("Subtraction result: {}", result);
        return result;
    }
    
    public Double multiply(Double a, Double b) {
        logger.info("Performing multiplication: {} * {}", a, b);
        Double result = a * b;
        logger.info("Multiplication result: {}", result);
        return result;
    }
    
    public Double divide(Double a, Double b) {
        logger.info("Performing division: {} / {}", a, b);
        
        if (b == 0.0) {
            logger.error("Division by zero attempted");
            throw new DivisionByZeroException("Cannot divide by zero");
        }
        
        Double result = a / b;
        logger.info("Division result: {}", result);
        return result;
    }
}
