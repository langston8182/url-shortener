package com.notarius.urlshortener.urlshortener.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.notarius.urlshortener.urlshortener.component.Base62;
import com.notarius.urlshortener.urlshortener.domain.UrlShortener;
import com.notarius.urlshortener.urlshortener.repository.UrlShortenerRepository;
import com.notarius.urlshortener.urlshortener.service.UrlShortenerService;
import com.notarius.urlshortener.urlshortener.util.Utils;

@Service
@Transactional
public class UrlShortenerServiceImpl implements UrlShortenerService {

	private UrlShortenerRepository urlShortenerRepository;

	private Base62 base62;

	@Autowired
	public UrlShortenerServiceImpl(UrlShortenerRepository urlShortenerRepository, Base62 base62) {
		super();
		this.urlShortenerRepository = urlShortenerRepository;
		this.base62 = base62;
	}

	@Override
	public UrlShortener saveUrl(UrlShortener urlShortener) {
		UrlShortener url = urlShortenerRepository.save(urlShortener);
		url.setUrlShort(Utils.getDomain(url.getUrl()) + base62.toBase62(url.getId()));
		return url;
	}

	@Override
	public UrlShortener getUrl(String shortenUrl) {
		long bas10 = base62.toBase10(shortenUrl);
		UrlShortener storedUrl = findUrlShortener(bas10);

		if (storedUrl == null) {
			// Transient urlShortener
			storedUrl = new UrlShortener();
			storedUrl.setUrl(shortenUrl);
		}

		return storedUrl;
	}

	@Override
	public UrlShortener findUrlShortener(Long id) {
		Assert.notNull(id, "Id cannot be null");

		Optional<UrlShortener> urlShortener = urlShortenerRepository.findById(id);

		return urlShortener.isPresent() ? urlShortener.get() : null;
	}
}
