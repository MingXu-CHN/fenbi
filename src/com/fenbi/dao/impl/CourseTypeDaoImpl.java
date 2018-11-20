package com.fenbi.dao.impl;

import java.util.List;

import com.fenbi.bean.CourseType;
import com.fenbi.dao.BaseDao;
import com.fenbi.dao.CourseTypeDao;

public class CourseTypeDaoImpl extends BaseDao<CourseType> implements CourseTypeDao {

	@Override
	public List<CourseType> getCourseTypeList() {
		String sql = "SELECT * FROM fb_course_type";
		return this.getBeanList(sql);
	}

}
