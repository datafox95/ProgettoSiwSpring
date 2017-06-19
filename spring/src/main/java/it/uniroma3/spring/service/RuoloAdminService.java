package it.uniroma3.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.spring.model.RuoloAdmin;
import it.uniroma3.spring.repository.RuoloAdminRepo;

@Service
public class RuoloAdminService {

	@Autowired
	private RuoloAdminRepo ruoloAdminRepo; 

	@Transactional
	public void add(final RuoloAdmin ruolo) {
		this.ruoloAdminRepo.save(ruolo);
	}

}
