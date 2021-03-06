package Persistencia;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class OracleJDBC {
	
	public Connection getConnection(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
 
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return null;
		} 
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@camburi.pucrs.br:1521:FACIN11G", "ai200193",
					"ai200193");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
 
		}
			return connection;		
	}
	
	public void tryConnection(){
			System.out.println("-------- Oracle JDBC Connection Testing ------");
			 
			try {
	 
				Class.forName("oracle.jdbc.driver.OracleDriver");
	 
			} catch (ClassNotFoundException e) {
	 
				System.out.println("Where is your Oracle JDBC Driver?");
				e.printStackTrace();
				return;
	 
			}
	 
			System.out.println("Oracle JDBC Driver Registered!");
	 
			Connection connection = null;
	 
			try {
	 
				connection = DriverManager.getConnection(
						"jdbc:oracle:thin:@trabtecnicas.cswxrcwy8a8k.us-east-1.rds.amazonaws.com:1521:ORCL", "admin",
						"trabTecnicas");
	 
			} catch (SQLException e) {
	 
				System.out.println("Connection Failed! Check output console");
				e.printStackTrace();
				return;
	 
			}
	 
			if (connection != null) {
				System.out.println("You made it, take control your database now!");
			} else {
				System.out.println("Failed to make connection!");
			}
	}
			
}
