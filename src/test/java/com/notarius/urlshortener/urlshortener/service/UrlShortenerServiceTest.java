package com.notarius.urlshortener.urlshortener.service;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.notarius.urlshortener.urlshortener.UrlShortenerApplication;
import com.notarius.urlshortener.urlshortener.component.Base62;
import com.notarius.urlshortener.urlshortener.domain.UrlShortener;
import com.notarius.urlshortener.urlshortener.exception.UrlShortenerNotFoundException;

import example.UrlShortenerExample;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UrlShortenerApplication.class)
public class UrlShortenerServiceTest {

	@Autowired
	private UrlShortenerService urlShortenerService;
	
	@Autowired
	private Base62 base62;
	
	@Test
	public void findUrlShortener() {
		UrlShortener urlShortener = urlShortenerService.findUrlShortener(1000000L);
		assertThat(urlShortener).isNotNull();
	}
	
	@Test(expected = UrlShortenerNotFoundException.class)
	public void findUrlShortenerNotFound() {
		urlShortenerService.findUrlShortener(1L);
	}
	
	@Test
	@DirtiesContext
	@Transactional
	public void saveUrl() {
		UrlShortener urlShortener = UrlShortenerExample.aUrlShortener().get();
		assertThat(urlShortener).isNotNull();
		assertThat(urlShortener.getId()).isNull();
		
		UrlShortener savedUrl = urlShortenerService.saveUrl(urlShortener);
		String encodeUrl = base62.toBase62(savedUrl.getId());
		assertThat(urlShortener).isNotNull();
		assertThat(urlShortener.getId()).isEqualByComparingTo(savedUrl.getId());
		assertThat(urlShortener.getUrlShort()).isEqualTo(encodeUrl);
	}
	
}
