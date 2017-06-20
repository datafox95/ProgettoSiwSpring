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
	
	//Dipendenze
	@Autowired
	private StanzaService stanzaService;
	
	
	//--------------//
	
	//Mostra la pagina relativa alle stanze della galleria e alla loro gestione
	@GetMapping("/stanze")
	public String showStanze(Model model){
		List<Stanza> stanze = (List<Stanza>) stanzaService.findAll();
		model.addAttribute("stanze", stanze);
		return "pageStanze";
	}
	
	//-------------//
	
	//Mostra i dati relativi ad una stanza della galleria con le opere che sono esposte in quella stanza
	
	@GetMapping("/mostraStanza")
	public String showStanza(@RequestParam("id")long id, Model model){
		Stanza stanza = stanzaService.findbyId(id);
		List<Opera> opere= stanza.getOpere();
		model.addAttribute("opere", opere);
		model.addAttribute("stanza", stanza);
		return "mostraStanza";
	}
	
	
	//-------------//
	
	//Mostra la form per l'inserimento di una nuova stanza
	
	@GetMapping("/addStanza")
	public String showForm(Stanza stanza) {
		return "formStanza";	
	}
	
	
	//-------------//
	
	//Verifica la correttezza dei dati inseriti relativi alla stanza e mostrai dati relativi
	@PostMapping("/addStanza")
	public String checkArtistaInfo(@Valid @ModelAttribute Stanza stanza, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "formStanza";
		}
		else {
			model.addAttribute(stanza);
			stanzaService.add(stanza);
		}
		return "ritornaStanza";
	}
	
	
	//--------//
	
	//Consente di ritornare alla pagina delle stanze
	
	@GetMapping("/pageStanze")
	public String showPage(){
		return "pageStanze";
	}
	
	//--------//
	
	//Vai alla pagina di rimozione stanze
	@GetMapping("/cancellaStanze")
	public String cancellaStanze(Model model){
		List<Stanza> stanze = (List<Stanza>)stanzaService.findAll();
		model.addAttribute("stanze", stanze);
		return "stanzeRimovibili"; // 
	}
	
	//--------//
	
	
	@GetMapping("/rimuoviStanza")
	public String rimuoviOpera(Model model, @RequestParam("id") Long id){
		stanzaService.delete(id);
		List<Stanza> stanze = (List<Stanza>) stanzaService.findAll();
		model.addAttribute("stanze", stanze);
		return "stanzeRimovibili";
	}
	
	
	
	
	

}
