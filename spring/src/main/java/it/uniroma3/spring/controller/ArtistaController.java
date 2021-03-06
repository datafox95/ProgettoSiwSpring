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

@Controller
public class ArtistaController {

	//Dipendenze 
	@Autowired
	private ArtistaService artistaService;





	//--------------//


	//Mostra la pagina relativa agli artisti con le operazioni di gestione

	@GetMapping(value = {"/artisti" , "/pageArtisti"})
	public String showPage(Model model) {
		List<Artista> artisti = (List<Artista>) artistaService.findAll();
		model.addAttribute("artisti", artisti);
		return "pageArtisti";
	}

	//--------------//

	//Mostra la form per l'inserimento di un nuovo artista

	@GetMapping("/addArtista")
	public String showForm(Artista artista){
		return "formArtista";
	}
	
	
	
	//--------------//


		//Controllo del formato di una qualsiasi data

		@InitBinder
		public void dataBinding(WebDataBinder binder) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			dateFormat.setLenient(true);
			binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		}	

	
	

	//--------------//

	//Verifica la correttezza della form e mostra la pagina relativa ai dati inseriti 

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


	//Mostra i dati relativi ad un autore identificato da un certo id e le sue relative opere

	@GetMapping("/mostraAutore")
	public String showAutore(@RequestParam("id")long id, Model model){
		Artista artista = artistaService.findbyId(id);
		List<Opera> opere= artista.getOpere();
		model.addAttribute("opere", opere);
		model.addAttribute("artista", artista);
		return "mostraAutore";
	}


	//--------------//

	//Mostra la pagina per la cancellazione di artisti visualizzandoli

	@GetMapping("/cancellaArtisti")
	public String rimuoviArtisti(Model model){
		List<Artista> artisti = (List<Artista>)artistaService.findAll();
		model.addAttribute("artisti", artisti);
		return "artistiRimovibili";
	}

	//--------------//

	//Consente la cancellazione di un artista mostrando la pagina relativa alla cancellazione

	@GetMapping("/cancellaArtista")
	public String rimuoviArtista(Model model, @RequestParam("id") Long id){
		artistaService.delete(id);
		List<Artista> autori = (List<Artista>) artistaService.findAll();
		model.addAttribute("autori", autori);
		return "artistiRimovibili";

	}


	

	//---------------//

	@GetMapping(value={"/modificaArtisti"})
	public String modificaArtisti(Model model){
		List<Artista> artisti = (List<Artista>)artistaService.findAll();
		model.addAttribute("artisti", artisti);
		return "artistiModificabili";
	}

	//---------------//

	@GetMapping("/modificaArtista")
	public String editArtisti(Model model, @RequestParam("id") Long id){
		Artista artista = artistaService.findbyId(id);
		model.addAttribute("artista", artista);
		return "artistaDaModificare"; // pagina da fare
	}

	//---------------//

	
	@PostMapping("/modificaArtista")
	public String editArtista(@Valid @ModelAttribute Artista artista, BindingResult bindingResult, Model model){

		if (bindingResult.hasErrors()) {
			return "artistaDaModificare";
		}
		else {
			SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			String dataNascita = df.format(artista.getDataNascita());
			model.addAttribute("dataNascita", dataNascita);
			
			if(artista.getDataMorte()!=null){
				String dataMorte = df.format(artista.getDataMorte());
				model.addAttribute("dataMorte", dataMorte);
			}
			artista.setNome(artista.getNome().toUpperCase());
			model.addAttribute(artista);
			
			try{
				artistaService.add(artista);
			}catch(Exception e){
				return"artistaDaModificare";

			}
		}
		return "artistaModificato";

	}


	@GetMapping(value={"/artistiModificabili"})
	public String showModifica(Model model){
		List<Artista> artisti = (List<Artista>)artistaService.findAll();
		model.addAttribute("artisti", artisti);
		return "artistiModificabili";
	}



}
