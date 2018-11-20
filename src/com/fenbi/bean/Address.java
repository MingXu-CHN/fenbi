package com.fenbi.bean;

import java.util.Date;

/**
 * 封装地址Address的实体类
 * @author gaogao
 *
 */
public class Address {
	
	private int id;
	private int userId;
	private String receiver;
	private int provinceId;
	private int cityId;
	private int countyId;
	private String address;
	private String mobilePhone;
	private String telephone;
	private String isDefault;
	private Date createTime;
	
	// 省的名称
	private String provinceName;
	// 城市的名称
	private String cityName;
	// 区/县的名称
	private String countyName;
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
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public int getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getCountyId() {
		return countyId;
	}
	public void setCountyId(int countyId) {
		this.countyId = countyId;
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
	public String getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
	@Override
	public String toString() {
		return "Address [id=" + id + ", userId=" + userId + ", receiver=" + receiver + ", provinceId=" + provinceId
				+ ", cityId=" + cityId + ", countyId=" + countyId + ", address=" + address + ", mobilePhone="
				+ mobilePhone + ", telephone=" + telephone + ", isDefault=" + isDefault + ", createTime=" + createTime
				+ ", provinceName=" + provinceName + ", cityName=" + cityName + ", countyName=" + countyName + "]";
	}
	
}
