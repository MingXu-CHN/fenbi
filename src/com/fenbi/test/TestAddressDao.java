package com.fenbi.test;

import org.junit.Test;

import com.fenbi.bean.Address;
import com.fenbi.dao.impl.AddressDaoImpl;

public class TestAddressDao {
	
	@Test
	public void test() {
		
		AddressDaoImpl dao = new AddressDaoImpl();
		
		Address address = dao.getDefaultAddressByUserId(22);
		
		System.out.println(address);
		
	}

}
