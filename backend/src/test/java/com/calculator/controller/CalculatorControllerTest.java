package com.calculator.controller;

import com.calculator.dto.CalculationRequest;
import com.calculator.service.CalculatorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @MockBean
    private CalculatorService calculatorService;
    
    @Test
    void testAddEndpoint() throws Exception {
        CalculationRequest request = new CalculationRequest(10.0, 5.0);
        when(calculatorService.add(any(), any())).thenReturn(15.0);
        
        mockMvc.perform(post("/api/calculate/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(15.0));
    }
    
    @Test
    void testSubtractEndpoint() throws Exception {
        CalculationRequest request = new CalculationRequest(10.0, 5.0);
        when(calculatorService.subtract(any(), any())).thenReturn(5.0);
        
        mockMvc.perform(post("/api/calculate/subtract")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(5.0));
    }
    
    @Test
    void testMultiplyEndpoint() throws Exception {
        CalculationRequest request = new CalculationRequest(10.0, 5.0);
        when(calculatorService.multiply(any(), any())).thenReturn(50.0);
        
        mockMvc.perform(post("/api/calculate/multiply")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(50.0));
    }
    
    @Test
    void testDivideEndpoint() throws Exception {
        CalculationRequest request = new CalculationRequest(10.0, 5.0);
        when(calculatorService.divide(any(), any())).thenReturn(2.0);
        
        mockMvc.perform(post("/api/calculate/divide")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(2.0));
    }
    
    @Test
    void testHealthEndpoint() throws Exception {
        mockMvc.perform(get("/api/calculate/health"))
                .andExpect(status().isOk())
                .andExpect(content().string("Calculator API is running"));
    }
}
