package it.uniroma3.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.spring.model.Opera;
import it.uniroma3.spring.model.Stanza;
import it.uniroma3.spring.repository.OperaRepository;

@Service
public class OperaService {
	
	@Autowired
	private OperaRepository operaRepo;
	
	@Transactional
	public void add(final Opera opera){
		this.operaRepo.save(opera);
	}
	public Iterable<Opera> findAll() {
		return this.operaRepo.findAll();
	}
	
	public Opera findbyId(Long id) {
		return this.operaRepo.findOne(id);
	}

	public void delete(Long id) {
		this.operaRepo.delete(id);

	}
	
	
	

}
