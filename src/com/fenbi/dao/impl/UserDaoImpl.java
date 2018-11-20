package com.fenbi.dao.impl;

import com.fenbi.bean.User;
import com.fenbi.dao.BaseDao;
import com.fenbi.dao.UserDao;

public class UserDaoImpl extends BaseDao<User> implements UserDao {

	@Override
	public int saveUser(User user) {
		String sql = "INSERT INTO fb_user (username,PASSWORD,create_time) VALUES (?,?,NOW())";
		int count = this.update(sql, user.getUsername(), user.getPassword());	
		return count;
	}

	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		String sql = "select * from fb_user where username=? and password=?";
		return this.getBean(sql,  username, password);
	}

	@Override
	public User getUserByUserName(String username) {
		String sql = "select * from fb_user where username = ?";
		return this.getBean(sql, username);
	}

}
