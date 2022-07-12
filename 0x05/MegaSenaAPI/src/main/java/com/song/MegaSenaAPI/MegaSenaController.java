package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/megasena")

public class MegaSenaController {

	@GetMapping("/simpleMessageWelcome")
	public String mensagemBoasVindas() {
		return " SEJAM BEM VINDOS A MEGA SENA!!! ";
	}

	@GetMapping("/getNumbers")
	public List<Integer> numerosMegaSena() {
		return listaNumerosInteiros(14, 7, 21);
	}

	private List<Integer> listaNumerosInteiros(int size, int upperBound, int lowerBound) {

		Set<Integer> setRandom = new LinkedHashSet<Integer>();
		while (setRandom.size() < size) {
			setRandom.add((int) (Math.random() * (upperBound + 1 - lowerBound) + lowerBound));
		}

		List<Integer> result = new ArrayList<Integer>(setRandom);

		Collections.sort(result);

		return result;
	}
}
