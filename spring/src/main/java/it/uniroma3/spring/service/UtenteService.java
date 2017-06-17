package it.uniroma3.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.spring.model.Utente;
import it.uniroma3.spring.repository.UtenteRepo;

@Service
public class UtenteService {

	@Autowired
	private UtenteRepo utenteRepo;

	public Iterable<Utente> findAll() {
		return this.utenteRepo.findAll();
	}

	@Transactional
	public void add(final Utente user) {
		this.utenteRepo.save(user);
	}

}
