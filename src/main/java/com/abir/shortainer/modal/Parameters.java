package com.abir.shortainer.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Parameters {

	@Id
	@GeneratedValue
	private Long id;
	private String Param1;
	private String Param2;
	
	public Parameters() {
		super();
	}
	public Parameters(Long id, String param1, String param2) {
		super();
		this.id = id;
		Param1 = param1;
		Param2 = param2;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getParam1() {
		return Param1;
	}
	public void setParam1(String param1) {
		Param1 = param1;
	}
	public String getParam2() {
		return Param2;
	}
	public void setParam2(String param2) {
		Param2 = param2;
	}
	@Override
	public String toString() {
		return "Parameters [id=" + id + ", Param1=" + Param1 + ", Param2=" + Param2 + "]";
	}

}
