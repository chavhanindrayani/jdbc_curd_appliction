package com.service;


import java.util.ArrayList;


import com.Eexception.UserNotFoundException;
import com.dao.UserDao;
import com.exception.InavalidEmailException;
import com.exception.InvalidPasswordException;
import com.exception.InavalidEmailException;
import com.exception.InvalidUserIdException;
import com.exception.UsernameLengthReachedException;
import com.model.User;

// create 3 file...
 // dao chi method call keli service madhe


public class UserService {
	
	UserDao dao = new UserDao(); //this is UserDao obj created in UserSrvice class
	
	String passwordregex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).+$";
	
	public String saveUser(User user) // this is User class take and create new user parameter in the method 
	{
		if(user.getUserId() < 0)
		{
			throw new InvalidUserIdException("User id not valid... "+user.getUserId());
		}
		
		if(user.getUsername().length() > 10   || user.getUsername().length() < 3)
		{
			throw new UsernameLengthReachedException("Username should be in Between 3 to 10 charachers");
		}
		
		if(!user.getEmail().contains("@") && user.getEmail().endsWith(".com"))
		{
			throw new InavalidEmailException("Email is not valid : "+user.getEmail());
		}
		if (!user.getPassword().matches(passwordregex)) {
		    throw new InvalidPasswordException("Password must contain at least one uppercase letter, " +
		            "one lowercase letter, one digit, and one special character."
		        );
		    }
		
		String msg = dao.saveUser(user);
		
		return msg;
	}
	
	// user get data by id
	public User getUserById(int  id)
	{
		User user = dao.getUserById(id);
		
		if(user == null)
		{
			throw new UserNotFoundException("User not found with id :"+id);
		}
		return user;
	}

	
	// getall user 
	public ArrayList<User> getAllUsersFromDB()  // method name apan ky pan deu shkto....
	{
		ArrayList<User> users = dao.getAllUsersFromDB();
		
		return users;
	}
	
	
	public String update(User user)
	{
		String mag = dao.updateUser(user);
		
		return mag; 
	}
	
	
	public String delete(int id)
	{
		//return dao.deleteByUserId(id);
		
		String mag = dao.deleteByUserId(id);
		
		if(mag == null)
		{
			throw new UserNotFoundException("User Not Found  with id - "+id);
		}
		return mag;
	}
	
}
