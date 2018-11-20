package com.fenbi.dao;

import com.fenbi.bean.Order;

/**
 * 操作订单表Order表的Dao
 * @author gaogao
 *
 */
public interface OrderDao {

	/**
	 * 根据用户的id和课程的id查询对应的订单
	 * @param userId
	 * @param courseId
	 * @return
	 */
	Order getOrderByUserIdAndCourseId(int userId, String courseId);
	
	/**
	 * 保存订单
	 * @param order
	 * @return
	 */
	int saveOrder(Order order);
}
