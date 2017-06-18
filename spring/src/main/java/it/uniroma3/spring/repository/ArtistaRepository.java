package it.uniroma3.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Artista;

public interface ArtistaRepository extends CrudRepository<Artista, Long>{
	
	void delete(Long id); //operazione di cancellazione
	
    Artista findByNome(String nome); //ricerca un artista per nome

    List<Artista> findByCognome(String cognome); //ricerca un artista per cognome
    
    List<Artista> findByNazione(String nazione); //ricerca un artista per nazionalità
    
    
    

}
