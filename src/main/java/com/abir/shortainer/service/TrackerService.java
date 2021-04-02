package com.abir.shortainer.service;

import java.util.List;

import com.abir.shortainer.modal.Tracker;

public interface TrackerService {
	
	public Tracker save(Tracker tracker);
	public List<Tracker> findAll();
	public List<Tracker> findByShortainer(Long id);
	public Long findTotalClickByShortainer(Long id);
	public Tracker findById(Long id);

}
