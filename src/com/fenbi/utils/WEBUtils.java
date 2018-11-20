package com.fenbi.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WEBUtils {

	/**
	 * 将request请求参数的值赋值给JavaBean,并返回带有数据的JavaBean
	 * @param request
	 * @param t
	 * @return
	 */
	public static <T> T param2Bean(HttpServletRequest request, T t) {
		
		// 获取到所有请求参数的map集合
		Map<String, String[]> paramsMap = request.getParameterMap();
		
		try {
			BeanUtils.populate(t, paramsMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return t;
	}

}
