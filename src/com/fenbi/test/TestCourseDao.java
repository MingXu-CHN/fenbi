package com.fenbi.test;

import java.util.List;

import org.junit.Test;

import com.fenbi.bean.Course;
import com.fenbi.dao.CourseDao;
import com.fenbi.dao.impl.CourseDaoImpl;

public class TestCourseDao {
	
	CourseDao dao = new CourseDaoImpl();
	
	@Test
	public void testGetCourseList() {
		
		List<Course> courseList = dao.getCourseList();
		
		for(Course c : courseList) {
			System.out.println(c);
		}
		
		
	}
	
	@Test
	public void testGetCourseListByUserId() {
		List<Course> list = dao.getCourseListByUserId(22);
		
		System.out.println(list.size());
		
		for(Course c : list) {
			System.out.println(c);
		}
		
	}
	
	@Test
	public void testGetCourseListByUserIdAndCourseType() {
		List<Course> list = dao.getCourseListByUserIdAndCourseType(22, "4");
		
		System.out.println(list.size());
		
		for(Course c : list) {
			System.out.println(c);
		}
		
	}

}
