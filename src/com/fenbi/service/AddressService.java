package com.fenbi.service;

import java.util.List;

import com.fenbi.bean.Address;
import com.fenbi.bean.City;
import com.fenbi.bean.County;
import com.fenbi.bean.Province;

/**
 * 处理跟地址相关的业务逻辑
 * @author gaogao
 *
 */
public interface AddressService {
	
	/**
	 * 处理获取某个用户默认地址的业务逻辑
	 * @param userId
	 * @return
	 */
	public Address getDefaultAddressByUserId(int userId);
	
	/**
	 * 处理获取所有省的业务逻辑
	 * @return
	 */
	List<Province> getProvinces();
	
	/**
	 * 处理根据省的id获取所有城市的业务逻辑
	 * @param provinceId
	 * @return
	 */
	List<City> getCitysByProvinceId(String provinceId);
	
	/**
	 * 处理根据城市id获取所有区/县的业务逻辑
	 * @param cityId
	 * @return
	 */
	List<County> getCountysByCityId(String cityId);
	
	
	/**
	 * 处理保存用户默认的地址的业务逻辑
	 * @param address
	 * @return
	 */
	boolean saveAddress(Address address);
	
	/**
	 * 处理根据用户的id获取该用户所有的地址的业务逻辑
	 * @param userId
	 * @return
	 */
	List<Address> getAddressListByUserId(int userId);
	
	/**
	 * 处理根据地址的id获取地址的信息的业务逻辑
	 * @param addressId
	 * @return
	 */
	public Address getAddressByAddressId(String addressId);
	
	
	/**
	 * 处理更新地址的业务逻辑
	 * @param address
	 * @return
	 */
	public boolean updateAddress(Address address);
	
	/**
	 * 处理删除地址的业务逻辑
	 * @param addressId
	 * @return
	 */
	public boolean deleteAddress(String addressId);
	
	/**
	 * 处理设置默认地址的业务逻辑
	 * @param userId
	 * @param addressId
	 * @return
	 */
	public boolean setDefaultAddress(int userId, String addressId);

}
