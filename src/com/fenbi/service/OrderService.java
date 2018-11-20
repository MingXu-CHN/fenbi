package com.fenbi.service;

import com.fenbi.bean.Order;

public interface OrderService {
	
	/**
	 * 处理支付的业务逻辑
	 * @param order
	 * @return
	 */
	boolean pay(Order order);
	

}
