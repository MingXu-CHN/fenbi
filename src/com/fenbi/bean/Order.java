package com.fenbi.bean;

import java.util.Date;

/**
 * 订单的实体类，封装订单的信息
 * @author gaogao
 *
 */
public class Order {
	
	private int id;	// 订单编号
	private int userId;	// 用户id
	private int courseId;	// 课程id
	private String courseTitle; // 课程标题
	private Date startTime;	// 开始时间
	private Date endTime;	// 结束时间
	private int lessonCount; // 课时数
	private double price;	// 购买时候的价格
	private String receiver;	//收货人
	private String provinceName;	// 省
	private String cityName;	// 市
	private String countyName;	// 区
	private String address;	// 详细的地址
	private String mobilePhone;	// 电话号码
	private String telephone;	// 手机号码
	private int payWay;	// 支付方式
	private Date createTime;	// 创建时间
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
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
	public int getLessonCount() {
		return lessonCount;
	}
	public void setLessonCount(int lessonCount) {
		this.lessonCount = lessonCount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCountyName() {
		return countyName;
	}
	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getPayWay() {
		return payWay;
	}
	public void setPayWay(int payWay) {
		this.payWay = payWay;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", courseId=" + courseId + ", courseTitle=" + courseTitle
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", lessonCount=" + lessonCount + ", price="
				+ price + ", receiver=" + receiver + ", provinceName=" + provinceName + ", cityName=" + cityName
				+ ", countyName=" + countyName + ", address=" + address + ", mobilePhone=" + mobilePhone
				+ ", telephone=" + telephone + ", payWay=" + payWay + ", createTime=" + createTime + "]";
	}
}
