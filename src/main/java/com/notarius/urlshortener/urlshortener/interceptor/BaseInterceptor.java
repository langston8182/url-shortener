package com.notarius.urlshortener.urlshortener.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.notarius.urlshortener.urlshortener.domain.UrlShortener;
import com.notarius.urlshortener.urlshortener.service.UrlShortenerService;
import com.notarius.urlshortener.urlshortener.util.SpringBeanUtils;

public class BaseInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private UrlShortenerService urlShortenerService;

	public BaseInterceptor(UrlShortenerService urlShortenerService) {
		super();
		this.urlShortenerService = SpringBeanUtils.getBean(UrlShortenerService.class);
	}

	public BaseInterceptor() {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String shortUrl = request.getRequestURI().substring(1);
		UrlShortener urlShortener = null;
		if (!shortUrl.isEmpty() && shortUrl != null) {
			urlShortener = urlShortenerService.getUrl(shortUrl);
			if (urlShortener.getId() != null) {
				response.sendRedirect(urlShortener.getUrl());
				return false;
			}
		}
		return super.preHandle(request, response, handler);
	}
}
