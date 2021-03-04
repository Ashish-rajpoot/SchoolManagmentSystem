package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.entity.Students;
import com.entity.Subjects;
import com.entity.Subjects;


public class SubjectDao {

	private static StudentDao studentDao;
	
   public SubjectDao() {
	// TODO Auto-generated constructor stub
}
   
   //select all Subjects
    public static List<Subjects> getAllSubjects() {

        List<Subjects> subjects = new ArrayList<>();

        String sql = "SELECT * FROM Subjects";

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement();
             ResultSet set = statement.executeQuery(sql)) {

            while (set.next()) {
            	studentDao = new StudentDao();
                int subject_id = set.getInt("subject_id");
                String name= set.getString("name");
               
//                int strength = studentDao.getClassStrength(class_id);

                subjects.add(new Subjects(subject_id,name));  
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return subjects;
    }
    
    // Insert Class
    public void  addSubject(Subjects subjects) {     

        String sql = "INSERT INTO subjects (subject_id,name) VALUES(?,?)";

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            	 preparedStatement.setInt(1,subjects.getSubject_id());
 				preparedStatement.setString(2,subjects.getName());
 				preparedStatement.executeUpdate();           

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
  //Select User by id;	
  	public static Subjects selectSubjectById(int subject_id) {
  			Subjects subje = null;
  			String sql ="SELECT * FROM subjects WHERE subject_id=?";
  		try(Connection connection = Database.getConnection();
  				PreparedStatement preparedStatement = connection.prepareStatement(sql)){
  			preparedStatement.setInt(1, subject_id);
  			ResultSet set = preparedStatement.executeQuery();
  			
  			while (set.next()) {

                int subject_id1 = set.getInt("subject_id");
                String name= set.getString("name");

                subje = new Subjects(subject_id1,name);  
            }

  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		return subje;
  	}
  	
  //Delete User;
	
  	public boolean deleteSubject(int id) throws SQLException{
  		
  		String sql = "DELETE FROM subjects WHERE subject_id=?";
  		boolean classdeleted = false;
  		try(Connection connection = Database.getConnection();
  				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {		
  			preparedStatement.setInt(1, id);
  			classdeleted = preparedStatement.executeUpdate() > 0;
  			
  		}catch (SQLException e) {
  			// TODO: handle exception
  		}
  		return classdeleted;
  	}
  	
  //update User;
	
  	public boolean updateSubject(Subjects subjects) {
  		String sql = "UPDATE subjects SET  name=? WHERE subject_id=?";
  		boolean classupdate = false;
  		try(Connection connection = Database.getConnection();
  				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
  			preparedStatement.setString(1,subjects.getName());
  			 preparedStatement.setInt(2,subjects.getSubject_id());
  			
  			classupdate = preparedStatement.executeUpdate() > 0;
  			preparedStatement.close();
  			
  		}catch (SQLException e) {
  			// TODO: handle exception
  		}
  		return classupdate;
  	}
  	
//  	public Subjects studentid(int id ) {
//			Subjects studentid = null;
//			String sql ="SELECT student_id FROM subjects WHERE student_id=? ";
//		try(Connection connection = Database.getConnection();
//				PreparedStatement preparedStatement = connection.prepareStatement(sql)){
//		
//			ResultSet set = preparedStatement.executeQuery();
//			
//			while (set.next()) {
//
//            int student_id = set.getInt("class_id");
//           
//
//            studentid=new Subjects(student_id, sql);  
//        }
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return studentid;
//	}
//  	
  //all Subject id's
  		public List<Subjects> subjectId() {
  			List<Subjects> subjectid = new ArrayList<>();
  			String sql ="SELECT student_id FROM students";
  			try(Connection connection = Database.getConnection();
  					PreparedStatement preparedStatement = connection.prepareStatement(sql)){
  				ResultSet set = preparedStatement.executeQuery();
  				while (set.next()) {
  					int subject_id = set.getInt("student_id");       
  					subjectid.add(new Subjects(subject_id));  
  				}
  			} catch (SQLException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
  			return subjectid;
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
