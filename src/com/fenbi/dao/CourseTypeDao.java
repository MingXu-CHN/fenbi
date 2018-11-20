package com.fenbi.dao;

import java.util.List;

import com.fenbi.bean.CourseType;

/**
 * 操作课程分类表的Dao
 * @author gaogao
 *
 */
public interface CourseTypeDao {
	
	/**
	 * 获取课程分类列表
	 * @return
	 */
	List<CourseType> getCourseTypeList();

}
