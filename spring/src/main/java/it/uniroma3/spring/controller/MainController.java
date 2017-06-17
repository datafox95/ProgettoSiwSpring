package it.uniroma3.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.spring.model.RuoloUtente;
import it.uniroma3.spring.model.Utente;
import it.uniroma3.spring.service.RuoloUtenteService;
import it.uniroma3.spring.service.UtenteService;

@Controller
public class MainController {

	@Autowired
	private RuoloUtenteService rus;

	@Autowired
	private UtenteService us;

	
	@RequestMapping(value="/403")
	public String Error403(){
		return "Error403";
	}

	@RequestMapping(value="/login")
	public String login(){
		return "login"; //
	}
	
	
	@GetMapping("/register")
	public String showForm(Utente utente){
		return "form";
	}
	
	

	@PostMapping("/register")
	public String signUp(@Valid @ModelAttribute Utente utente, 
			BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()) {
			return "form"; //
		}
		else {
			model.addAttribute(utente);
			us.add(utente); 
			rus.add(new RuoloUtente(utente.getUsername()));
		}
		return "mostraUtente"; //
	}
	
	
}


