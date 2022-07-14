package com.example.calculator.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.calculator.model.Calculator;

@RestController
@RequestMapping(value = "/calculator")

public class CalculatorController {

	@Autowired
	public Calculator calculator;

	@GetMapping("/welcome")
	public String messageWelcome() {
		return "Bem vindo à CALCULATOR API REST.";
	}

	@GetMapping("/addNumbers")
	    public String addNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
	    	return ("A soma entre " + n1 + " e " + n2 + " é igual a" + calculator.sum(n1,n2));
	    }

	@GetMapping("/subNumbers")
	public String subNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
		return ("A subtração entre " + n1 + " e " + n2 + " é igual a" + calculator.sub(n1,n2));
	}

	@GetMapping("/divideNumbers")
	public String divideNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
		return ("A divisão entre " + n1 + " e " + n2 + " é igual a" + calculator.divide(n1,n2));
	}

	@GetMapping("/factorial")
	public String factorial(@RequestParam(name = "factorial") Integer factorial) {
		return ("A multiplicação entre " + factorial + " é igual a" + calculator.factorial(factorial));
	}

	@GetMapping("/calculeDayBetweenDate")
	public String calculeDayBetweenDate(
			@RequestParam("localDate1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate1,
			@RequestParam("localDate2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate2) {
		return ("A diferença entre as datas " + localDate1 + localDate2 + "é igual a " + calculator.calculeDayBetweenDate(localDate1, localDate2));
	}

	@GetMapping("/integerToBinary")
	public String integerToBinary(@RequestParam(name = "number1") Integer n1) {
		return ("O binário de " + n1 + " é igual a " + calculator.integerToBinary(n1));
	}

	@GetMapping("/integerToHexadecimal")
	public String integerToHexadecimal(@RequestParam(name = "number1") Integer n1) {
		return ("O hexadecimal de " + n1 + " é igual a " + calculator.integerToHexadecimal(n1));
	}
}
