package it.uniroma3.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.spring.model.Opera;
import it.uniroma3.spring.model.Stanza;
import it.uniroma3.spring.service.StanzaService;

@Controller
public class StanzaController {
	
	
	@Autowired
	private StanzaService stanzaService;
	
	@GetMapping("/stanze")
	public String showMenuStanze(Model model){
		List<Stanza> stanze = (List<Stanza>) stanzaService.findAll();
		model.addAttribute("stanze", stanze);
		return "pageStanze";
	}
	
	//-------------//
	
	@GetMapping("/mostraStanza")
	public String showStanza(@RequestParam("id")long id, Model model){
		Stanza stanza = stanzaService.findbyId(id);
		List<Opera> opere= stanza.getOpere();
		model.addAttribute("opere", opere);
		model.addAttribute("stanza", stanza);
		return "mostraStanza";
	}
	
	
	//-------------//
	
	
	@GetMapping("/addStanza")
	public String showForm(Stanza stanza) {
		return "formStanza";	
	}
	
	
	//-------------//
	
	
	@PostMapping("/addStanza")
	public String checkArtistaInfo(@Valid @ModelAttribute Stanza stanza, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "formStanza";
		}
		else {
			model.addAttribute(stanza);
			stanzaService.add(stanza);
		}
		return "mostraStanza";
	}
	
	
	//--------//
	@GetMapping("/pageStanze")
	public String showPage(){
		return "pageStanze";
	}
	
	
	
	

}
