package com.fenbi.dao.impl;

import java.util.List;

import com.fenbi.bean.Lesson;
import com.fenbi.dao.BaseDao;
import com.fenbi.dao.LessonDao;

public class LessonDaoImpl extends BaseDao<Lesson> implements LessonDao {

	@Override
	public List<Lesson> getLessonsByCourseId(int courseId) {
		
		String sql = "SELECT le.id, course_id courseId, teacher_id teacherId, title, le.start_time startTime," + 
				"le.end_time endTime, le.create_time createTime, te.name teacherName FROM fb_lesson le, fb_teacher te WHERE le.teacher_id=te.id AND course_id = ?";
		
		return this.getBeanList(sql, courseId);
	}

}
