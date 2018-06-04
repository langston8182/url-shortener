package com.notarius.urlshortener.urlshortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notarius.urlshortener.urlshortener.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public User findByLogin(String login);
	
}
