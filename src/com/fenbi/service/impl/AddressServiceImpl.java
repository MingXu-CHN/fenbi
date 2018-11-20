package com.fenbi.service.impl;

import java.util.List;

import com.fenbi.bean.Address;
import com.fenbi.bean.City;
import com.fenbi.bean.County;
import com.fenbi.bean.Province;
import com.fenbi.dao.AddressDao;
import com.fenbi.dao.CityDao;
import com.fenbi.dao.CountyDao;
import com.fenbi.dao.ProvinceDao;
import com.fenbi.dao.impl.AddressDaoImpl;
import com.fenbi.dao.impl.CityDaoImpl;
import com.fenbi.dao.impl.CountyDaoImpl;
import com.fenbi.dao.impl.ProvinceDaoImpl;
import com.fenbi.service.AddressService;

public class AddressServiceImpl implements AddressService {
	
	AddressDao addressDao = new AddressDaoImpl();
	ProvinceDao provinceDao = new ProvinceDaoImpl();
	CityDao	cityDao = new CityDaoImpl();
	CountyDao countyDao = new CountyDaoImpl();

	@Override
	public Address getDefaultAddressByUserId(int userId) {
		return addressDao.getDefaultAddressByUserId(userId);
	}

	@Override
	public List<Province> getProvinces() {
		return provinceDao.getProvinces();
	}

	@Override
	public List<City> getCitysByProvinceId(String provinceId) {
		return cityDao.getCitysByProvinceId(provinceId);
	}

	@Override
	public List<County> getCountysByCityId(String cityId) {
		return countyDao.getCountysByCityId(cityId);
	}

	@Override
	public boolean saveAddress(Address address) {
		return addressDao.saveAddress(address) > 0;
	}

	@Override
	public List<Address> getAddressListByUserId(int userId) {
		return addressDao.getAddressListByUserId(userId);
	}

	@Override
	public Address getAddressByAddressId(String addressId) {
		return addressDao.getAddressByAddressId(addressId);
	}

	@Override
	public boolean updateAddress(Address address) {
		return addressDao.updateAddress(address) > 0;
	}

	@Override
	public boolean deleteAddress(String addressId) {
		int count = addressDao.deleteAddress(addressId);
		return count > 0;
	}
	
	@Override
	public boolean setDefaultAddress(int userId, String addressId) {
		
		//根据用户id将原先的默认地址设置为正常地址
		int count = addressDao.updataStateByUserId(userId);
		//根据地址id设置为默认地址
		int count1 = addressDao.updateStateByAddressId(addressId);
		return count > 0 && count1 > 0;
	}

}
