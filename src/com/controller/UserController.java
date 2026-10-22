package com.controller;

import java.util.ArrayList;


import com.Eexception.UserNotFoundException;
import com.model.User;
import com.service.UserService;

// create 4 file

public class UserController {

	//service chi method call keli controller madhe
	
	UserService service = new UserService();
	
	public String saveUser(User user)
	{
		String msg = service.saveUser(user);
		
		return msg;
	}
	
	// user get data by id
	public User getUserById(int id)
	{
		User user = service.getUserById(id); 
		
		return user;
	}
	
	
	//get all user
	public ArrayList<User> getAllUsersFromDB()
	{
		ArrayList<User> users = service.getAllUsersFromDB();
		return users;
	}
	
	
	
	//update user...
	public String update(User user)
	{
		String mag = service.update(user);
		
		return mag;
	}
	
	
	public String delete(int id)
	{
		return service.delete(id);
	}
	
	
	
	
}
