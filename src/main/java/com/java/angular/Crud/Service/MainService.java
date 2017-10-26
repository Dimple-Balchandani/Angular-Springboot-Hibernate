package com.java.angular.Crud.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.angular.Crud.DB.User;
import com.java.angular.Crud.DB.UserRequest;


@Service
public interface MainService {
	
	public void createUser(UserRequest userReq);
	public List<User> getUser();
	public boolean deleteUser(long inputid);
	public void updateUser(long inputid, UserRequest userReq);
	public User getUserById(long inputid);
}
