package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.entity.Classes;
import com.entity.Subjects;
import com.entity.Teachers;


public class ClassDao {

	private static StudentDao studentDao;

	public ClassDao() {
		// TODO Auto-generated constructor stub
	}

	//select all classes
	public List<Classes> getAllClassesWithStrength() {

		List<Classes> classes = new ArrayList<>();

		String sql = "SELECT * FROM classes";

		try (Connection connection = Database.getConnection();
				Statement statement = connection.createStatement();
				ResultSet set = statement.executeQuery(sql)) {

			while (set.next()) {
				studentDao = new StudentDao();
				int class_id = set.getInt("class_id");
				String class_name= set.getString("class_name");
				int seats = set.getInt("seats");
				int strength = studentDao.getClassStrength(class_id);
				List<Subjects> subject = SubjectDao.getAllSubjects();
				List<Teachers> teacher = TeacherDao.getAllTeachers();
				

				classes.add(new Classes(class_id,class_name,seats,strength,teacher,subject));  
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return classes;
	}

	// Insert Class
	public void  addClass(Classes classes) {     

		String sql = "INSERT INTO classes (class_id,class_name,seats) VALUES(?,?,?)";

		try (Connection connection = Database.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setInt(1,classes.getClass_id());
			preparedStatement.setString(2,classes.getClass_name());
			preparedStatement.setInt(3,classes.getSeats()); 	
			preparedStatement.executeUpdate();           

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Select User by id;	
	public static Classes selectClassById(int id) {
		Classes classes = null;
		String sql ="SELECT * FROM classes WHERE class_id=?";
		try(Connection connection = Database.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setInt(1, id);
			ResultSet set = preparedStatement.executeQuery();

			while (set.next()) {

				int class_id = set.getInt("class_id");
				String class_name= set.getString("class_name");
				int seats = set.getInt("seats");

				classes=new Classes(class_id,class_name,seats);  
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classes;
	}

	//Delete User;

	public boolean deleteClass(int class_id) throws SQLException{

		String sql = "DELETE FROM classes WHERE class_id=?";
		boolean classdeleted = false;
		try(Connection connection = Database.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {		
			preparedStatement.setInt(1, class_id);
			classdeleted = preparedStatement.executeUpdate() > 0;

		}catch (SQLException e) {
			// TODO: handle exception
		}
		return classdeleted;
	}

	//update User;

	public boolean updateClass(Classes classes) {
		String sql = "UPDATE classes SET  class_name=?, seats=? WHERE class_id=?";
		boolean classupdate = false;
		try(Connection connection = Database.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1,classes.getClass_name());
			preparedStatement.setInt(2,classes.getSeats());
			preparedStatement.setInt(3, classes.getClass_id());

			classupdate = preparedStatement.executeUpdate() > 0;
			preparedStatement.close();
		}catch (SQLException e) {
			// TODO: handle exception
		}
		return classupdate;
	}

	//all class id's
	public List<Classes> classId() {
		List<Classes> classid = new ArrayList<>();
		String sql ="SELECT class_id FROM classes";
		try(Connection connection = Database.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			ResultSet set = preparedStatement.executeQuery();
			while (set.next()) {
				int class_id = set.getInt("class_id");       
				classid.add(new Classes(class_id));  
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classid;
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
