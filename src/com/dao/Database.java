package com.dao;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import javax.servlet.ServletContext;



public class Database implements AutoCloseable {

	private static Connection connection = null;


	public static Connection getConnection() {


		try {
//			FileInputStream fis = new FileInputStream("G:\\Eclipse_latest\\SchoolManagmentSystem\\WebContent\\WEB-INF\\configuration\\data.properties");
//			Properties proper = new Properties();			
//			proper.load(fis);
//
//			String driver = proper.getProperty("driver");
//			String url = proper.getProperty("url");
//			String username = proper.getProperty("username");
//			String password = proper.getProperty("password");

//			  String driver = "com.mysql.cj.jdbc.Driver";
//	            String url = "jdbc:mysql://localhost:3306/schoolmanagementapp?useSSL=false";
//	            String username = "root";
//	            String password = "root";
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String url = "jdbc:sqlserver://school-sql-server.database.windows.net:1433;database=schoolmanagementapp;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30";
			String username = "cloudadmin";
			String password = "sharepoint142@";

//	          jdbc:sqlserver://school-sql-server.database.windows.net:1433;database=schoolmanagementapp;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;
			Class.forName(driver);
			connection = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return connection;
	}	


	@Override
	public void close() throws Exception {

		if (connection != null)
			connection.close();
	}
}
