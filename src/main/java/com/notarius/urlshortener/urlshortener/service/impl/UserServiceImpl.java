package com.notarius.urlshortener.urlshortener.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.notarius.urlshortener.urlshortener.domain.User;
import com.notarius.urlshortener.urlshortener.repository.UserRepository;
import com.notarius.urlshortener.urlshortener.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User findByLogin(String login) {
		return userRepository.findByLogin(login);
	}

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		User user = findByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException(login);
        }
        
        return user;
	}

}
