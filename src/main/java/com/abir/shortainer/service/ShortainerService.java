package com.abir.shortainer.service;

import java.util.List;

import com.abir.shortainer.modal.Shortainer;

public interface ShortainerService {
	
	public Shortainer save(Shortainer shortainer);
	public List<Shortainer> findAll();
	public Shortainer findById(Long id);
	public Shortainer findByShortUrlDomainAndUrl(String shortUrlDomain, String shortUrl);

}
