package com.fenbi.dao.impl;

import java.util.List;

import com.fenbi.bean.City;
import com.fenbi.dao.BaseDao;
import com.fenbi.dao.CityDao;

public class CityDaoImpl extends BaseDao<City> implements CityDao {

	@Override
	public List<City> getCitysByProvinceId(String provinceId) {
		
		String sql = "SELECT city_id cityId, NAME, province_id provinceId FROM fb_city WHERE province_id = ?";
		
		return this.getBeanList(sql, provinceId);
	}

}
