package com.abir.shortainer.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Tracker {
	
	@Id
	@GeneratedValue
	private long id;
	private String browser;
	private String os;
	private String ip;
	
	@ManyToOne
	private Shortainer shortainer;

	public Tracker() {
		super();
	}
	public Tracker(long id, String browser, String os, String ip, Shortainer shortainer) {
		super();
		this.id = id;
		this.browser = browser;
		this.os= os;
		this.ip = ip;
		this.shortainer = shortainer;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Shortainer getShortainer() {
		return shortainer;
	}
	public void setShortainer(Shortainer shortainer) {
		this.shortainer = shortainer;
	}
	@Override
	public String toString() {
		return "Tracker [id=" + id + ", browser=" + browser + ", os=" + os + ", ip=" + ip + ", shortainer=" + shortainer
				+ "]";
	}

}
