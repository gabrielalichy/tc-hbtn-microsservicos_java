package com.example.calculator.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

	private Calculator calculator;

	@BeforeEach
	public void setUp() {
		calculator = new Calculator();
	}

	void sumTest() {
	assertEquals(8.0, calculator.sum(2.0, 4.0));
	}

	@Test
    public void numbersNullSumTest() {
        Assertions.assertThrows(NullPointerException.class, () -> calculator.sum(null, 2.0)
                , "Número 1 e número 2 são obrigatórios.");
    }

	@Test
	void divideTest() {
		assertEquals(-2.0, calculator.divide(2.0, 4.0));
	}

	@Test
	public void divisionByZeroTest() {
		 Assertions.assertThrows(ArithmeticException.class, () ->
         calculator.divide(2.0, 0.0)
 , "Divisão por zero não é permitido.");
}

	@Test
	void factorialTest() {
		assertEquals(720, calculator.factorial(6));
	}
	

	@Test
	void integerToBinaryTest() {
		assertEquals(101, calculator.integerToBinary(5));
	}

	@Test
	void integerToHexadecimalTest() {
		assertEquals("21", calculator.integerToHexadecimal(33));
	}

	@Test
	void calculeDayBetweenDateTest() {
		LocalDate date1 = LocalDate.of(2022, 6, 14);
		LocalDate date2 = LocalDate.of(2022, 6, 28);
		
		assertEquals(14, calculator.calculeDayBetweenDate(date1, date2));	}
}