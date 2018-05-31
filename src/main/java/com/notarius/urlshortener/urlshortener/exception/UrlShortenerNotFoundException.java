package com.notarius.urlshortener.urlshortener.exception;

/**
 * @author cyril
 *
 * Exception when an UrlShortener is not found in DB.
 */
public class UrlShortenerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5671328366121156237L;

	public UrlShortenerNotFoundException() {
        super();
    }

    public UrlShortenerNotFoundException(final String message) {
        super(message);
    }
	
}
