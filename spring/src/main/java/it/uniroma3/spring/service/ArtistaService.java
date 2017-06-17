package it.uniroma3.spring.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.uniroma3.spring.model.Artista;
import it.uniroma3.spring.repository.ArtistaRepository;

@Service
public class ArtistaService {
	
	@Autowired
	private ArtistaRepository artistaRepo;
	
	 public Iterable<Artista> findAll() {
	        return this.artistaRepo.findAll();
	    }
	
	@Transactional
    public void add(final Artista customer) {
        this.artistaRepo.save(customer);
    }
	
	public Artista findbyId(Long id) {
		return this.artistaRepo.findOne(id);
	}
	
	public Artista findByNome(String nome){
		return this.artistaRepo.findByNome(nome);
	}
	
	public void delete(Long id) {
		this.artistaRepo.delete(id);

	}

}
