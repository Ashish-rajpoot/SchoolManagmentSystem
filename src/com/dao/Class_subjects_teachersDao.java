package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.entity.Class_subjects_teachers;
import com.entity.Classes;
import com.entity.Subjects;
import com.entity.Teachers;
public class Class_subjects_teachersDao {

//get all classes
	public List<Class_subjects_teachers> getAllClassesSubjectsTeachers() {
		List<Class_subjects_teachers> class_subjects_teachers = new ArrayList<>();
		String sql = "SELECT * FROM class_subjects_teachers";
		try (Connection connection = Database.getConnection();
				Statement statement = connection.createStatement();
				ResultSet set = statement.executeQuery(sql)) {

			while (set.next()) {
				
				int class_id = set.getInt("class_id");
				int subject_id = set.getInt("subject_id");
				int teacher_id = set.getInt("teacher_id");
				int assign_id = set.getInt("assign_id");
				Classes class_name= com.dao.ClassDao.selectClassById(set.getInt("class_id"));
				Subjects subject_name= com.dao.SubjectDao.selectSubjectById(set.getInt("subject_id"));
				Teachers teacher_name= com.dao.TeacherDao.selectTeacherById(set.getInt("teacher_id"));

				class_subjects_teachers.add(new Class_subjects_teachers(class_id,subject_id,teacher_id,assign_id,class_name,subject_name,teacher_name));  
			}
		
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return class_subjects_teachers;
	}


	// Add all classes
	
	public void  addClassTeacherSubject(Class_subjects_teachers class_subjects_teachers) {     

		String sql = "INSERT INTO class_subjects_teachers (class_id,teacher_id,subject_id) VALUES(?,?,?)";
	

		try (Connection connection = Database.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setInt(1,class_subjects_teachers.getClass_id());
			preparedStatement.setInt(2,class_subjects_teachers.getTeacher_id());
			preparedStatement.setInt(3,class_subjects_teachers.getSubject_id()); 	
			preparedStatement.executeUpdate();           
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Select User by id;	
	public Class_subjects_teachers selectClass_subjects_teachersByClassId(int id) {
		Class_subjects_teachers class_subjects_teachers = null;
		String sql ="SELECT * FROM class_subjects_teachers WHERE assign_id=?";
		try(Connection connection = Database.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setInt(1, id);
			ResultSet set = preparedStatement.executeQuery();

			while (set.next()) {
				int assign_id = set.getInt("assign_id");
				int class_id = set.getInt("class_id");
				int teacher_id = set.getInt("teacher_id");
				int subject_id = set.getInt("subject_id");
				Classes class_name= com.dao.ClassDao.selectClassById(set.getInt("class_id"));
				Subjects subject_name= com.dao.SubjectDao.selectSubjectById(set.getInt("subject_id"));
				Teachers teacher_name= com.dao.TeacherDao.selectTeacherById(set.getInt("teacher_id"));

				class_subjects_teachers=(new Class_subjects_teachers(class_id,subject_id,teacher_id,assign_id,class_name,subject_name,teacher_name));  
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return class_subjects_teachers;
		
	}

	//Delete User;

	public boolean deleteClass_subjects_teachers(int assign_id) throws SQLException{

		String sql = "DELETE  FROM class_subjects_teachers WHERE assign_id=?";
		boolean classdeleted = false;
		try(Connection connection = Database.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {		
			preparedStatement.setInt(1, assign_id);
			classdeleted = preparedStatement.executeUpdate() > 0;
			connection.close();
		}catch (SQLException e) {
			// TODO: handle exception
		}
		return classdeleted;
	}

	//update User;

	public  boolean  updateClass_subjects_teachers(Class_subjects_teachers class_subjects_teachers) {
		String sql = "UPDATE class_subjects_teachers SET  subject_id=?, teacher_id=?, class_id=? WHERE assign_id=?";
		boolean classupdate = false;
		try(Connection connection = Database.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1,class_subjects_teachers.getSubject_id());
			preparedStatement.setInt(2,class_subjects_teachers.getTeacher_id());
			preparedStatement.setInt(3, class_subjects_teachers.getClass_id());
			preparedStatement.setInt(4, class_subjects_teachers.getAssign_id());

			classupdate = preparedStatement.executeUpdate() > 0;
			connection.close();
		}catch (SQLException e) {
			// TODO: handle exception
		}
		return classupdate;
	}

	
	
	//Get teacher and subject with class_id


	public static List<Subjects> subjectByClassId(int class_id){

		List<Subjects> subject = new ArrayList<>();
		String sql = "SELECT subject_id from class_subjects_teachers WHERE class_id ="+class_id;
		try (	Connection connection=Database.getConnection();
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(sql)){
			while(rs.next()) {
				int subjectid=rs.getInt("subject_id");
				subject.add(SubjectDao.selectSubjectById(subjectid));
				connection.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return subject;
	}

	//Get teacher and subject with class_id

	public List<Teachers> teacherByClassId(int class_id){

		List<Teachers> teacher = new ArrayList<>();
		String sql = "SELECT teacher_id from class_subjects_teachers WHERE class_id ="+class_id;
		try (	Connection connection=Database.getConnection();
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(sql)){
			while(rs.next()) {
				int teacherid=rs.getInt("teacher_id");
				teacher.add(TeacherDao.selectTeacherById(teacherid));
				connection.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return teacher;
	}
	 public static List<Classes> getClassesWithTeacherId(Connection connection, int teacher_id) {

	        List<Classes> classes = new ArrayList<>();

	        String sql = "SELECT DISTINCT class_id from class_subjects_teachers WHERE teacher_id = " + teacher_id;

	        try (Statement statement = connection.createStatement(); ResultSet set = statement.executeQuery(sql)) {

	            while (set.next())
	                classes.add(ClassDao.selectClassById(set.getInt("class_id")));
	            connection.close();

	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	        return classes;
	    }

	 public static List<Subjects> getSubjectsWithTeacherId(Connection connection, int teacher_id) {

	        List<Subjects> subjects = new ArrayList<>();

	        String sql = "SELECT DISTINCT subject_id FROM class_subjects_teachers WHERE teacher_id = " + teacher_id;

	        try (Statement statement = connection.createStatement(); ResultSet set = statement.executeQuery(sql)) {

	            while (set.next())
	                subjects.add(SubjectDao.selectSubjectById(set.getInt("subject_id")));
	            connection.close();

	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	        return subjects;
	    }

	 
	 public static Teachers getTeachersWithClassAndSubjectId(Connection connection, int class_id, int subject_id) {

	        Teachers teacher = null;

	        String sql = "SELECT teacher_id FROM class_subjects_teachers WHERE class_id = " + class_id
	                + " AND subject_id = " + subject_id;

	        try (Statement statement = connection.createStatement(); ResultSet set = statement.executeQuery(sql)) {

	            if (set.next())
	                teacher = TeacherDao.selectTeacherById(set.getInt("teacher_id"));
	            connection.close();

	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	        return teacher;
	    }

}
