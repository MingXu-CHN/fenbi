package com.fenbi.service;

import com.fenbi.bean.User;

/**
 * 处理用户的业务逻辑的接口
 * @author gaogao
 *
 */
public interface UserService {
	
	/**
	 * 处理注册的业务逻辑
	 * @param user 封装注册用户信息的对象
	 * @return 返回是否注册成功
	 */
	boolean register(User user);
	
	/**
	 * 处理登陆的业务逻辑
	 * @param username
	 * @param password
	 * @return
	 */
	User login(String username, String password);
	
	/**
	 * 处理检查用户名是否可用的业务逻辑
	 * @param username
	 * @return
	 */
	boolean checkUserName(String username);
	

}
