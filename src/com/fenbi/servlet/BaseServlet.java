package com.fenbi.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 设置请求编码方式为UTF-8
//		request.setCharacterEncoding("UTF-8");
		
		String methodName = request.getParameter("method");
		
//		if("login".equals(methodName)) {
//			login(request, response);
//		}else if("register".equals(methodName)) {
//			register(request, response);
//		}
		
		// 利用反射动态的调用Servlet中对应的方法。
		try {
			Method method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			// 取消语法检测
			method.setAccessible(true);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}