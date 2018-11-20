package com.fenbi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fenbi.bean.Course;
import com.fenbi.bean.CourseType;
import com.fenbi.bean.User;
import com.fenbi.service.CourseService;
import com.fenbi.service.impl.CourseServiceImpl;

public class MyCourseServlet extends BaseServlet {

	/**
	 * 处理获取我的课程列表的请求
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getMyCourseList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 从sessio域中获取loginUser
		User loginUser = (User) request.getSession().getAttribute("loginUser");

		// 获取用户的id
		int userId = loginUser.getId();

		CourseService courseService = new CourseServiceImpl();
		List<Course> courseList = courseService.getMyCourseList(userId);
		List<CourseType> courseTypeList = courseService.getCourseTypeList();
		
		// 将数据存储到request域中，转发去/page/mycourse/course_list.jsp
		request.setAttribute("courseList", courseList);
		request.setAttribute("courseTypeList", courseTypeList);
		
		request.getRequestDispatcher("/page/mycourse/course_list.jsp").forward(request, response);

	}
	
	
	/**
	 * 处理根据课程分类获取我的课程列表的请求
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getMyCourseListByCourseType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 从sessio域中获取loginUser
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		
		// 获取用户的id
		int userId = loginUser.getId();
		
		// 获取课程的分类id
		String courseTypeId = request.getParameter("courseTypeId");

		CourseService courseService = new CourseServiceImpl();
		List<Course> courseList = courseService.getMyCourseListByCourseType(userId, courseTypeId);
		List<CourseType> courseTypeList = courseService.getCourseTypeList();
		
		// 将数据存储到request域中，转发去/page/mycourse/course_list.jsp
		request.setAttribute("courseList", courseList);
		request.setAttribute("courseTypeList", courseTypeList);
		
		request.getRequestDispatcher("/page/mycourse/course_list.jsp").forward(request, response);

	}
	
	/**
	 * 处理根据课程id获取课程详情的请求。
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getCourseByCourseId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 从sessio域中获取loginUser
		User loginUser = (User) request.getSession().getAttribute("loginUser");

		// 获取课程的id
		String courseId = request.getParameter("courseId");
		
		// 创建CourseService对象
		CourseService courseService = new CourseServiceImpl();
		
		Course course = courseService.getCourseByCourseId(courseId);
		
		boolean isBuy = courseService.queryIsBuy(loginUser.getId(), courseId);
		request.setAttribute("isBuy", isBuy);
		
		request.setAttribute("course", course);
		
		request.getRequestDispatcher("/page/mycourse/course_detail.jsp").forward(request, response);
		
	}

}