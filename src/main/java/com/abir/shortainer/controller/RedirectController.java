package com.abir.shortainer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.abir.shortainer.modal.Shortainer;
import com.abir.shortainer.modal.Tracker;
import com.abir.shortainer.service.ShortainerService;
import com.abir.shortainer.service.TrackerService;

@RestController
@RequestMapping
public class RedirectController {

	@Autowired
	private ShortainerService shortainerService;

	@Autowired
	private TrackerService trackerService;
    
	@GetMapping("/{shortUrlDomain}/{shortUrl}")
	ModelAndView redirectUrl(@PathVariable  String shortUrlDomain, @PathVariable  String shortUrl, HttpServletRequest request) {
		Shortainer shortainer = shortainerService.findByShortUrlDomainAndUrl(shortUrlDomain, shortUrl);
		Tracker tracker = new Tracker();
		
		String browser = "";
		String os = "";
		String ip = "";
		
		if (request.getHeader("User-Agent") != null) {
			
			if (request.getHeader("User-Agent").toLowerCase().contains("chrome")) browser = "Chrome";
			else if(request.getHeader("User-Agent").toLowerCase().contains("firefox")) browser = "Firefox";
			else browser = request.getHeader("User-Agent");
			
			if (request.getHeader("User-Agent").toLowerCase().contains("linux")) os = "Linux";
			else if (request.getHeader("User-Agent").toLowerCase().contains("windows")) os = "Windows";
			else if (request.getHeader("User-Agent").toLowerCase().contains("iphone")) os = "Iphone";
			else if (request.getHeader("User-Agent").toLowerCase().contains("android")) os = "Android";
			else if (request.getHeader("User-Agent").toLowerCase().contains("macos")) os = "MacOS";
			else os = "others";
		}
		
		if(request.getHeader("x-forwarded-for") != null) ip = request.getHeader("x-forwarded-for");
		else if (request.getRemoteAddr() != null) ip = request.getRemoteAddr();
		else ip = request.getLocalAddr();

		tracker.setBrowser(browser);
		tracker.setOs(os);
		tracker.setIp(ip);
		tracker.setShortainer(shortainer);
		
		trackerService.save(tracker);

		return new ModelAndView("redirect:" + shortainer.getLongUrl());
	}
}
