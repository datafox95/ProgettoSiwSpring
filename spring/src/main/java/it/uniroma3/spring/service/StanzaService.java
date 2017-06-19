package it.uniroma3.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.spring.model.Stanza;
import it.uniroma3.spring.repository.StanzaRepository;

@Service
public class StanzaService {

	//Dipendenze
	@Autowired
	private StanzaRepository stanzaRepo;
	
	/*
	 * Operazioni*/

	//itera su tutte le stanze e restituisce una lista di queste 
	public Iterable<Stanza> findAll() {
		return this.stanzaRepo.findAll();
	}

	//salva una nuova stanza
	@Transactional
	public void add(final Stanza opera) {
		this.stanzaRepo.save(opera);
	}
	
	//ricerca una stanza tramite id e la restituisce
	public Stanza findbyId(Long id) {
		return this.stanzaRepo.findOne(id);
	}

	//cancella una stanza 
	public void delete(Long id) {
		this.stanzaRepo.delete(id);
		
	}



}
