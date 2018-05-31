package com.notarius.urlshortener.urlshortener.util;

import java.net.URI;
import java.net.URISyntaxException;

import com.notarius.urlshortener.urlshortener.exception.UrlShortenerException;

/**
 * @author marchivc
 * 
 * Utility class.
 */
public class Utils {

	/**
	 * Get the domain of an Url.
	 * 
	 * @param url The Url given.
	 * 
	 * @Return the Url domain.
	 */
	public static String getDomain(String url) {;
		URI uri;
		try {
			uri = new URI(url);
		} catch (URISyntaxException e) {
			throw new UrlShortenerException("Usage : " + url + " is not a valid Url");
		}
		
		if (uri.getHost() == null) {
			throw new UrlShortenerException("Usage : " + url + " no Uri present");
		}
		
		return uri.getHost();
	}
	
}
