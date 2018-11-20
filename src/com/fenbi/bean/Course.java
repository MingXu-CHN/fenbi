package com.fenbi.bean;

import java.util.Date;
import java.util.List;

/**
 * 课程的实体类
 * @author gaogao
 *
 */
public class Course {
	
	private int id;	// 课程id
	
	private int typeId;	// 课程类型的id
	
	private String title;	// 课程标题
	
	private String description;	// 课程描述
	
	private double price;	// 价格
	
	private int total;	// 总量
	
	private int saleNum;	// 销量
	
	private int lessonCount;	// 课时数
	
	private Date startTime;	// 开始时间
	
	private Date endTime;	// 结束时间
	
	private Date createTime; // 创建时间
	
	private String courseTypeName;	// 课程分类的名称
	
	private List<Teacher> teachers;	// 课程所有的老师的集合
	
	private List<Lesson> lessons;	// 课程所有的课时

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getSaleNum() {
		return saleNum;
	}

	public void setSaleNum(int saleNum) {
		this.saleNum = saleNum;
	}

	public int getLessonCount() {
		return lessonCount;
	}

	public void setLessonCount(int lessonCount) {
		this.lessonCount = lessonCount;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getCourseTypeName() {
		return courseTypeName;
	}

	public void setCourseTypeName(String courseTypeName) {
		this.courseTypeName = courseTypeName;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", typeId=" + typeId + ", title=" + title + ", description=" + description
				+ ", price=" + price + ", total=" + total + ", saleNum=" + saleNum + ", lessonCount=" + lessonCount
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", createTime=" + createTime
				+ ", courseTypeName=" + courseTypeName + ", teachers=" + teachers + ", lessons=" + lessons + "]";
	}

}
