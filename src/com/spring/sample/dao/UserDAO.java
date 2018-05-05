package com.spring.sample.dao;

import java.util.List;
import com.spring.sample.bean.User;

public interface UserDAO {
	public List<User> getUserList();
	public List<User> getUserById(int userId);
	public List<User> getUserByUserName(String username);
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
}
