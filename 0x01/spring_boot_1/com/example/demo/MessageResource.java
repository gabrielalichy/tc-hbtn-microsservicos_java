package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/messages")

public class MessageResource {

	@GetMapping("/simpleMessageWelcome")
	public String simpleMessageWelcome() {
		String msg = "BEM VINDO A AULA DE MICROSSERVIÇO USANDO SPRING BOOT !!!";
		return msg;

	}

	@GetMapping("/login")
	public String user(@RequestParam String user, String password) {
		String msg = null;
		if (user.isEmpty() || user.isBlank() || password.isEmpty() || password.isBlank()) {
			return "USUÁRIO E SENHA NÃO INFORMADOS";
		}
		if (user.length() > 15 || password.length() > 15) {
			return "USUÁRIO E SENHA INVÁLIDOS";
		}
		
		return "LOGIN EFETUADO COM SUCESSO !!!";
	}
}
