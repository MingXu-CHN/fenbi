package com.fenbi.dao.impl;

import java.util.List;

import com.fenbi.bean.Province;
import com.fenbi.dao.BaseDao;
import com.fenbi.dao.ProvinceDao;

public class ProvinceDaoImpl extends BaseDao<Province> implements ProvinceDao {

	@Override
	public List<Province> getProvinces() {
		String sql = "SELECT province_id provinceId, NAME FROM fb_province";
		return this.getBeanList(sql);
	}

}
