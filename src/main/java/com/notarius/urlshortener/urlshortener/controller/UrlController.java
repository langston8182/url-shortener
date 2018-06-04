package com.notarius.urlshortener.urlshortener.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.notarius.urlshortener.urlshortener.domain.UrlShortener;
import com.notarius.urlshortener.urlshortener.service.UrlShortenerService;

@Controller
@RequestMapping("/url")
public class UrlController {

	private UrlShortenerService urlShortenerService;

	@Autowired
	public UrlController(UrlShortenerService urlShortenerService) {
		super();
		this.urlShortenerService = urlShortenerService;
	}
	
	@RequestMapping(value = "/encode", method = RequestMethod.GET)
	public String encodeUrlGet(UrlShortener urlShortener, Model model) {
		model.addAttribute("urlShortener", new UrlShortener());
		return "url/encode";
	}
	
	@RequestMapping(value = "/encode", method = RequestMethod.POST)
	public String encodeUrl(UrlShortener urlShortener, Model model) {
		UrlShortener savedUrlShortener = urlShortenerService.saveUrl(urlShortener);
		model.addAttribute("urlShortener", savedUrlShortener);
		return "url/encode";
	}
}
