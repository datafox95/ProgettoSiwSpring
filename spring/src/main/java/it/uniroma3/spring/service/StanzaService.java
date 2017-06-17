package it.uniroma3.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.spring.model.Stanza;
import it.uniroma3.spring.repository.StanzaRepository;

@Service
public class StanzaService {

	@Autowired
	private StanzaRepository stanzaRepo;

	public Iterable<Stanza> findAll() {
		return this.stanzaRepo.findAll();
	}

	@Transactional
	public void add(final Stanza opera) {
		this.stanzaRepo.save(opera);
	}
	
	public Stanza findbyId(Long id) {
		return this.stanzaRepo.findOne(id);
	}




}
