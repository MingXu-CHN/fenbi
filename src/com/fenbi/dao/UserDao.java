package com.fenbi.dao;

import com.fenbi.bean.User;

/**
 * 操作fb_user表的Dao
 * @author gaogao
 *
 */
public interface UserDao {
	
	/**
	 * 保存一个用户的信息
	 * @param user 要保存的用户信息的对象
	 * @return 返回受影响的行数
	 */
	int saveUser(User user);
	
	/**
	 * 根据用户名和密码查询用户
	 * @param username 要插入到数据库中的用户名
	 * @param password 要插入到数据中的密码
	 * @return 返回查询到的用户信息封装的对象
	 */
	User getUserByUsernameAndPassword(String username, String password);
	
	/**
	 * 根据用户名获取这个用户名对应的记录，返回该记录的User对象
	 * @param username
	 * @return
	 */
	User getUserByUserName(String username);

}
