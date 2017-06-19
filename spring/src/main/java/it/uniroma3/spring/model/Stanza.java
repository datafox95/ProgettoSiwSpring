package it.uniroma3.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "stanza")
public class Stanza implements Comparable<Stanza> {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=1)
	private String nomeStanza; //nome della stanza
	
	//politica di cascade: ogni operazione sulla stanza aggiorna lo stato dell'opera
	@OneToMany(mappedBy = "stanza", cascade = CascadeType.MERGE)
	private List<Opera> opere; //opere contenute nella stanza
	
	
	/*costruttore vuoto*/
	public Stanza(){}
	
	/*costruttore*/
	public Stanza(String nomeStanza, List<Opera> opere) {
		super();
		this.nomeStanza = nomeStanza;
		this.opere = new ArrayList<>();
	}
	
	
	/*Getters and setters*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeStanza() {
		return nomeStanza;
	}
	public void setNomeStanza(String nomeStanza) {
		this.nomeStanza = nomeStanza;
	}
	
	public List<Opera> getOpere() {
		return opere;
	}
	public void setOpere(List<Opera> opere) {
		this.opere = opere;
	}

	@Override
	public String toString() {
		return "Stanza [id=" + id + ", nomeStanza=" + nomeStanza + ", opere=" + opere + "]";
	}

	@Override
	public int compareTo(Stanza o) {
		return this.getNomeStanza().toUpperCase().compareTo(o.getNomeStanza().toUpperCase());
	}

}
