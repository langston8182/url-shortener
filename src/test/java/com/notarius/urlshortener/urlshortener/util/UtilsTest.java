package com.notarius.urlshortener.urlshortener.util;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import com.notarius.urlshortener.urlshortener.exception.UrlShortenerException;

public class UtilsTest {

	@Test
	public void getDomainSuccess() {
		String url = "http://www.google.fr/test/a";
		String expectedDomain = Utils.getDomain(url);
		
		assertThat(expectedDomain).isEqualTo("www.google.fr");
	}
	
	@Test(expected = UrlShortenerException.class)
	public void getDomainFailed() {
		String badUrl = "qwerty";
		Utils.getDomain(badUrl);
	}
	
}
