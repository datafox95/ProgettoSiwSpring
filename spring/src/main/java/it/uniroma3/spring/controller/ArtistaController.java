package it.uniroma3.spring.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.spring.model.Artista;
import it.uniroma3.spring.model.Opera;
import it.uniroma3.spring.service.ArtistaService;
import it.uniroma3.spring.service.OperaService;

@Controller
public class ArtistaController {

	@Autowired
	private ArtistaService artistaService;
	
	@Autowired
	private OperaService operaService;
	
	//--------------//


	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}	
	
	
	//--------------//


	@GetMapping("/artisti")
	public String showPage() {
		return "pageArtisti";
	}

	//--------------//
	
	@GetMapping("/addArtista")
	public String showForm(Artista artista){
		return "formArtista";
	}
	
	//--------------//
	
	@PostMapping("/addArtista")
	public String checkArtista(@Valid @ModelAttribute Artista artista, 
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "formArtista";
		}
		artista.setNome(artista.getNome().toUpperCase());
		artista.setCognome(artista.getCognome().toUpperCase());
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		String dataNascita = df.format(artista.getDataNascita());
		model.addAttribute("dataNascita",dataNascita);
		try {
			String dataMorte = df.format(artista.getDataMorte());
			model.addAttribute("dataMorte",dataMorte);
			model.addAttribute(artista);
		} catch (Exception e) {
			model.addAttribute(artista);
		}
		artistaService.add(artista);


		return "datiArtista";
	}

	
	//--------------//

	@GetMapping("/listaArtisti")
	public String mostraLista(Model model){
		List<Artista> artisti = (List<Artista>) artistaService.findAll();
		model.addAttribute("artisti", artisti);
		return "listaArtisti"; //
	}

	//--------------//
	
	@GetMapping("/mostraAutore")
	public String showAutore(@RequestParam("id")long id, Model model){
		Artista artista = artistaService.findbyId(id);
		List<Opera> opere= artista.getOpere();
		model.addAttribute("opere", opere);
		model.addAttribute("artista", artista);
		return "mostraAutore";
	}

	
	//--------------//
	
	
	
	


}
