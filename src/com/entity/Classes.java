package com.entity;

import java.util.List;

public class Classes {
	private int class_id;
    private String class_name;
    private int seats;
    private int strength;
    private List<Students> students;
    private List<Teachers> teachers;
    private List<Subjects> subjects;
 
	
	

	

	public Classes(String class_name, int seats) {
		super();
		this.class_name = class_name;
		this.seats = seats;
	}



	public Classes(int class_id, String class_name, int seats) {

	this.class_id = class_id;
	this.class_name = class_name;
	this.seats = seats;
	
}

	

	public Classes(int class_id, String class_name, int seats, int strength) {
		super();
		this.class_id = class_id;
		this.class_name = class_name;
		this.seats = seats;
		this.setStrength(strength);
	}



	public Classes(int class_id) {
	super();
	this.class_id = class_id;
}






	public int getClass_id() {
		return class_id;
	}


	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}


	public String getClass_name() {
		return class_name;
	}


	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}


	public int getSeats() {
		return seats;
	}


	public void setSeats(int seats) {
		this.seats = seats;
	}



	public int getStrength() {
		return strength;
	}



	public void setStrength(int strength) {
		this.strength = strength;
	}



	public Classes(int class_id, String class_name, int seats, int strength, List<Teachers> teachers,
			List<Subjects> subjects) {
		super();
		this.class_id = class_id;
		this.class_name = class_name;
		this.seats = seats;
		this.strength = strength;
		this.setTeachers(teachers);
		this.setSubjects(subjects);
	}



	public List<Students> getStudents() {
		return students;
	}



	public void setStudents(List<Students> students) {
		this.students = students;
	}



	public List<Teachers> getTeachers() {
		return teachers;
	}



	public void setTeachers(List<Teachers> teachers) {
		this.teachers = teachers;
	}



	public List<Subjects> getSubjects() {
		return subjects;
	}



	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}


	
	




	
	
    
    
}
