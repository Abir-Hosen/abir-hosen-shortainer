package com.abir.shortainer.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abir.shortainer.modal.Tracker;
import com.abir.shortainer.repository.TrackerRepository;
import com.abir.shortainer.service.TrackerService;

@Service("trackerService")
public class TrackerServiceImpl implements TrackerService {

	Logger logger = LoggerFactory.getLogger(TrackerService.class);
	
	@Autowired
	private TrackerRepository trackerRepository;

	@Override
	public Tracker save(Tracker tracker) {
		return trackerRepository.save(tracker);
	}

	@Override
	public List<Tracker> findAll() {
		return trackerRepository.findAll();
	}

	@Override
	public Tracker findById(Long id) {
		return trackerRepository.findById(id).get();
	}

	@Override
	public List<Tracker> findByShortainer(Long id) {
		return trackerRepository.findByShortainerId(id);
	}

	@Override
	public Long findTotalClickByShortainer(Long id) {
		return trackerRepository.totalClikByShortainer(id);
	}

}
