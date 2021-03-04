package com.entity;

public class Class_subjects_teachers{
	private int class_id, subject_id, teacher_id,assign_id;
	private Classes cls;
	private Subjects sub;
	private Teachers techer;
	
	
	public Class_subjects_teachers() {
		// TODO Auto-generated constructor stub
	}


	public int getClass_id() {
		return class_id;
	}


	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}


	public int getSubject_id() {
		return subject_id;
	}


	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}


	public int getTeacher_id() {
		return teacher_id;
	}


	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}


	public int getAssign_id() {
		return assign_id;
	}


	public void setAssign_id(int assign_id) {
		this.assign_id = assign_id;
	}


	public Classes getCls() {
		return cls;
	}


	public void setCls(Classes cls) {
		this.cls = cls;
	}


	public Subjects getSub() {
		return sub;
	}


	public void setSub(Subjects sub) {
		this.sub = sub;
	}


	public Teachers getTecher() {
		return techer;
	}


	public void setTecher(Teachers techer) {
		this.techer = techer;
	}


	public Class_subjects_teachers(int class_id, int subject_id, int teacher_id, int assign_id, Classes cls,
			Subjects sub, Teachers techer) {
		super();
		this.class_id = class_id;
		this.subject_id = subject_id;
		this.teacher_id = teacher_id;
		this.assign_id = assign_id;
		this.cls = cls;
		this.sub = sub;
		this.techer = techer;
	}


	public Class_subjects_teachers(int class_id, int subject_id, int teacher_id, int assign_id) {
		super();
		this.class_id = class_id;
		this.subject_id = subject_id;
		this.teacher_id = teacher_id;
		this.assign_id = assign_id;
	}


	public Class_subjects_teachers(int class_id, int subject_id, int teacher_id) {
		super();
		this.class_id = class_id;
		this.subject_id = subject_id;
		this.teacher_id = teacher_id;
	}


	
}