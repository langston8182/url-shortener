package com.notarius.urlshortener.urlshortener.service;

import com.notarius.urlshortener.urlshortener.domain.UrlShortener;

public interface UrlShortenerService {

	/**
	 * Sqve the Url in database and store the shorten Url in the result.
	 * 
	 * @param urlShortener The Url to be saved.
	 * 
	 * @return The saved object.
	 */
	public UrlShortener saveUrl(UrlShortener urlShortener);
	
	/**
	 * Retrieve the true Url according the shorten Url.
	 * 
	 * @param url The shorten Url.
	 * @return The Url.
	 */
	public UrlShortener getUrl(String shortenUrl);
	
	/**
	 * 
	 * Find an UrlShortener by his Id;
	 * 
	 * @param id The primary key
	 * 
	 * @return The UrlShortened from DB.
	 */
	public UrlShortener findUrlShortener(Long id);
	
}
