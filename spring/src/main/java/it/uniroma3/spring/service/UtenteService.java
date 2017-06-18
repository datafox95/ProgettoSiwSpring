package it.uniroma3.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.spring.model.Utente;
import it.uniroma3.spring.repository.UtenteRepo;

@Service
public class UtenteService {

	//Dipendenze
	@Autowired
	private UtenteRepo utenteRepo;

	/*
	 * Operazioni*/
	
	//itera su tutti gli utenti e restituisce una lista di queste 
	public Iterable<Utente> findAll() {
		return this.utenteRepo.findAll();
	}

	//salva un nuovo utente
	@Transactional
	public void add(final Utente user) {
		this.utenteRepo.save(user);
	}

}
