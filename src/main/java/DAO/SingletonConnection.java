package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {

	private static Connection connection; 
	private SingletonConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Produit","root","");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		if(connection==null)
			new SingletonConnection();
		return connection;}
	}
	

