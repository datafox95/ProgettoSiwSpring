package it.uniroma3.spring.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.uniroma3.spring.model.Artista;
import it.uniroma3.spring.repository.ArtistaRepository;

@Service
public class ArtistaService {
	
	//Dipendenze
	@Autowired
	private ArtistaRepository artistaRepo;
	
	
	/*
	 * Operazioni*/
	
	//itera su tutti gli artisti e ritorna una lista
	 public Iterable<Artista> findAll() {
	        return this.artistaRepo.findAll();
	    }
	
	
	//salva un artista
	@Transactional
    public void add(final Artista artista) {
        this.artistaRepo.save(artista);
    }
	
	//ricerca un artista tramite l'id e lo restituisce
	public Artista findbyId(Long id) {
		return this.artistaRepo.findOne(id);
	}
	
	//ricerca un artista tramite nome e lo restituisce
	public Artista findByNome(String nome){
		return this.artistaRepo.findByNome(nome);
	}
	
	//cancella un artista
	@Transactional
	public void delete(Long id) {
		this.artistaRepo.delete(id);

	}

}
