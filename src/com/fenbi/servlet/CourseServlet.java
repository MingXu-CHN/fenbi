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

/**
 * CourseServlet处理和课程相关的请求
 * @author gaogao
 *
 */
public class CourseServlet extends BaseServlet {

	/**
	 * 处理获取课程列表的请求
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getCourseList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 创建CourseService对象
		CourseService courseService = new CourseServiceImpl();
		
		// 调用方法去处理获取课程列表的业务逻辑 以及 获取课程分类的业务逻辑
		List<Course> courseList = courseService.getCourseList();
		List<CourseType> courseTypeList = courseService.getCourseTypeList();
		
		// 选择视图对数据进行渲染
		request.setAttribute("courseList", courseList);
		request.setAttribute("courseTypeList", courseTypeList);
		
		request.getRequestDispatcher("/page/course/course_list.jsp").forward(request, response);
		
	}
	
	/**
	 * 处理根据课程分类获取课程列表的请求
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getCourseListByCourseType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 获取课程分类的id
		String courseTypeId = request.getParameter("courseTypeId");
		
		// 创建CourseService对象
		CourseService courseService = new CourseServiceImpl();
		
		// 调用方法去处理获取课程列表的业务逻辑 以及 获取课程分类的业务逻辑
		List<Course> courseList = courseService.getCourseListByCourseType(courseTypeId);
		List<CourseType> courseTypeList = courseService.getCourseTypeList();
		
		// 选择视图对数据进行渲染
		request.setAttribute("courseList", courseList);
		request.setAttribute("courseTypeList", courseTypeList);
		
		request.getRequestDispatcher("/page/course/course_list.jsp").forward(request, response);
		
	}
	
	/**
	 * 处理根据课程id获取课程详情的请求。
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getCourseByCourseId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 获取课程的id
		String courseId = request.getParameter("courseId");
		
		// 创建CourseService对象
		CourseService courseService = new CourseServiceImpl();
		
		Course course = courseService.getCourseByCourseId(courseId);
		
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		
		if(loginUser == null) {
			// 没有登陆
			request.setAttribute("isBuy", false);
		}else {
			// 已经登陆了
			boolean isBuy = courseService.queryIsBuy(loginUser.getId(), courseId);
			request.setAttribute("isBuy", isBuy);
		}
		
		request.setAttribute("course", course);
		
		request.getRequestDispatcher("/page/course/course_detail.jsp").forward(request, response);
	}
	
}