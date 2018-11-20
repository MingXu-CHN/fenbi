package com.fenbi.bean;

import java.util.Date;

/**
 * 老师的实体类
 * @author gaogao
 *
 */
public class Teacher {
	
	private int id;	// 老师的id
	
	private String name; // 老师的姓名
	
	private String gender;	// 老师的性别
	
	private String email;	// 老师的电子邮箱
	
	private String username;	// 老师的账号
	
	private int status;	// 老师的状态
	
	private String photoUrl;	// 老师图片的URL
	
	private String description;	// 老师的描述
	
	private double score;	// 老师的得分
	
	private Date createTime;	// 创建的时间

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", gender=" + gender + ", email=" + email + ", username="
				+ username + ", status=" + status + ", photoUrl=" + photoUrl + ", description=" + description
				+ ", score=" + score + ", createTime=" + createTime + "]";
	}
	
}
