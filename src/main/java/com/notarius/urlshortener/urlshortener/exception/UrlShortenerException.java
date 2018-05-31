package com.notarius.urlshortener.urlshortener.exception;

/**
 * @author marchivc
 * 
 * Standard exception for UrlShortener
 *
 */
public class UrlShortenerException extends RuntimeException {

	private static final long serialVersionUID = 2679121727592499037L;

	public UrlShortenerException() {
        super();
    }

    public UrlShortenerException(final String message) {
        super(message);
    }
	
}
