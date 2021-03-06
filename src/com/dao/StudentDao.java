package com.dao;

import com.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentDao {


	public StudentDao() {
		// TODO Auto-generated constructor stub
	}

	//Get all the Teachers
	public static List<Students> getStudents() {

		List<Students> students = new ArrayList<>();

		String sql = "SELECT * FROM students";


		try (Connection connection = Database.getConnection();
				Statement statement = connection.createStatement();
				ResultSet set = statement.executeQuery(sql)) {


			while (set.next()) {
				
				Classes classes = ClassDao.selectClassById(set.getInt("class_id"));
				students.add(new Students(set.getInt("student_id"),
						set.getString("name"),
						set.getString("email_id"),
						set.getInt("age"),
						set.getString("gender"),
						classes));
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return students;
	}

	
	//insert Teachers
		public void  insertStudent(Students students) {     

			String sql = "INSERT INTO students (name,email_id, age, gender, class_id) VALUES(?,?,?,?,?)";

			try (Connection connection = Database.getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(sql)){
				preparedStatement.setString(1,students.getName());
				preparedStatement.setString(2,students.getEmail_id());
				preparedStatement.setInt(3,students.getAge());		
				preparedStatement.setString(4,students.getGender());		
				preparedStatement.setInt(5, students.getClass_id());
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

	//Select User by student id;	
	public static Students selectStudentById(int student_id) {
		Students studnt= null;
		String sql ="SELECT * FROM students WHERE student_id=?";
		try(Connection connection = Database.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setInt(1, student_id);
			ResultSet set = preparedStatement.executeQuery();

			while (set.next()) {

				int studentid = set.getInt("student_id");
				String name= set.getString("name");
				int age = set.getInt("age");
				String gender= set.getString("gender");
				String email= set.getString("email_id");
				int classid = set.getInt("class_id");
			
				studnt = new Students(studentid,name,email,age,gender,classid); 
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studnt;
	}

	//Delete User;
	public boolean deleteStudent(int student_id) throws SQLException{
		String sql = "DELETE FROM students WHERE student_id=?";
		boolean studentdeleted = false;
		try(Connection connection = Database.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {		
			preparedStatement.setInt(1, student_id);
			studentdeleted = preparedStatement.executeUpdate() > 0;
		}catch (SQLException e) {
			// TODO: handle exception
		}
		return studentdeleted;
	}

	//update User;

	public boolean updateStudents(Students students) {
		String sql = "UPDATE students SET  name=?, age=?,gender=?,email_id=?,class_id=? WHERE student_id=?";
		boolean studentupdate = false;
		try(Connection connection = Database.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1,students.getName());
			preparedStatement.setInt(2,students.getAge());
			preparedStatement.setString(3, students.getGender());
			preparedStatement.setString(4, students.getEmail_id()); 
			preparedStatement.setInt(5,students.getClass_id()); 
			preparedStatement.setInt(6,students.getStudent_id());

			studentupdate = preparedStatement.executeUpdate() > 0;

		}catch (SQLException e) {
			// TODO: handle exception
		}
		return studentupdate;
	}

	


	//	***************************************
	//Select all Teachers with class_id
	public static List<Students> getStudentsWithClassId(int class_id) {

		List<Students> students = new ArrayList<>();

		String sql = "SELECT * FROM students WHERE class_id = " + class_id + " ORDER BY student_id";

		try (Connection connection = Database.getConnection();
				Statement statement = connection.createStatement();
				ResultSet set = statement.executeQuery(sql)) {

			while (set.next())
				students.add(new Students(set.getInt("student_id"),
						set.getString("name"),
						set.getString("email_id"),
						set.getInt("age"),
						set.getString("gender"), 
						set.getInt("class_id")));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}

	// Student counts

	public static int studentsCount() {

		int count = 0;

		String sql = "SELECT COUNT(student_id) AS count FROM students";

		try (Connection connection = Database.getConnection();
				Statement statement = connection.createStatement();
				ResultSet set = statement.executeQuery(sql)) {
			if (set.next())
				count = set.getInt("count");
			System.out.println(count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}
	//Count Teachers as per Class_id
	public  int getClassStrength(int class_id) {
		int strength = 0;
		try (Connection connection = Database.getConnection()) {
			String sql = "SELECT COUNT(class_id)  FROM students WHERE class_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, class_id);
			ResultSet set = statement.executeQuery();
			if (set.next())
				strength = set.getInt("COUNT(class_id)");
			statement.close();
			set.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

		return strength;
	}

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
