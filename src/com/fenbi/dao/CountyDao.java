package com.fenbi.dao;

import java.util.List;

import com.fenbi.bean.County;

/**
 * 操作County表的Dao
 * @author gaogao
 *
 */
public interface CountyDao {
	
	/**
	 * 根据城市id获取该城市下的所有的区/县
	 * @param cityId
	 * @return
	 */
	List<County> getCountysByCityId(String cityId);

}
