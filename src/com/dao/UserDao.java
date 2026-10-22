package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dbconnection.MySQLDBConnection;
import com.model.User;

public class UserDao {
	
	// create 2 file
	
	//All DB Operations we have write in this class
	//Save
	//get
	//update
	//delete
	// we are getting Connection here 
	Connection con = MySQLDBConnection.createConnection();
	
	//1. it is not recommended 
	
//	public void createUserTable()
//	{
//		try {
//			Statement st = con.createStatement();
//			
//			st.execute("create table user(userId int, username varchar(45), password varchar(34), email varchar(34), address varchar(45), gender varchar(40))");
//			
//			System.out.println("table created.....");
//		
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//	}
	
	//2. it is recommended
//	public void saveUser()
//	{
//		try 
//		{
//			Statement st = con.createStatement();
//			// hard coded data it is not recommended
//			String SQLquery = "insert into user value(1,'shantanu','2345','shantanushelker@gmail.com','Pune','male')";
//					
//			st.execute(SQLquery);
//			
//			System.out.println("data insert.....");
//		
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}	
//	}
	
	
	//2 way - using interface 
//	public void saveUser(int userId, String username, String password, String email, String address, String gender)
//	{
//		try 
//		{
//			Statement st = con.createStatement();
//			
//			// this is recommended
//			// dynamic data pass krne/ store krne
//			String SQLquery = "insert into user value('"+userId+"','"+username+"','"+password+"','"+email+"','"+address+"','"+gender+"')";
//					
//			st.execute(SQLquery);
//			
//			System.out.println("data insert.....");
//		
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//		
//	}
//	
	
	
	//3 way - using  PreparedStatement......with parameter
//	public void saveUser(int userId, String username, String password, String email, String address, String gender)
//	{
//		try 
//		{
//			//? la query parameter is called 
//			String SQLquery = "insert into user value(?,?,?,?,?,?)";
//			
//			PreparedStatement pst = con.prepareStatement(SQLquery);
//			
//			pst.setInt(1, userId);
//			pst.setString(2, username);
//			pst.setString(3, password);
//			pst.setString(4, email);
//			pst.setString(5, address);
//			pst.setString(6, gender);
//			
//			pst.execute();
//			
//			System.out.println("data insert.....");
//		
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
		
//	}
	
	
	
	//3 way - using  PreparedStatement......with User Object in  parameter
	// 100 % good way....
	public String saveUser(User user)
	{
		PreparedStatement pst = null;
		try 
		{
			//? la query parameter is called 
			String SQLquery = "insert into user value(?,?,?,?,?,?)";
			
			//PreparedStatement 
			
			pst = con.prepareStatement(SQLquery);
			
			// this data sequence is matter. it is written in sequence maner...
			pst.setInt(1, user.getUserId());
			pst.setString(2, user.getUsername());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getEmail());
			pst.setString(5, user.getAddress());
			pst.setString(6, user.getGender());
			
			pst.execute();
			
			//System.out.println("data insert.....");
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		finally {
			try {
				pst.close();    // for securty close the resources in finally block......
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return "user register success";
	}
	

	
	
	
	// user get data by id
	public User getUserById(int id)
	{
		PreparedStatement pst = null;
		
		User user = null;  // goble varable
		
		String sqlQuery = "select * from user where userid=?";
		
		
		try {
			pst = con.prepareStatement(sqlQuery);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery(); // select query for use executeQuery
			
			if(rs.next())
			{
				
				int userid = rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				String email = rs.getString(4);
				String address = rs.getString(5);
				String gender = rs.getString(6);
				
			    user = new User();  
				
				user.setUserId(userid);
				user.setUsername(username);
				user.setPassword(password);
				user.setEmail(email);
				user.setAddress(address);
				user.setGender(gender);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return user;
	}
	
	
	
	// all user get from db....
	public ArrayList<User> getAllUsersFromDB()
	{
		ArrayList<User> users = new ArrayList<User>();
		
		PreparedStatement pst = null;
		
		User user = null;
		
		String  sqlQuery = "select * from user";
		
		try {
			 pst = con.prepareStatement(sqlQuery);
			
			ResultSet rs = pst.executeQuery();
			
//			more than 1 record i want to get from db
			while(rs.next()) {
				
				// apan indexColumn -> 1  or labale name -> username use kru shkto.......
				// it is call also same method name and different parameter......
				
				// get data.... 
				int userid = rs.getInt("userid");
				String usernamers = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String gender = rs.getString("gender");
				
				user = new User();
				
				
				// set data....
				user.setUserId(userid);
				user.setUsername(usernamers);
				user.setPassword(password);
				user.setEmail(email);
				user.setAddress(address);
				user.setGender(gender);
				
				users.add(user); // arraylist
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return users;
	}
	
	
	
	
	
	
	// who user i want to update user
	
	public String updateUser(User user)
	{
		PreparedStatement pst = null;
		// this is sequence matter we want to give as choice.....
		String sql ="update user set username=?, password=?, email=?, address=?, gender=? where userId=?";
		
		try {
			pst =con.prepareStatement(sql);
			
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getAddress());
			pst.setString(5, user.getGender());
			pst.setInt(6, user.getUserId());
			
			pst.execute();   // update , insert , delete for use execute....
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return "User updated successfully......";
	}
	
	
	
	//Delete by user id
	
	public String deleteByUserId(int id)
	{
		PreparedStatement pst = null;
		
		String sql = "delete from user where userid=?";
		
		try {
			
			pst = con.prepareStatement(sql);
			
			pst.setInt(1,id);
			
		    pst.execute(); // delete for use 
			
			int i = pst.executeUpdate(); //delete , insert , update....
			
			if(i > 0)
			{
				return "user deleted successfully";
			}
			else
			{
				return null;
			}
			
//			System.out.println(i);
//			
//			pst.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		//return "User Deleted successfully...........";
		
		return null;
		
	}
}
