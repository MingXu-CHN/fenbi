package com.fenbi.dao.impl;

import java.util.List;

import com.fenbi.bean.County;
import com.fenbi.dao.BaseDao;
import com.fenbi.dao.CountyDao;

public class CountyDaoImpl extends BaseDao<County> implements CountyDao {

	@Override
	public List<County> getCountysByCityId(String cityId) {
		
		String sql = "SELECT county_id countyId, NAME, city_id cityId FROM fb_county WHERE city_id = ?"; 
		
		return this.getBeanList(sql, cityId);
	}

}
