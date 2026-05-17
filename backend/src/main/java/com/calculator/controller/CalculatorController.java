package com.calculator.controller;

import com.calculator.dto.CalculationRequest;
import com.calculator.dto.CalculationResponse;
import com.calculator.service.CalculatorService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculate")
@CrossOrigin(origins = "*")
public class CalculatorController {
    
    private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);
    
    @Autowired
    private CalculatorService calculatorService;
    
    @PostMapping("/add")
    public ResponseEntity<CalculationResponse> add(@Valid @RequestBody CalculationRequest request) {
        logger.info("Received addition request: {}", request);
        Double result = calculatorService.add(request.getA(), request.getB());
        return ResponseEntity.ok(CalculationResponse.of(result));
    }
    
    @PostMapping("/subtract")
    public ResponseEntity<CalculationResponse> subtract(@Valid @RequestBody CalculationRequest request) {
        logger.info("Received subtraction request: {}", request);
        Double result = calculatorService.subtract(request.getA(), request.getB());
        return ResponseEntity.ok(CalculationResponse.of(result));
    }
    
    @PostMapping("/multiply")
    public ResponseEntity<CalculationResponse> multiply(@Valid @RequestBody CalculationRequest request) {
        logger.info("Received multiplication request: {}", request);
        Double result = calculatorService.multiply(request.getA(), request.getB());
        return ResponseEntity.ok(CalculationResponse.of(result));
    }
    
    @PostMapping("/divide")
    public ResponseEntity<CalculationResponse> divide(@Valid @RequestBody CalculationRequest request) {
        logger.info("Received division request: {}", request);
        Double result = calculatorService.divide(request.getA(), request.getB());
        return ResponseEntity.ok(CalculationResponse.of(result));
    }
    
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Calculator API is running");
    }
}
