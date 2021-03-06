package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.entity.Users;
import com.mysql.cj.Session;

@SuppressWarnings("unused")
public class UserDao {

	public List<Users> selectAllUsers() throws SQLException{
		List<Users> users = new ArrayList<>();
		String sql= "SELECT * FROM users";
		try(Connection connection = Database.getConnection();
				Statement statement = connection.createStatement();
				ResultSet set = statement.executeQuery(sql)){
			
			while(set.next()) {
				int user_id = set.getInt("user_id");
				String name = set.getString("name");
				String email= set.getString("email");
				String password = set.getString("password");
				String role = set.getString("role");
				users.add(new Users(user_id,name,email,password,role));
			}
		}
		return users;
	}
	
	
	public void insertUser(Users user){
		
		String sql = "INSERT INTO users(name,email,password,role) VALUES(?,?,?,?)";
		try(Connection connection = Database.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getRole());
			
			 preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Users selectById(int id) {
		Users users= null;
		String sql = "SELECT * FROM users WHERE user_id=?";
		
		try(Connection connection= Database.getConnection();
				PreparedStatement preparedStatement= connection.prepareStatement(sql)){
			preparedStatement.setInt(1, id);
			ResultSet set = preparedStatement.executeQuery();
			while(set.next()) {
				int user_id = set.getInt("user_id");
				String name = set.getString("name");
				String email = set.getString("email");
				String password = set.getString("password");
				String role = set.getString("role");
				
				users = new Users(user_id,name,email,password,role);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	public boolean deleteUser(int id) {
		String sql = "DELETE  FROM users WHERE user_id=?";
		boolean deleteUser = false;
		try(Connection connection = Database.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setInt(1, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deleteUser;
	}
	
	public boolean updateUser(Users users) {
		String sql = "UPDATE users SET name=?, email=?, password=?, role=? WHERE user_id=?";
		boolean updateUser = false;
		try(Connection connection = Database.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setString(1, users.getName());
			preparedStatement.setString(2, users.getEmail());
			preparedStatement.setString(3, users.getPassword());
			preparedStatement.setString(4, users.getRole());
			preparedStatement.setInt(5, users.getUser_id());
			
			updateUser = preparedStatement.executeUpdate() > 0;
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateUser;
	}
	public boolean updateNameEmail(Users users) {
		String sql = "UPDATE users SET name=?, email=? WHERE user_id=?";
		boolean updateUser = false;
		try(Connection connection = Database.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setString(1, users.getName());
			preparedStatement.setString(2, users.getEmail());
			preparedStatement.setInt(3, users.getUser_id());
			
			updateUser = preparedStatement.executeUpdate() > 0;
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateUser;
	}

	public boolean updatePassword(Users users) {
		String sql = "UPDATE users SET password=? WHERE user_id=?";
		boolean updateUser = false;
		try(Connection connection = Database.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setString(1, users.getPassword());
			preparedStatement.setInt(2, users.getUser_id());
			
			updateUser = preparedStatement.executeUpdate() > 0;
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateUser;
	}

	public void insertUser(com.user.controller.Users users) {
		// TODO Auto-generated method stub
		
	}
}
