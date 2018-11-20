package com.fenbi.service.impl;

import com.fenbi.bean.User;
import com.fenbi.dao.UserDao;
import com.fenbi.dao.impl.UserDaoImpl;
import com.fenbi.service.UserService;
import com.fenbi.utils.MD5Utils;

public class UserServiceImpl implements UserService {
	
	// 创建UserDao对象
	UserDao dao = new UserDaoImpl();

	@Override
	public boolean register(User user) {
		// 对密码进行加密
		String password = user.getPassword();
		user.setPassword(MD5Utils.md5(password));
		return dao.saveUser(user) > 0;
	}

	@Override
	public User login(String username, String password) {
		User loginUser = dao.getUserByUsernameAndPassword(username, MD5Utils.md5(password));
		return loginUser;
	}

	@Override
	public boolean checkUserName(String username) {
		
		// 调用Dao获取用户为username的用户记录
		User user = dao.getUserByUserName(username);
		
		return user == null;
	}

}
