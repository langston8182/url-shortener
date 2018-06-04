package com.notarius.urlshortener.urlshortener.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.notarius.urlshortener.urlshortener.interceptor.BaseInterceptor;


@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Bean
	public LocaleChangeInterceptor getLocaleChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		
		return lci;
	}
	
	@Bean
	public BaseInterceptor baseInterceptor() {
		BaseInterceptor baseInterceptor = new BaseInterceptor();
		return baseInterceptor;
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setCookieName("appLocaleCookie");
		resolver.setCookieMaxAge(60*60);
		
		return resolver;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(baseInterceptor());
		registry.addInterceptor(getLocaleChangeInterceptor());
	}
	
}
