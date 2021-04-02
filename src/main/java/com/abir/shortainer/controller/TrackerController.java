package com.abir.shortainer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abir.shortainer.modal.Tracker;
import com.abir.shortainer.service.TrackerService;

@RestController
@RequestMapping("/api/tracker")
public class TrackerController {
	
	@Autowired
	private TrackerService trackerService;
	
	@PostMapping
	Tracker createTracker(@RequestBody Tracker tracker) {
		return trackerService.save(tracker);
	}
	
	@GetMapping("/{id}")
	Tracker findTracker(@PathVariable  Long id) {
		return trackerService.findById(id);
	}
	
	@GetMapping("/shortainer/{id}")
	List<Tracker> findTrackerByShortainer(@PathVariable  Long id) {
		return trackerService.findByShortainer(id);
	}
	
	@GetMapping("/counter/{id}")
	Long findTrackerCountByShortainer(@PathVariable  Long id) {
		return trackerService.findTotalClickByShortainer(id);
	}

	@GetMapping
	List<Tracker> findAllTracker() {
		return trackerService.findAll();
	}

}
