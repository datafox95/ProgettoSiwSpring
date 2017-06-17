package it.uniroma3.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.spring.model.RuoloUtente;
import it.uniroma3.spring.repository.RuoloRepo;

@Service
public class RuoloUtenteService {
	
	 @Autowired
	    private RuoloRepo ruoloRepo; 
	    
	    @Transactional
	    public void add(final RuoloUtente ruolo) {
	        this.ruoloRepo.save(ruolo);
	    }

}
