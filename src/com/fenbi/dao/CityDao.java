package com.fenbi.dao;

import java.util.List;

import com.fenbi.bean.City;

public interface CityDao {
	
	/**
	 * 根据省的id获取该省的所有的城市
	 * @param provinceId
	 * @return
	 */
	List<City> getCitysByProvinceId(String provinceId);
	

}
