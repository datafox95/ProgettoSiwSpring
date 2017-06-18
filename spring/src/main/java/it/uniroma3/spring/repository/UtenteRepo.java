package it.uniroma3.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Utente;

public interface UtenteRepo extends CrudRepository<Utente, Long>{
	
	List<Utente> findByUsername(String username); //ricerca utente per username

}
