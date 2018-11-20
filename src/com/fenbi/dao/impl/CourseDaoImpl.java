package com.fenbi.dao.impl;

import java.util.List;

import com.fenbi.bean.Course;
import com.fenbi.dao.BaseDao;
import com.fenbi.dao.CourseDao;

public class CourseDaoImpl extends BaseDao<Course> implements CourseDao {

	@Override
	public List<Course> getCourseList() {
		String sql = "SELECT fc.id, type_id typeId, title, description, price, total, sale_num saleNum," + 
				"lesson_count lessonCount, start_time startTime, end_time endTime, fct.name courseTypeName " + 
				"FROM fb_course fc ,fb_course_type fct WHERE fc.type_id = fct.id AND STATUS=1";
		return this.getBeanList(sql);
	}

	@Override
	public List<Course> getCourseListByCourseType(String courseTypeId) {
		String sql = "SELECT fc.id, type_id typeId, title, description, price, total, sale_num saleNum," + 
				"lesson_count lessonCount, start_time startTime, end_time endTime, fct.name courseTypeName " + 
				"FROM fb_course fc ,fb_course_type fct WHERE fc.type_id = fct.id AND type_id = ? AND STATUS=1";
		return this.getBeanList(sql, courseTypeId);
	}

	@Override
	public Course getCourseByCourseId(String courseId) {
		String sql = "SELECT fc.id, type_id typeId, title, description, price, total, sale_num saleNum," + 
				"lesson_count lessonCount, start_time startTime, end_time endTime, fct.name courseTypeName " + 
				"FROM fb_course fc ,fb_course_type fct WHERE fc.type_id = fct.id AND STATUS=1 AND fc.id = ?";
		return this.getBean(sql, courseId);
	}

	@Override
	public List<Course> getCourseListByUserId(int userId) {
		
		String sql = "SELECT fc.id, type_id typeId, title, description, price, total, sale_num saleNum,lesson_count lessonCount," + 
				"start_time startTime, end_time endTime, fct.name courseTypeName FROM fb_course fc , fb_course_type fct " + 
				"WHERE fc.type_id = fct.id AND fc.id IN (SELECT course_id courseId FROM fb_order WHERE user_id = ?)";
		
		return this.getBeanList(sql, userId);
	}

	@Override
	public List<Course> getCourseListByUserIdAndCourseType(int userId, String courseTypeId) {
		
		String sql = "SELECT fc.id, type_id typeId, title, description, price, total, sale_num saleNum,lesson_count lessonCount," + 
				"start_time startTime, end_time endTime, fct.name courseTypeName FROM fb_course fc , fb_course_type fct " + 
				"WHERE fc.type_id = fct.id AND type_id= ? AND fc.id IN (SELECT course_id courseId FROM fb_order WHERE user_id = ?)";
		
		return this.getBeanList(sql, courseTypeId, userId);
	}

}
