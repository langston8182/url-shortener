package com.notarius.urlshortener.urlshortener.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import lombok.Data;

/**
 * @author cyril
 * 
 * Entity to represent a true Url before to be short. The primary key <em>Id</id> will be used to encode the Url.
 */
@Entity
@Data
public class UrlShortener {

	/**
	 * Primary key. Used for encoding an Url.
	 */
	@Id
	@GeneratedValue(generator = "seq")
	@SequenceGenerator(name = "seq", initialValue = 1000000)
	private Long Id;
	
	/**
	 * The true Url.
	 */
	private String url;
	
	/**
	 * The short URL. Must not be persisted.
	 */
	@Transient
	private String urlShort;
	
	/**
	 * Default constructor for JPA.
	 */
	public UrlShortener() {
		
	}

	/**
	 * Constructor.
	 * 
	 * @param id The id. (for persist)
	 * @param url The true Url before encoding.
	 */
	public UrlShortener(Long id, String url) {
		super();
		Id = id;
		this.url = url;
	}
}
