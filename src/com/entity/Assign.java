package com.entity;

public class Assign{
	private int assign_id;
	private String  class_name, subject_name, teacher_name;
	
	
	public Assign() {
		// TODO Auto-generated constructor stub
	}


	public int getAssign_id() {
		return assign_id;
	}


	public void setAssign_id(int assign_id) {
		this.assign_id = assign_id;
	}


	public String getClass_name() {
		return class_name;
	}


	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}


	public String getSubject_name() {
		return subject_name;
	}


	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}


	public String getTeacher_name() {
		return teacher_name;
	}


	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}


	public Assign(int assign_id, String class_name, String subject_name, String teacher_name) {
		super();
		this.assign_id = assign_id;
		this.class_name = class_name;
		this.subject_name = subject_name;
		this.teacher_name = teacher_name;
	}


	public Assign(String class_name, String subject_name, String teacher_name) {
		super();
		this.class_name = class_name;
		this.subject_name = subject_name;
		this.teacher_name = teacher_name;
	}


		
}