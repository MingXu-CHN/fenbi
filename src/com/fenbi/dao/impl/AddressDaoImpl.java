package com.fenbi.dao.impl;

import java.util.List;

import com.fenbi.bean.Address;
import com.fenbi.dao.AddressDao;
import com.fenbi.dao.BaseDao;

public class AddressDaoImpl extends BaseDao<Address> implements AddressDao {

	@Override
	public Address getDefaultAddressByUserId(int userId) {
		
		String sql = "SELECT addr.id, addr.user_id userId, addr.receiver, addr.province_id provinceId, addr.city_id cityId," + 
				"addr.county_id countyId, addr.address, addr.mobile_phone mobilePhone, addr.telephone, addr.is_default isDefault," + 
				"addr.create_time createTime, pro.name provinceName, ci.name cityName, coun.name countyName " + 
				"FROM fb_address addr, fb_province pro, fb_city ci, fb_county coun " + 
				"WHERE addr.province_id = pro.province_id AND addr.city_id = ci.city_id AND addr.county_id = coun.county_id AND addr.is_default = 'Y' AND addr.user_id = ?";
		
		return this.getBean(sql, userId);
	}

	@Override
	public int saveAddress(Address address) {
		String sql = "INSERT INTO fb_address (user_id,receiver,province_id,city_id,county_id,address,mobile_phone,telephone,is_default,create_time) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,NOW())";
		return this.update(sql, address.getUserId(),address.getReceiver(),address.getProvinceId(),address.getCityId(),address.getCountyId(),address.getAddress(),address.getMobilePhone(),address.getTelephone(),address.getIsDefault());
	}

	@Override
	public List<Address> getAddressListByUserId(int userId) {
		String sql = "SELECT addr.id, addr.user_id userId, addr.receiver, addr.province_id provinceId," + 
				"addr.city_id cityId, addr.county_id countyId, addr.address,addr.mobile_phone mobilePhone," + 
				"addr.telephone, addr.is_default isDefault, addr.create_time createTime," + 
				"pro.name provinceName, city.name cityName, coun.name countyName " + 
				"FROM fb_address addr, fb_province pro, fb_city city, fb_county coun " + 
				"WHERE addr.province_id = pro.province_id AND addr.city_id = city.city_id " + 
				"AND addr.county_id = coun.county_id AND addr.user_id = ? order by addr.create_time desc";
		return this.getBeanList(sql, userId);
	}

	@Override
	public Address getAddressByAddressId(String addressId) {
		String sql = "SELECT addr.id, addr.user_id userId, addr.receiver, addr.province_id provinceId, addr.city_id cityId," + 
				"addr.county_id countyId, addr.address, addr.mobile_phone mobilePhone, addr.telephone, addr.is_default isDefault," + 
				"addr.create_time createTime, pro.name provinceName, ci.name cityName, coun.name countyName " + 
				"FROM fb_address addr, fb_province pro, fb_city ci, fb_county coun " + 
				"WHERE addr.province_id = pro.province_id AND addr.city_id = ci.city_id AND addr.county_id = coun.county_id AND addr.id = ?";
		return this.getBean(sql, addressId);
	}

	@Override
	public int updateAddress(Address address) {
		String sql = "update fb_address set receiver=?,province_id=?,city_id=?,county_id=?,address=?,mobile_phone=?,telephone=? where id=?";
		return this.update(sql,address.getReceiver(),address.getProvinceId(),address.getCityId(),address.getCountyId(),address.getAddress(),address.getMobilePhone(),address.getTelephone(),address.getId());
	}

	@Override
	public int deleteAddress(String addressId) {
		String sql = "delete from fb_address where id=?";
		return this.update(sql, addressId);
	}
	
	@Override
	public int updateStateByAddressId(String addressId) {
		String sql = "update fb_address set is_default='Y' where id=?";
		return this.update(sql, addressId);
	}

	@Override
	public int updataStateByUserId(int userId) {
		String sql = "update fb_address set is_default='N' where user_id=? and is_default='Y'";
		return this.update(sql, userId);
		
	}

}
