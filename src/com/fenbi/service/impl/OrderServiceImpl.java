package com.fenbi.service.impl;

import com.fenbi.bean.Order;
import com.fenbi.dao.OrderDao;
import com.fenbi.dao.impl.OrderDaoImpl;
import com.fenbi.service.OrderService;

public class OrderServiceImpl implements OrderService {
	
	OrderDao orderDao = new OrderDaoImpl();

	@Override
	public boolean pay(Order order) {
		
		int count = orderDao.saveOrder(order);
		
		return count > 0;
	}

}
