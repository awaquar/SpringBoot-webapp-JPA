package com.hussain.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {

	@Id
	private int id;
	private String name;
	
	public Alien(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Alien() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return id+":"+name;
	}
}
