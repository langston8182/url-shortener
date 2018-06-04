package com.notarius.urlshortener.urlshortener.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.notarius.urlshortener.urlshortener.domain.User;

public interface UserService extends UserDetailsService {

	public User findByLogin(String login);
	
}
