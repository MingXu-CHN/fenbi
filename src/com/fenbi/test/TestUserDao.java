package com.fenbi.test;

import com.fenbi.bean.User;
import com.fenbi.dao.impl.UserDaoImpl;

public class TestUserDao {
	
	public static void main(String[] args) {
		
		UserDaoImpl dao = new UserDaoImpl();
		
		int count = dao.saveUser(new User(0, "bbb", "aaa"));
		
		System.out.println(count);
		
	}

}
