package com.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLDBConnection {
	
	private static final String url = "jdbc:mysql://localhost:3306/indra";
	private static final String username = "root";
	private static final String password = "1234";
		
	public static Connection createConnection()
	{
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		    con = DriverManager.getConnection(url,username,password);
			
			
		} catch (Exception e) {
			// Exception is parent name mysqlEception and ClassNotFoundEception
			
			e.printStackTrace();
		}
		
		return con;  
		//class return type is same not different - ex. datatype int = return type int 
	}
}
