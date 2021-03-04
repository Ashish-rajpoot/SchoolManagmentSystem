package com.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class Database implements AutoCloseable {

	private static Connection connection = null;


	public static Connection getConnection() {


		try {
			FileInputStream fis = new FileInputStream("F:\\SchoolManagmentSystems\\WebContent\\WEB-INF\\configuration\\data.properties");

			Properties proper = new Properties();

			proper.load(fis);

			String driver = proper.getProperty("driver");
			String url = proper.getProperty("url");
			String username = proper.getProperty("username");
			String password = proper.getProperty("password");


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
