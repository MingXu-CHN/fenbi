package com.fenbi.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fenbi.bean.Address;
import com.fenbi.bean.Course;
import com.fenbi.bean.Order;
import com.fenbi.bean.User;
import com.fenbi.service.AddressService;
import com.fenbi.service.CourseService;
import com.fenbi.service.OrderService;
import com.fenbi.service.impl.AddressServiceImpl;
import com.fenbi.service.impl.CourseServiceImpl;
import com.fenbi.service.impl.OrderServiceImpl;
import com.fenbi.utils.WEBUtils;

public class OrderServlet extends BaseServlet {


	/**
	 * 处理显示订单预览的请求
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void orderPreview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 获取用户的id
		User loginUser = (User)request.getSession().getAttribute("loginUser");
		
		// 获取addressId请求参数
		String addressId = request.getParameter("addressId");
		
		AddressService addressService = new AddressServiceImpl();
		
		if(addressId == null || "".equals(addressId)) {
			// 说明是从课程详情页面点击立即购买按钮过来的，那么就查询默认地址
			// 获取用户默认的地址
			Address address = addressService.getDefaultAddressByUserId(loginUser.getId());
			request.setAttribute("address", address);
		}else {
			// 说明是从地址管理页面过来的，所以需要查询该地址id的信息，然后展示
			Address address = addressService.getAddressByAddressId(addressId);
			request.setAttribute("address", address);
		}
		
		// 获取请求参数中的课程id，查询出该课程的信息
		String courseId = (String) request.getParameter("courseId");
		CourseService courseService = new CourseServiceImpl();
		Course course = courseService.getCourseByCourseId(courseId);
		
		// 将课程信息和默认地址信息存储到域中，带到页面展示
		request.setAttribute("course", course);
		
		request.getRequestDispatcher("/page/order/order_submit.jsp").forward(request, response);
		
	}
	
	/**
	 * 处理支付的请求
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void pay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Order order = WEBUtils.param2Bean(request, new Order());
		
		OrderService orderService = new OrderServiceImpl();
		CourseService courseService = new CourseServiceImpl();
		AddressService addressService = new AddressServiceImpl();
		
		int userId = ((User) request.getSession().getAttribute("loginUser")).getId();
		
		// 获取课程信息
		Course course = courseService.getCourseByCourseId(order.getCourseId()+"");
		order.setUserId(userId);
		order.setCourseTitle(course.getTitle());
		order.setStartTime(course.getStartTime());
		order.setEndTime(course.getEndTime());
		order.setLessonCount(course.getLessonCount());
		order.setPrice(course.getPrice());
		
		// 获取订单地址信息
		String addressId = request.getParameter("addressId");
		Address address = addressService.getAddressByAddressId(addressId);
		
		order.setProvinceName(address.getProvinceName());
		order.setCityName(address.getCityName());
		order.setCountyName(address.getCountyName());
		order.setAddress(address.getAddress());
		order.setReceiver(address.getReceiver());
		order.setTelephone(address.getTelephone());
		order.setCreateTime(new Date());
		
		// 调用业务层方法，添加订单信息
		boolean flag = orderService.pay(order);
		
		// 订单完成后重定向到直播课程页面
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}


}