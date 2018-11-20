package com.fenbi.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.fenbi.utils.C3P0Utils;

/**
 * 
 * BaseDao中封装的是对数据库的基本的操作
 *
 */
public class BaseDao<T> {
	
	private Class type;
	
	public BaseDao() {
		ParameterizedType pt = (ParameterizedType)this.getClass().getGenericSuperclass();
		Type[] types = pt.getActualTypeArguments();
		type = (Class)types[0];
	}
	
	/**
	 * 执行增删改操作
	 * @param sql
	 * @param params
	 * @return
	 */
	public int update(String sql, Object... params) {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDs());
		int count = 0;
		try {
			count =  runner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 执行查询操作，将一条记录封装成一个JavaBean对象
	 * @param sql
	 * @param params
	 * @return
	 */
	public T getBean(String sql, Object... params) {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDs());
		T t = null;
		try {
			t = runner.query(sql, new BeanHandler<T>(type), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}

	/**
	 * 执行查询操作，将一组记录封装成JavaBean对象集合
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<T> getBeanList(String sql, Object... params) {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDs());
		List<T> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<T>(type), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}