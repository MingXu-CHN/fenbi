package com.fenbi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fenbi.bean.User;
import com.fenbi.service.UserService;
import com.fenbi.service.impl.UserServiceImpl;
import com.fenbi.utils.WEBUtils;

/**
 * 用于处理和用户相关的请求的Servlet
 * @author gaogao
 *
 */
public class UserServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	
	// 用于处理登陆的请求
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		// 获取到所有请求参数的map集合
//		Map<String, String[]> paramsMap = request.getParameterMap();
//		User user = new User();
//		try {
//			BeanUtils.populate(user, paramsMap);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		User user = WEBUtils.param2Bean(request, new User());
		
		// 2.调用service层处理业务逻辑
		UserService service = new UserServiceImpl();
		
		User loginUser = service.login(user.getUsername(), user.getPassword());
		
		// 3.根据处理的结果跳转不同的页面
		if(loginUser != null) {
			
			// 将用户对象存储到session域中，标识登陆的状态
			request.getSession().setAttribute("loginUser", loginUser);
			
			// 登陆成功了，将用户名以Cookie的形式发送给浏览器，浏览器保存信息。
			Cookie cookie = new Cookie("username", loginUser.getUsername());
			
			// 设置有效时间  7天
			cookie.setMaxAge(60*60*24*7);
			
			// 设置Cookie的有效路径
			cookie.setPath(request.getContextPath() + "/page/user/login.jsp");
			
			response.addCookie(cookie);
			
			// 登陆成功，请求重定向到首页
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} else {
			
			// 登陆失败，请求转发去登陆页面
			request.setAttribute("msg", "用户名或者密码错误!");
			
			request.getRequestDispatcher("/page/user/login.jsp").forward(request, response);
		}
	}

	// 处理注册相关的请求
	public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 先创建后使用的方式
		User user = WEBUtils.param2Bean(request, new User());
		
		// 3.调用业务逻辑层处理业务逻辑
		UserService service = new UserServiceImpl();
		boolean flag = service.register(user);
		
		// 4.根据处理的结果给出不同的响应。
		if(flag) {
			// 注册成功了，请求重定向到登陆页面
			response.sendRedirect(request.getContextPath() + "/page/user/login.jsp");
		}else {
			// 注册失败了，请求转发去注册页面
			request.setAttribute("msg", "注册失败了！");
			
			request.getRequestDispatcher("/page/user/register.jsp").forward(request, response);
		}
	
	}
	
	/**
	 * 处理退出登陆的请求
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 让session立即失效
		request.getSession().invalidate();
		
		// 跳转到某个页面
		// 获取Referer头（请求从哪里来），跳转到哪里去
		String referer = request.getHeader("Referer");
		
		// 重定向到referer头的地址
		response.sendRedirect(referer);
		
	}
	
	/**
	 * 处理查询用户名是否可用的请求
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void checkUserName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 获取请求参数
		String username = request.getParameter("username");
		
		// 调用Service处理查询用户名是否可用的业务逻辑
		UserService service = new UserServiceImpl();
		boolean flag = service.checkUserName(username);
		
		// 给浏览器响应数据
		if(flag) {
			response.getWriter().print("1");
		}else {
			response.getWriter().print("0");
		}
		
	}

}