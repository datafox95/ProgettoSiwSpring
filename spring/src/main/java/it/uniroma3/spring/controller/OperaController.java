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

import it.uniroma3.spring.model.Artista;
import it.uniroma3.spring.model.Opera;
import it.uniroma3.spring.model.Stanza;
import it.uniroma3.spring.service.ArtistaService;
import it.uniroma3.spring.service.OperaService;
import it.uniroma3.spring.service.StanzaService;

@Controller
public class OperaController {
	
	@Autowired
	private ArtistaService artistaService;
	
	@Autowired
	private OperaService operaService; 
	
	@Autowired
	private StanzaService stanzaService; 
	
	
	@GetMapping("/opere")
	public String showOpere(Model model){
		List<Opera> opere = (List<Opera>) operaService.findAll();
		model.addAttribute("opere", opere);
		return "pageOpere";
		
	}
	
	//-------------//
	

	
	@GetMapping("/addOpera")
	public String showForm(Model model, Opera opera){
		List<Artista> artisti = (List<Artista>)artistaService.findAll();
		model.addAttribute("artisti", artisti);
		List<Stanza> stanze = (List<Stanza>) stanzaService.findAll();
		model.addAttribute("stanze", stanze);
		return "formOpera";
	}
	
	
	//-------------//
	
	@PostMapping("/addOpera")
	public String checkOpera(@Valid @ModelAttribute Opera opera, 
			BindingResult bindingResult, Model model , @RequestParam("artista") Artista artista) {

		List<Stanza> stanze = (List<Stanza>) stanzaService.findAll();
		model.addAttribute("stanze", stanze);

		if (bindingResult.hasErrors() || artistaService.findbyId(artista.getId())== null ) {
			return "formOpera";
		}
		else {
			opera.setArtista(artista);
			artista.getOpere().add(opera);
			model.addAttribute(artista);
			model.addAttribute(opera);
			if(opera.getStanza()==null){
				model.addAttribute("nomeStanza","L'opera non è esposta.");
			}
			else{
				model.addAttribute("nomeStanza",opera.getStanza().getNomeStanza());
				opera.getStanza().getOpere().add(opera);
			}
			operaService.add(opera); 
		}
		return "mostraOpera";
	}
	
	@GetMapping("/mostraOpera")
	public String showOpera(Model model ,@RequestParam("id") Long id ){
		Opera opera = operaService.findbyId(id);
		model.addAttribute("opera", opera);
		return "mostraOpera";
	}
	
	
	
	
	
	
	

}
