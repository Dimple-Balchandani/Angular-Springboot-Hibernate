package com.java.angular.Crud.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.angular.Crud.DB.User;
import com.java.angular.Crud.DB.UserDAO;
import com.java.angular.Crud.DB.UserRequest;
import com.java.angular.Crud.Service.MainService;


@Component
public class UserServices implements MainService{

	@Autowired
	private UserDAO obj;
	
	@Override
	public void createUser(UserRequest userReq) {
	obj.createUser(userReq);
		
	}

	@Override
	public List<User> getUser() {
		return obj.getUser();
		
	}

	@Override
	public User getUserById(long inputid) {
		return obj.findById(inputid);
		
	}
	
	@Override
	public boolean deleteUser(long inputid) {
		return obj.deleteUser(inputid);
		
	}

	@Override
	public void updateUser(long inputid, UserRequest userReq) {
		obj.updateUser(inputid, userReq);
		
	}

}
