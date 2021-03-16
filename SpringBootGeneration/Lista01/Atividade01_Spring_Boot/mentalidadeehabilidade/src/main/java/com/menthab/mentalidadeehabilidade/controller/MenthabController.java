package com.menthab.mentalidadeehabilidade.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menthab")

public class MenthabController {

	@GetMapping
	public String menthab()
	{
		String habilidade1 = "Orientação ao detalhe";
		String habilidade2 = "Proatividade";
		String Mentalidade1 = "Persistência";		
		
		
		return "\nHabilidades: " + habilidade1 + " e " + habilidade2 + ".\nMentalidade: " + Mentalidade1 + "."; 
	}		
}
