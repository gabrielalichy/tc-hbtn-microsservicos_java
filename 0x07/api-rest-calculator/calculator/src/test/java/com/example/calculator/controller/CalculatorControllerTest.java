package com.example.calculator.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void messageWelcome() throws Exception {
       RequestBuilder request = get("/calculator/welcome");
       MvcResult result = mvc.perform(request).andReturn();
       assertEquals("Bem vindo à CALCULATOR API REST.", result.getResponse().getContentAsString());
    }

    @Test
    void addNumbers() throws Exception {
    	RequestBuilder request = get("/calculator/addNumbers?number1=5.0&number2=3.0");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("8.0", result.getResponse().getContentAsString());
    }

    @Test
    void subNumbers() throws Exception {
    	RequestBuilder request = get("/calculator/subNumbers?number1=1.0&number2=1.0");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("0.0", result.getResponse().getContentAsString());
    }
    
    @Test
    void divideNumbers() throws Exception {
    	RequestBuilder request = get("/calculator/divideNumbers?number1=4.0&number2=2.0");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("2.0", result.getResponse().getContentAsString());
    }
    
    @Test
    void factorial() throws Exception {
    	RequestBuilder request = get("/calculator/factorial?factorial=6");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("720", result.getResponse().getContentAsString());
    }
    
    @Test
    void calculeDateBetweenDate() throws Exception {
    	   RequestBuilder requestBuilder = get("/calculator/calculeDayBetweenDate?localDate1=2022-06-14&localDate2=2022-06-28");
           MvcResult result = mvc.perform(requestBuilder).andReturn();
           assertEquals("14", result.getResponse().getContentAsString());
    }
    
    @Test
    void integerToBinary() throws Exception {
    	RequestBuilder request = get("/calculator/integerToBinary?number1=5");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("101", result.getResponse().getContentAsString());
    }
    
    @Test
    void integerToHexadecimal() throws Exception {
    	RequestBuilder request = get("/calculator/integerToHexadecimal?number1=33");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("21", result.getResponse().getContentAsString());
    }
}