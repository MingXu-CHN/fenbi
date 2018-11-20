package com.fenbi.bean;

import java.util.Date;

/**
 * 课时类
 * @author gaogao
 *
 */
public class Lesson {

	private int id;	// 课时id
	
	private int courseId;	// 课程id
	
	private int teacherId;	// 老师的id
	
	private String title;	// 课时的标题
	
	private Date startTime;	// 开始的时间
	
	private Date endTime;	// 结束的时间
	
	private Date createTime;	// 创建的时间
	
	private String teacherName; // 老师的名称

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	@Override
	public String toString() {
		return "Lesson [id=" + id + ", courseId=" + courseId + ", teacherId=" + teacherId + ", title=" + title
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", createTime=" + createTime + ", teacherName="
				+ teacherName + "]";
	}
	
}
