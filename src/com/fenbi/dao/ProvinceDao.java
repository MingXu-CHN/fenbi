package com.fenbi.dao;

import java.util.List;

import com.fenbi.bean.Province;

/**
 * 操作province表的dao
 * @author gaogao
 *
 */
public interface ProvinceDao {
	
	/**
	 * 获取所有的省的记录信息
	 * @return
	 */
	List<Province> getProvinces();

}
