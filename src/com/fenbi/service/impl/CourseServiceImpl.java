package com.fenbi.service.impl;

import java.util.List;

import com.fenbi.bean.Course;
import com.fenbi.bean.CourseType;
import com.fenbi.bean.Lesson;
import com.fenbi.bean.Order;
import com.fenbi.bean.Teacher;
import com.fenbi.dao.CourseDao;
import com.fenbi.dao.CourseTypeDao;
import com.fenbi.dao.LessonDao;
import com.fenbi.dao.OrderDao;
import com.fenbi.dao.TeacherDao;
import com.fenbi.dao.impl.CourseDaoImpl;
import com.fenbi.dao.impl.CourseTypeDaoImpl;
import com.fenbi.dao.impl.LessonDaoImpl;
import com.fenbi.dao.impl.OrderDaoImpl;
import com.fenbi.dao.impl.TeacherDaoImpl;
import com.fenbi.service.CourseService;

public class CourseServiceImpl implements CourseService {
	
	// 创建需要使用到的Dao
	CourseTypeDao courseTypeDao = new CourseTypeDaoImpl();
	TeacherDao teacherDao = new TeacherDaoImpl();
	LessonDao lessonDao = new LessonDaoImpl();
	CourseDao courseDao = new CourseDaoImpl();
	OrderDao orderDao = new OrderDaoImpl();
	

	@Override
	public List<CourseType> getCourseTypeList() {
		return courseTypeDao.getCourseTypeList();
	}

	@Override
	public List<Course> getCourseList() {
		
		List<Course> courseList = courseDao.getCourseList();
		
		for(Course c : courseList) {
			
			// 获取课程的id
			int courseId = c.getId();
			
			// 根据课程的id获取该课程的所有的老师
			List<Teacher> teachers = teacherDao.getTeachersByCourseId(courseId);
			c.setTeachers(teachers);
			
			// 根据课程的id获取该课程的所有的课时
			List<Lesson> lessons = lessonDao.getLessonsByCourseId(courseId);
			c.setLessons(lessons);
		}
		
		return courseList;
	}

	@Override
	public List<Course> getCourseListByCourseType(String courseTypeId) {
		
		List<Course> courseList = courseDao.getCourseListByCourseType(courseTypeId);
		
		for(Course c : courseList) {
			
			// 获取课程的id
			int courseId = c.getId();
			
			// 根据课程的id获取该课程的所有的老师
			List<Teacher> teachers = teacherDao.getTeachersByCourseId(courseId);
			c.setTeachers(teachers);
			
			// 根据课程的id获取该课程的所有的课时
			List<Lesson> lessons = lessonDao.getLessonsByCourseId(courseId);
			c.setLessons(lessons);
		}
		
		return courseList;
	}

	@Override
	public Course getCourseByCourseId(String courseId) {
		
		Course course = courseDao.getCourseByCourseId(courseId);
		
		// 获取课程的id
		int cid = course.getId();
		
		List<Teacher> teachers = teacherDao.getTeachersByCourseId(cid);
		course.setTeachers(teachers);
		
		List<Lesson> lessons = lessonDao.getLessonsByCourseId(cid);
		course.setLessons(lessons);
		
		return course;
	}

	@Override
	public List<Course> getMyCourseList(int userId) {
		
		List<Course> courseList = courseDao.getCourseListByUserId(userId);
		
		for(Course c : courseList) {
			
			// 获取课程的id
			int courseId = c.getId();
			
			// 根据课程的id获取该课程的所有的老师
			List<Teacher> teachers = teacherDao.getTeachersByCourseId(courseId);
			c.setTeachers(teachers);
			
			// 根据课程的id获取该课程的所有的课时
			List<Lesson> lessons = lessonDao.getLessonsByCourseId(courseId);
			c.setLessons(lessons);
		}
		
		return courseList;
	}

	@Override
	public List<Course> getMyCourseListByCourseType(int userId, String courseTypeId) {

		List<Course> courseList = courseDao.getCourseListByUserIdAndCourseType(userId, courseTypeId);
		
		for(Course c : courseList) {
			
			// 获取课程的id
			int courseId = c.getId();
			
			// 根据课程的id获取该课程的所有的老师
			List<Teacher> teachers = teacherDao.getTeachersByCourseId(courseId);
			c.setTeachers(teachers);
			
			// 根据课程的id获取该课程的所有的课时
			List<Lesson> lessons = lessonDao.getLessonsByCourseId(courseId);
			c.setLessons(lessons);
		}
		
		return courseList;
	}

	@Override
	public boolean queryIsBuy(int userId, String courseId) {
		
		Order order = orderDao.getOrderByUserIdAndCourseId(userId, courseId);
		
		return order != null;
	}

}
