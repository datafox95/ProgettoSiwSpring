package it.uniroma3.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Artista;

public interface ArtistaRepository extends CrudRepository<Artista, Long>{
	
	void delete(Long id);
	
    Artista findByNome(String nome);

    List<Artista> findByCognome(String cognome);
    
    List<Artista> findByNazione(String nazione);
    
    
    

}
