package com.fenbi.dao;

import java.util.List;

import com.fenbi.bean.Teacher;

/**
 * 操作老师表的Dao
 * @author gaogao
 *
 */
public interface TeacherDao {
	
	/**
	 * 根据课程id查询该课程下所有的老师的列表
	 * @param courseId
	 * @return
	 */
	List<Teacher> getTeachersByCourseId(int courseId);
}
