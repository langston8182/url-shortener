package com.notarius.urlshortener.urlshortener.service.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.notarius.urlshortener.urlshortener.component.Base62;
import com.notarius.urlshortener.urlshortener.domain.UrlShortener;
import com.notarius.urlshortener.urlshortener.exception.UrlShortenerException;
import com.notarius.urlshortener.urlshortener.exception.UrlShortenerNotFoundException;
import com.notarius.urlshortener.urlshortener.repository.UrlShortenerRepository;
import com.notarius.urlshortener.urlshortener.service.UrlShortenerService;

@Service
@Transactional
public class UrlShortenerServiceImpl implements UrlShortenerService {

	private UrlShortenerRepository urlShortenerRepository;
	
	private Base62 base62;
	
	@Autowired
	public UrlShortenerServiceImpl(UrlShortenerRepository urlShortenerRepository,
			Base62 base62) {
		super();
		this.urlShortenerRepository = urlShortenerRepository;
		this.base62 = base62;
	}

	@Override
	public UrlShortener saveUrl(UrlShortener urlShortener) {
		UrlShortener url = urlShortenerRepository.save(urlShortener);
		url.setUrlShort(base62.toBase62(url.getId()));
		return url;
	}

	@Override
	public UrlShortener getUrl(String shortenUrl) {
		long bas10 = base62.toBase10(shortenUrl);
		return findUrlShortener(bas10);
	}

	@Override
	public UrlShortener findUrlShortener(Long id) {
		Assert.notNull(id, "Id cannot be null");
		
		Optional<UrlShortener> urlShortener = urlShortenerRepository.findById(id);
		
		if (!urlShortener.isPresent()) {
			throw new UrlShortenerNotFoundException("The UrlShortener with id " + id + " is not found.");
		}
		
		return urlShortener.get();
	}
}
