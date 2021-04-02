package com.abir.shortainer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.abir.shortainer.modal.Shortainer;

@Repository("shortainerRepository")
public interface ShortainerRepository extends JpaRepository<Shortainer, Long> {
	
	@Query("select s from Shortainer s where s.shortUrlDomain like ?1 AND s.shortUrl like ?2")
	public Shortainer FindByShortUrlDomainAndUrl(String shortUrlDomain, String shortUrl);

}
