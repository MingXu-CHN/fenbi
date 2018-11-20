package com.fenbi.dao;

import java.util.List;

import com.fenbi.bean.Course;

/**
 * 操作Course表的Dao
 * @author gaogao
 *
 */
public interface CourseDao {
	
	/**
	 * 获取的课程列表
	 * @return
	 */
	List<Course> getCourseList();
	
	/**
	 * 根据课程分类的id获取该分类下的所有的课程列表
	 * @param courseTypeId
	 * @return
	 */
	List<Course> getCourseListByCourseType(String courseTypeId);
	
	/**
	 * 根据课程的id获取课程信息
	 * @param courseId
	 * @return
	 */
	Course getCourseByCourseId(String courseId);
	
	/**
	 * 根据用户id获取该用户的所有购买的课程列表
	 * @return
	 */
	List<Course> getCourseListByUserId(int userId);
	
	/**
	 * 根据用户id和课程分类获取课程列表
	 * @return
	 */
	List<Course> getCourseListByUserIdAndCourseType(int userId,String courseTypeId);
}
