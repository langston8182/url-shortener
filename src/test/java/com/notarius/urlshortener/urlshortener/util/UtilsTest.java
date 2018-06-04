package com.notarius.urlshortener.urlshortener.util;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import com.notarius.urlshortener.urlshortener.exception.UrlShortenerException;

public class UtilsTest {

	@Test
	public void getDomainSuccess() {
		String url = "http://localhost:8080/url/encode";
		String expectedDomain = Utils.getDomain(url);
		System.out.println(expectedDomain);
		assertThat(expectedDomain).isEqualTo("http://localhost:8080/");
	}
	
	@Test(expected = UrlShortenerException.class)
	public void getDomainFailed() {
		String badUrl = "qwerty";
		Utils.getDomain(badUrl);
	}
	
}
