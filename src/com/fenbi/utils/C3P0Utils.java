package com.fenbi.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * C3P0工具类：获取数据库连接&释放资源
 * @author gaogao
 *
 */
public class C3P0Utils {
	
	
	// 创建一个数据源
	public static ComboPooledDataSource ds = new ComboPooledDataSource();
	
	// 获取数据源
	public static ComboPooledDataSource getDs() {
		return ds;
	}

	/**
	 * 获取数据库连接的方法
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException {
		
		return ds.getConnection();
	}
	
	
//	public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
//		
//		if(rs != null) {
//			try {
//				rs.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		if(stmt != null) {
//			try {
//				stmt.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		if(conn != null) {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//	}
	
	// 关闭链接的方法
	public static void closeConnection(Connection conn) {
		
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) throws SQLException {
		Connection conn = getConnection();
		System.out.println(conn);
	}

}
