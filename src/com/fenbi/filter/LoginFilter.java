package com.fenbi.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fenbi.bean.User;

public class LoginFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// 判断用户是否登陆，如果登陆了，则去处理业务逻辑，如果没有登陆，跳转到登陆页面让用户登陆。
		// 从sessio域中获取loginUser
		User loginUser = (User) request.getSession().getAttribute("loginUser");

		if (loginUser == null) {
			// 没有登陆，跳转到登陆页面让用户登陆。
			request.setAttribute("msg", "该操作需要登陆！！！");
			request.getRequestDispatcher("/page/user/login.jsp").forward(request, response);
		} else {
			// 登陆了,则放行请求。
			chain.doFilter(request, response);
		}
		
	}
	
	
}
