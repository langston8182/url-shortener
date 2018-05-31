package com.notarius.urlshortener.urlshortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notarius.urlshortener.urlshortener.domain.UrlShortener;

@Repository
public interface UrlShortenerRepository extends JpaRepository<UrlShortener, Long>{

}
