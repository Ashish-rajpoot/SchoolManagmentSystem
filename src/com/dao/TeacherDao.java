package com.dao;

import com.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TeacherDao {


	public TeacherDao() {
		// TODO Auto-generated constructor stub
	}

	//Get all the teachers
	public static List<Teachers> getAllTeachers() {

		List<Teachers> teachers = new ArrayList<>();

		String sql = "SELECT * FROM teachers";


		try (Connection connection = Database.getConnection();
				Statement statement = connection.createStatement();
				ResultSet set = statement.executeQuery(sql)) {
			while (set.next()) {
				teachers.add(new Teachers(set.getInt("teacher_id"),
						set.getInt("age"),
						set.getString("teacher_name"),
						set.getString("gender"),
						set.getString("email_id")));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return teachers;
	}



	//insert Teachers
	public void  insertTeacher(Teachers teacher) {     

		String sql = "INSERT INTO teachers (age,teacher_name,email_id,gender) VALUES(?,?,?,?)";

		try (Connection connection = Database.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setInt(1,teacher.getAge());
			preparedStatement.setString(2,teacher.getTeacher_name());
			preparedStatement.setString(3,teacher.getEmail_id());
			preparedStatement.setString(4,teacher.getGender());		
			preparedStatement.executeUpdate();           

		}  catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
		}

	}

	//Select User by teacher id;	
	public static Teachers selectTeacherById(int id) {
		Teachers teach= null;
		String sql ="SELECT * FROM teachers WHERE teacher_id=?";
		try(Connection connection = Database.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setInt(1, id);
			ResultSet set = preparedStatement.executeQuery();

			while (set.next()) {

				int teacher_id = set.getInt("teacher_id");
				String teacher_name= set.getString("teacher_name");
				int age = set.getInt("age");
				String gender= set.getString("gender");
				String email= set.getString("email_id");


				teach = new Teachers(teacher_id,age,teacher_name,gender,email); 
			}
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teach;
	}

	//Delete User;
	public boolean deleteTeacher(int teacher_id) throws SQLException{
		String sql = "DELETE FROM teachers WHERE teacher_id=?";
		boolean teacherdeleted = false;
		try(Connection connection = Database.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {		
			preparedStatement.setInt(1, teacher_id);
			teacherdeleted = preparedStatement.executeUpdate() > 0;
		}catch (SQLException e) {
			// TODO: handle exception
		}
		return teacherdeleted;
	}

	//update User;

	public boolean updateTeacher(Teachers teacher) {
		boolean teacherupdate = false;
		String sql = "UPDATE teachers SET  teacher_name=?, age=?,gender=?,email_id=? WHERE teacher_id=?";
		try(Connection connection = Database.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1,teacher.getTeacher_name());
			preparedStatement.setInt(2,teacher.getAge());
			preparedStatement.setString(3, teacher.getGender());
			preparedStatement.setString(4, teacher.getEmail_id()); 
			preparedStatement.setInt(5,teacher.getTeacher_id());

			teacherupdate = preparedStatement.executeUpdate() > 0;

		}catch (SQLException e) {
			// TODO: handle exception
		}
		return teacherupdate;
	}

	//all Teachers id's
	public List<Teachers> teacherId() {
		List<Teachers> teacherid = new ArrayList<>();
		String sql ="SELECT teacher_id FROM teachers";
		try(Connection connection = Database.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			ResultSet set = preparedStatement.executeQuery();
			while (set.next()) {
				int teacher_id = set.getInt("teacher_id");       
				teacherid.add(new Teachers(teacher_id));  
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teacherid;
	}


	@SuppressWarnings("unused")
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}

	}
}
