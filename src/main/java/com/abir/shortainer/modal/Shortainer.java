package com.abir.shortainer.modal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Shortainer {
	
	@Id
	@GeneratedValue
	private long id;
	private String longUrl;
	private String shortUrlDomain;
	private String shortUrl;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Parameters parameters;
	
	public Shortainer() {
		super();
	}
	public Shortainer(long id, String longUrl, String shortUrlDomain, String shortUrl, Parameters parameters) {
		super();
		this.id = id;
		this.longUrl = longUrl;
		this.shortUrlDomain = shortUrlDomain;
		this.shortUrl = shortUrl;
		this.parameters = parameters;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLongUrl() {
		return longUrl;
	}
	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}
	public String getShortUrlDomain() {
		return shortUrlDomain;
	}
	public void setShortUrlDomain(String shortUrlDomain) {
		this.shortUrlDomain = shortUrlDomain;
	}
	public String getShortUrl() {
		return shortUrl;
	}
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
	public Parameters getParameters() {
		return parameters;
	}
	public void setParameters(Parameters parameters) {
		this.parameters = parameters;
	}
	@Override
	public String toString() {
		return "Shortainer [id=" + id + ", longUrl=" + longUrl + ", shortUrlDomain=" + shortUrlDomain + ", shortUrl="
				+ shortUrl + ", parameters=" + parameters + "]";
	}

}
