package com.java.angular.Crud.DB;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public void createUser(UserRequest userReq){
		User obj = new User();
		obj.setName(userReq.getName());
		obj.setRole(userReq.getRole());
		getSession().save(obj);
		
	}

	public List<User> getUser() {
		List<User> list = new ArrayList<User>();
		return getSession().createQuery("from User").list();
	}
	
	public boolean deleteUser(long inputid) {
		User user = findById(inputid);
		if(user==null)
			return false;
		else
		{	getSession().delete(user);	
			return true;
		}
		
	}

	public User findById(long inputid) {
		Query queryString= getSession().createQuery("from User where id= :id");
		queryString.setParameter("id", inputid);
		return (User) queryString.uniqueResult();
	}

	public void updateUser(long inputid,UserRequest userReq) {
		User user = findById(inputid);
		user.setName(userReq.getName());
		user.setRole(userReq.getRole());
		getSession().update(user);
	}
}
