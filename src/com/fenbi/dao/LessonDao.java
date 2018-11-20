package com.fenbi.dao;

import java.util.List;

import com.fenbi.bean.Lesson;

/**
 * 操作课时表的Dao
 * @author gaogao
 *
 */
public interface LessonDao {

	/**
	 * 根据课程的id获取所有该课程的课时列表
	 * @param courseId
	 * @return
	 */
	List<Lesson> getLessonsByCourseId(int courseId);
	
}
