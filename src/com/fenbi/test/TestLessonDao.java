package com.fenbi.test;

import java.util.List;

import org.junit.Test;

import com.fenbi.bean.Lesson;
import com.fenbi.dao.LessonDao;
import com.fenbi.dao.impl.LessonDaoImpl;

public class TestLessonDao {
	
	LessonDao dao = new LessonDaoImpl();
	
	@Test
	public void tesGgetLessonsByCourseId() {
		
		List<Lesson> lessons = dao.getLessonsByCourseId(3);
		
		for(Lesson l : lessons) {
			System.out.println(l);
		}
	}

}
