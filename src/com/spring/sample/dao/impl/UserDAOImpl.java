package com.spring.sample.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.sample.bean.User;
import com.spring.sample.dao.UserDAO;

@Transactional
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	  
	public void setSessionFactory(SessionFactory sessionFactory) {
	      this.sessionFactory = sessionFactory;
	}
	 
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserList() {
		
		Session session = this.sessionFactory.getCurrentSession();
		List<User> list = new ArrayList<>(); 
		try {
		  //session.getTransaction().begin();
		  list = session.createQuery("from User").list();
		  //session.getTransaction().commit();
		} catch (Exception e) {
		  //session.getTransaction().rollback();
		}
		return list;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserById(int userId) {
		
		Session session = this.sessionFactory.getCurrentSession();
		List<User> list = new ArrayList<>(); 
		try {
		  //session.getTransaction().begin();
		  Query query = session.createQuery("from User where userId=?");
		  query = query.setParameter(0,userId);  
		  list = query.list();
		  //session.getTransaction().commit();
		} catch (Exception e) {
		  //session.getTransaction().rollback();
		}

		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserByUserName(String username) {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> list = new ArrayList<>(); 
		try {
		  //session.getTransaction().begin();
		  Query query = session.createQuery("from User where username=?");
		  query = query.setParameter(0,username);  
		  list = query.list();
		  //session.getTransaction().commit();
		} catch (Exception e) {
		  //session.getTransaction().rollback();
		}

		return list;
	}

	@Override
	public boolean updateUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		boolean result= false;
		try {
		  session.getTransaction().begin();
		  session.update(user);
		  session.getTransaction().commit();
		  result = true;
		} catch (Exception e) {
		  session.getTransaction().rollback();
		}
		
		return result;
	}

	@Override
	public boolean deleteUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		boolean result= false;
		try {
		  session.getTransaction().begin();
		  session.delete(user);
		  session.getTransaction().commit();
		  result = true;
		} catch (Exception e) {
		  session.getTransaction().rollback();
		}
		
		return result;
	}

}
