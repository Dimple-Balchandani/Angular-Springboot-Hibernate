package com.java.angular.Crud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.angular.Crud.DB.User;
import com.java.angular.Crud.DB.UserRequest;
import com.java.angular.Crud.Service.MainService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(value= "main", description="mainDescription")
public class MainController {
	@Autowired
	private MainService obj;
		
	@ApiOperation(value="Api to create user")
	@RequestMapping(value="/User", method=RequestMethod.POST, consumes="application/json")
	public void createUser(@RequestBody UserRequest userReq){
		obj.createUser(userReq);
	}
	
	@ApiOperation(value="Api to get user details")
	@RequestMapping(value="/User", method=RequestMethod.GET, produces="application/json")
	public List<User> getUser(){
		return obj.getUser();
	}

	
	@ApiOperation(value="Api to get user details")
	@RequestMapping(value="/User/{id}", method=RequestMethod.GET, produces="application/json")
	public User getUserById(@PathVariable("id") long inputid){
		return obj.getUserById(inputid);
	}
	
	@ApiOperation(value="Api to delete user")
	@RequestMapping(value="/User/{id}", method=RequestMethod.DELETE)
	public boolean deleteUser(@PathVariable("id") long inputid){
		return obj.deleteUser(inputid);
	}
	
	@ApiOperation(value="Api to update user")
	@RequestMapping(value="/User/{id}", method=RequestMethod.PUT)
	public void updateUser(@PathVariable("id") long inputid, @RequestBody UserRequest userReq){
		obj.updateUser(inputid,userReq);
	}

}
