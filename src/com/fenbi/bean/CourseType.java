package com.fenbi.bean;

/**
 * 课程分类的实体类
 * @author gaogao
 *
 */
public class CourseType {
	
	private int id;	// 课程分类的id
	
	private String name;	// 课程分类的名称（公考,IT,考研...）

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CourseType [id=" + id + ", name=" + name + "]";
	}

}
