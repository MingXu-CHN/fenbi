package com.fenbi.bean;

import java.io.Serializable;

/**
 * 用户信息的实体类，封装的是用户的信息
 * @author gaogao
 *
 */
public class User implements Serializable{
	
	// 用户id
	private int id;
	
	// 用户名
	private String username;
	
	// 密码
	private String password;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
}
