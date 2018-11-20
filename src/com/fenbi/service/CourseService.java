package com.fenbi.service;

import java.util.List;

import com.fenbi.bean.Course;
import com.fenbi.bean.CourseType;

/**
 * 处理跟课程相关的业务逻辑
 * @author gaogao
 *
 */
public interface CourseService {
	
	/**
	 * 处理获取所有的课程列表的业务逻辑
	 * @return
	 */
	List<CourseType> getCourseTypeList();
	
	/**
	 * 处理获取所有的课程的业务逻辑
	 * @return
	 */
	List<Course> getCourseList();
	
	/**
	 * 处理获取指定课程分类下的课程列表的业务逻辑
	 * @return
	 */
	List<Course> getCourseListByCourseType(String courseTypeId);
	
	/**
	 * 处理根据课程id获取该课程的信息的业务逻辑
	 * @param courseId
	 * @return
	 */
	Course getCourseByCourseId(String courseId);
	
	
	/**
	 * 处理获取我的所有课程列表的业务逻辑
	 * @param userId
	 * @return
	 */
	List<Course> getMyCourseList(int userId);
	
	/**
	 * 处理根据课程分类获取我的课程的列表的业务逻辑
	 * @param userId
	 * @return
	 */
	List<Course> getMyCourseListByCourseType(int userId, String courseTypeId);
	
	
	/**
	 * 处理 根据用户id和课程id查询该用户是否已经购买该课程  的业务逻辑
	 * @param userId
	 * @param courseId
	 * @return true表示已经购买，false表示没有购买
	 */
	boolean queryIsBuy(int userId, String courseId);

}
