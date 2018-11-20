package com.fenbi.dao.impl;

import java.util.List;

import com.fenbi.bean.Teacher;
import com.fenbi.dao.BaseDao;
import com.fenbi.dao.TeacherDao;

public class TeacherDaoImpl extends BaseDao<Teacher> implements TeacherDao {

	@Override
	public List<Teacher> getTeachersByCourseId(int courseId) {
		String sql = "SELECT id, NAME, gender, email, username, STATUS, photo_url photoUrl, description, score, create_time createTime " + 
				"FROM fb_teacher WHERE id IN(SELECT DISTINCT(teacher_id) FROM fb_lesson WHERE course_id = ?)";
		return this.getBeanList(sql, courseId);
	}

}
