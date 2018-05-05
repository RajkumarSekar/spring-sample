package com.spring.sample.bean;

import javax.persistence.*;

@Entity
@Table(name = "sample_users", uniqueConstraints = {
		@UniqueConstraint(columnNames = "username") })
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 6120754769148568668L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId", unique = true, nullable = false)
	private Integer userId;
	
	@Column(name = "username", unique = true, nullable = false)
	private String username;
	
	@Column(name = "password", unique = true, nullable = false)
	private String password;
	
	public User() {
		super();
	}
	public User(Integer userId, String username, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + "]";
	}
	
}
