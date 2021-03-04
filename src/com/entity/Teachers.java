package com.entity;

public class Teachers {
	
	private int teacher_id;
	private int age;
	private String teacher_name;
	private String gender;
	private String email_id;



	
	public Teachers(int teacher_id) {
		
		this.teacher_id = teacher_id;
	}




	public int getTeacher_id() {
		return teacher_id;
	}




	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}




	public int getAge() {
		return age;
	}




	public void setAge(int age) {
		this.age = age;
	}




	public String getTeacher_name() {
		return teacher_name;
	}




	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public String getEmail_id() {
		return email_id;
	}




	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}




	public Teachers(int teacher_id, int age, String teacher_name, String gender, String email_id) {
		super();
		this.teacher_id = teacher_id;
		this.age = age;
		this.teacher_name = teacher_name;
		this.gender = gender;
		this.email_id = email_id;
	}
	

	
	
	
}
