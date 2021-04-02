package com.abir.shortainer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abir.shortainer.modal.RequestParameter;
import com.abir.shortainer.modal.Shortainer;
import com.abir.shortainer.service.ShortainerService;

@RestController
@RequestMapping("/api/shortainer")
public class ShortainerController {
	
	@Autowired
	private ShortainerService shortainerService;
	
	@PostMapping
	Shortainer createShortainer(@RequestBody Shortainer shortainer, RequestParameter requestParameter) {
		System.out.println("-----"+requestParameter.getParam1()+"------"+requestParameter.getParam2());
		return shortainerService.save(shortainer);
	}
	
	@GetMapping("/{id}")
	Shortainer findShortainer(@PathVariable  Long id) {
		return shortainerService.findById(id);
	}

	@GetMapping
	List<Shortainer> findAllShortainer() {
		return shortainerService.findAll();
	}

}
