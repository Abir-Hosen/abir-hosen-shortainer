package com.abir.shortainer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.abir.shortainer.modal.Tracker;

@Repository("trackerRepository")
public interface TrackerRepository extends JpaRepository<Tracker, Long> {
	
	public List<Tracker> findByShortainerId(Long id);
	
	@Query("SELECT COUNT(t) FROM Tracker t INNER JOIN Shortainer s ON s.id=?1")
	public Long totalClikByShortainer(Long id);
}
