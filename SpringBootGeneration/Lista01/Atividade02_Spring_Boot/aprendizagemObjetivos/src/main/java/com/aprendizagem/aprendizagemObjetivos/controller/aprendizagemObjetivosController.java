package com.aprendizagem.aprendizagemObjetivos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aprendizagemObjetivos")
public class aprendizagemObjetivosController {
	
	@GetMapping
	public String aprendizagemObjetivos()
	{
		return "Objetivos: Aprender MySQL, Spring Boot e dar inicio ao nosso blog pessoal.";
	}

}
