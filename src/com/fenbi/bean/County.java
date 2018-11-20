package com.fenbi.bean;

/**
 * 封装区/县的信息的实体类
 * @author gaogao
 *
 */
public class County {
	
	private int countyId;
	private String name;
	private int cityId;
	public int getCountyId() {
		return countyId;
	}
	public void setCountyId(int countyId) {
		this.countyId = countyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	

}
