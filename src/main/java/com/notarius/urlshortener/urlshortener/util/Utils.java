package com.notarius.urlshortener.urlshortener.util;

import java.net.MalformedURLException;
import java.net.URL;

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
		URL aUrl;
		try {
			aUrl = new URL(url);
		} catch (MalformedURLException e) {
			throw new UrlShortenerException("malformed URL");
		}
		
		return aUrl.getProtocol() + "://" + aUrl.getAuthority() + "/";
	}
	
}
