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
import it.uniroma3.spring.model.Admin;
import it.uniroma3.spring.service.AdminService;

@Controller
public class MainController {

	//Dipendenze
	@Autowired
	private AdminService as;

	
	//--------------//
	
	//Mostra la pagina di login
	@RequestMapping(value="/login")
	public String login(){
		return "login"; //
	}
	
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute Admin admin, BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()){
			return "login";
		}else
			return "/areaRiservata";
	}
	
	//--------------//
	
	//Mostra la form per l'inserimento di un nuovo utente
	@GetMapping("/addAdmin")
	public String showForm(Admin admin){
		return "form";
	}
	
	//--------------//
	
	//Verifica la correttezza dei dati del nuovo utente e mostra la pagina con i dati ineriti dall'utente
	@PostMapping("/addAdmin")
	public String signUp(@Valid @ModelAttribute Admin admin, 
			BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()) {
			return "form"; //
		}
		else {
			model.addAttribute(admin);
			as.add(admin); 
			
		}
		return "mostraAdmin"; //
	}
	
	
	//----------//
	//Accedi all'area riservata
	@GetMapping("/areaRiservata")
	public String showReservedArea(){
		return "areaRiservata";
	}
	
	
}


