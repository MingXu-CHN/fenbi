package com.fenbi.test;

import java.util.List;

import org.junit.Test;

import com.fenbi.bean.Teacher;
import com.fenbi.dao.TeacherDao;
import com.fenbi.dao.impl.TeacherDaoImpl;

public class TestTeacherDao {
	
	TeacherDao dao = new TeacherDaoImpl();
	
	@Test
	public void testGetTeachersByCourseId() {
		List<Teacher> tes = dao.getTeachersByCourseId(3);
		
		for(Teacher t : tes) {
			System.out.println(t);
		}
	}

}
