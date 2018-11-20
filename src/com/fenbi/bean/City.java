package com.fenbi.bean;

/**
 * 封装城市信息的实体类
 * @author gaogao
 *
 */
public class City {
	
	private int cityId;
	private String name;
	private int provinceId;
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

}
