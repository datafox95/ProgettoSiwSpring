package it.uniroma3.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Admin;

public interface AdminRepo extends CrudRepository<Admin, Long>{
	
	List<Admin> findByUsername(String username); //ricerca admin per username

}
