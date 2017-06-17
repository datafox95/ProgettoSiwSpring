package it.uniroma3.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Stanza;

public interface StanzaRepository extends CrudRepository<Stanza,Long> {
	
	List<Stanza> findByNomeStanza(String nomeStanza);
	
	

}
