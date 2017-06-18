package it.uniroma3.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Opera;

public interface OperaRepository extends CrudRepository<Opera, Long>{
	
	void delete(Long id); //cancellazione di un'opera	
	
	List<Opera> findByAnno(Integer anno); //ricerca di un'opera per anno 
	
    List<Opera> findByTitolo(String titolo); //ricerca di un'opera per titolo

    List<Opera> findByTecnica(String tecnica); //ricerca di un'opera per tecnica

}
