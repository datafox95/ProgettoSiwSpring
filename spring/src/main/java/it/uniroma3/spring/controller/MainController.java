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
import it.uniroma3.spring.model.Utente;
import it.uniroma3.spring.service.UtenteService;

@Controller
public class MainController {

	//Dipendenze
	@Autowired
	private UtenteService us;

	
	//--------------//
	
	//Mostra la pagina di login
	@RequestMapping(value="/login")
	public String login(){
		return "login"; //
	}
	
	//--------------//
	
	//Mostra la form per l'inserimento di un nuovo utente
	@GetMapping("/register")
	public String showForm(Utente utente){
		return "form";
	}
	
	//--------------//
	
	//Verifica la correttezza dei dati del nuovo utente e mostra la pagina con i dati ineriti dall'utente
	@PostMapping("/register")
	public String signUp(@Valid @ModelAttribute Utente utente, 
			BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()) {
			return "form"; //
		}
		else {
			model.addAttribute(utente);
			us.add(utente); 
			
		}
		return "mostraUtente"; //
	}
	
	
}


