package it.uniroma3.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Opera;

public interface OperaRepository extends CrudRepository<Opera, Long>{
	
	void delete(Long id);	
	
	List<Opera> findByAnno(Integer anno);
	
    List<Opera> findByTitolo(String titolo);

    List<Opera> findByTecnica(String tecnica);

}
