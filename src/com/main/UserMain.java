package com.main;

import java.util.ArrayList;


import com.Eexception.UserNotFoundException;
import com.controller.UserController;
import com.exception.InvalidUserIdException;
import com.exception.UsernameLengthReachedException;
import com.model.User;

// create 5 file......

public class UserMain {
	
	//FRONTEND madhun yenar ahe sarv data yacha jagi ata main use kele ahe.... 
	// controller cho method call kru service mdhe
	
	public static void main(String[] args) {
		
		
	//	UserController controller = new UserController();

		//insert user
//		User user = new User();
//		user.setUserId(18);
//		user.setUsername("ronk");
//		user.setPassword("Indr23#");
//		user.setEmail("ronk@gmail.com");
//		user.setAddress("Nandurbar");
//		user.setGender("feMale");
//		
//		try {
//		String msg = controller.saveUser(user);
//		
//		System.out.println(msg);
//		}
//		catch(Exception e)
//		{
//			System.out.println(e.getMessage());
//		}
		
		
		
		
		//user get by id 
//		try {
//		User user = controller.getUserById(5);
//		
//		System.out.println(user.getUserId());
//		System.out.println(user.getUsername());
//		System.out.println(user.getPassword());
//		System.out.println(user.getEmail());
//		System.out.println(user.getAddress());
//		System.out.println(user.getGender());
//		}
//		catch(UserNotFoundException e)
//		{
//			System.out.println(e.getMessage());
//		}
		
		
		//getAllUSers
//		UserController controller = new UserController();
//		ArrayList<User> users = controller.getAllUsersFromDB();
//		for(User user:users)
//		{
//			System.out.println(user.getUserId());
//			System.out.println(user.getUsername());
//			System.out.println(user.getPassword());
//			System.out.println(user.getEmail());
//			System.out.println(user.getAddress());
//			System.out.println(user.getGender());
//			
//			System.out.println("=======================================");
//		}
		
		
		// update user 
//		UserController controller = new UserController();
//		User user = new User();
//		user.setUserId(7);
//		user.setUsername("Jagruti");
//		user.setPassword("Jgru@1");
//		user.setEmail("jagruti@gmail.com");
//		user.setAddress("Amhandabad");
//		user.setGender("Female");
//		String mag = controller.update(user);
//		System.out.println(mag);
		
		//delete user
		try {
		UserController controller = new UserController();
		controller.delete(11);
		}catch(Exception u)
		{
			System.out.println(u.getMessage());
		}
		
	}
}
