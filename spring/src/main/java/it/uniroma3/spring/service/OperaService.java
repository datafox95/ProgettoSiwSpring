package it.uniroma3.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.spring.model.Opera;
import it.uniroma3.spring.repository.OperaRepository;

@Service
public class OperaService {
	
	//Dipendenze
	@Autowired
	private OperaRepository operaRepo;
	
	
	/*
	 * Operazioni*/
	
	//salva una nuova opera
	@Transactional
	public void add(final Opera opera){
		this.operaRepo.save(opera);
	}
	
	//itera sulle opere e restituisce una lista delle opere
	public Iterable<Opera> findAll() {
		return this.operaRepo.findAll();
	}
	
	//ricerca un'opera tramite id e restituisce l'opera
	public Opera findbyId(Long id) {
		return this.operaRepo.findOne(id);
	}

	//cancella opera
	public void delete(Long id) {
		this.operaRepo.delete(id);
		
	}

	
	
	
	

}
