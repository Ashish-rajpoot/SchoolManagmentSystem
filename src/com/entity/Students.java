package com.entity;

public class Students {

	private int student_id;
	private String name;	
	private String email_id;
	private int age;
	private String gender;
	private int class_id;
	private Classes cls;
	
	
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Classes getCls() {
		return cls;
	}
	public void setCls(Classes cls) {
		this.cls = cls;
	}
	
	
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	
	
	
	public Students(int student_id) {
		super();
		this.student_id = student_id;
	}
	public Students(int student_id, String name, String email_id, int age, String gender, int class_id) {
		super();
		this.student_id = student_id;
		this.name = name;
		this.email_id = email_id;
		this.age = age;
		this.gender = gender;
		this.class_id = class_id;
	}
	
	
	public Students(String name, String email_id, int age, String gender, int class_id) {
		super();
		this.name = name;
		this.email_id = email_id;
		this.age = age;
		this.gender = gender;
		this.class_id = class_id;
	}
	public Students(int student_id, String name, String email_id, int age, String gender, Classes cls) {
		super();
		this.student_id = student_id;
		this.name = name;
		this.email_id = email_id;
		this.age = age;
		this.gender = gender;
		this.cls = cls;
	}
	public Students() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
