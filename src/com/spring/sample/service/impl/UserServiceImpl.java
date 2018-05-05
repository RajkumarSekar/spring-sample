package com.spring.sample.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.sample.bean.User;
import com.spring.sample.dao.UserDAO;
import com.spring.sample.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	@Override
	public List<User> getUserList() {
		return userDAO.getUserList();
	}

	@Override
	public List<User> getUserById(int userId) {
		return userDAO.getUserById(userId);
	}
	
	@Override
	public List<User> getUserByUserName(String username) {
		return userDAO.getUserByUserName(username);
	}

	@Override
	public boolean updateUser(User user) {
		return userDAO.updateUser(user);
	}

	@Override
	public boolean deleteUser(User user) {
		return userDAO.deleteUser(user);
	}

}
