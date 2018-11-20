package com.fenbi.dao;

import java.util.List;

import com.fenbi.bean.Address;

public interface AddressDao {
	
	/**
	 * 根据用户id获取用户的默认收货地址
	 * @param userId
	 * @return
	 */
	Address getDefaultAddressByUserId(int userId);
	
	/**
	 * 插入一条地址信息
	 * @param address
	 * @return
	 */
	int saveAddress(Address address);
	
	/**
	 * 根据用户的id查询该用户所有的地址
	 * @param userId
	 * @return
	 */
	List<Address> getAddressListByUserId(int userId);
	
	
	/**
	 * 根据地址的id获取地址的信息
	 * @param addressId
	 * @return
	 */
	Address getAddressByAddressId(String addressId);
	

	/**
	 * 更新地址
	 * @param address
	 * @return
	 */
	int updateAddress(Address address);
	
	/**
	 * 删除地址
	 * @param addressId
	 * @return
	 */
	int deleteAddress(String addressId);
	
	/**
	 * 根据地址id更新地址为默认地址
	 * @param addressId
	 * @return
	 */
	int updateStateByAddressId(String addressId);
	
	/**
	 * 根据用户id更新用户默认地址为非默认地址
	 * @param userId
	 * @return
	 */
	int updataStateByUserId(int userId);
}
