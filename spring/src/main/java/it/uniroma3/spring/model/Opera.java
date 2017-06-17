package it.uniroma3.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "opera")
public class Opera {
	
	


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min=1)
	private String titolo;
	
	@NotNull
	@Size(min=1)
	private String tecnica;
	
	@NotNull
	private Integer lunghezza;
	
	@NotNull
	private Integer larghezza;
	
	@NotNull
	@Min(1)
	private Integer anno;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Artista artista;
	
	@ManyToOne(optional=true)
	private Stanza stanza;
	
	@NotNull
	private String UrlImmagine;
	
	
	public Opera(){}
	
	
	
	public Opera(String titolo, String tecnica, Integer lunghezza, Integer larghezza, Integer anno, Artista artista, Stanza stanza, String urlImmagine) {
		super();
		this.titolo = titolo;
		this.tecnica = tecnica;
		this.lunghezza = lunghezza;
		this.larghezza = larghezza;
		this.anno = anno;
		this.artista = artista;
		this.stanza = stanza;
		this.UrlImmagine = urlImmagine;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getTecnica() {
		return tecnica;
	}

	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}


	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public Stanza getStanza() {
		return stanza;
	}

	public void setStanza(Stanza stanza) {
		this.stanza = stanza;
	}



	public String getUrlImmagine() {
		return UrlImmagine;
	}



	public void setUrlImmagine(String urlImmagine) {
		UrlImmagine = urlImmagine;
	}



	@Override
	public String toString() {
		return String.format(
                "Opera[id=%d, titolo='%s', tecnica='%s', anno=%d]",
                id, titolo, tecnica , anno);
	}



	public Integer getLunghezza() {
		return lunghezza;
	}



	public void setLunghezza(Integer lunghezza) {
		this.lunghezza = lunghezza;
	}



	public Integer getLarghezza() {
		return larghezza;
	}



	public void setLarghezza(Integer larghezza) {
		this.larghezza = larghezza;
	}

}
