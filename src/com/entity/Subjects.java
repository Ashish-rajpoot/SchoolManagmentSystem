package com.entity;

public class Subjects {
	
	private int subject_id;
	private String name;
	
	public Subjects() {
		// TODO Auto-generated constructor stub
	}

	public int getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Subjects(int subject_id, String name) {
		super();
		this.subject_id = subject_id;
		this.name = name;
	}

	public Subjects(int subject_id) {
		super();
		this.subject_id = subject_id;
	}
	
	

}
