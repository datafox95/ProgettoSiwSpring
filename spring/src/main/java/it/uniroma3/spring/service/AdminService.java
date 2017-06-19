package it.uniroma3.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.spring.model.Admin;
import it.uniroma3.spring.repository.AdminRepo;

@Service
public class AdminService {

	//Dipendenze
	@Autowired
	private AdminRepo adminRepo;

	/*
	 * Operazioni*/
	
	//itera su tutti gli utenti e restituisce una lista di queste 
	public Iterable<Admin> findAll() {
		return this.adminRepo.findAll();
	}

	//salva un nuovo utente
	@Transactional
	public void add(final Admin user) {
		this.adminRepo.save(user);
	}

}
