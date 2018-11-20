package com.fenbi.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fenbi.bean.Address;
import com.fenbi.bean.City;
import com.fenbi.bean.County;
import com.fenbi.bean.Province;
import com.fenbi.bean.User;
import com.fenbi.service.AddressService;
import com.fenbi.service.impl.AddressServiceImpl;
import com.fenbi.utils.WEBUtils;
import com.google.gson.Gson;

public class AddressServlet extends BaseServlet {


	/**
	 * 处理获取所有省的请求
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getProvinces(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 解决请求乱码
		response.setContentType("application/json;charset=utf-8");
		
		AddressService addressService = new AddressServiceImpl();
		List<Province> provinces = addressService.getProvinces();
		
		Gson gson = new Gson();
		
		HashMap<String,Object> map = new HashMap<>();
		map.put("code", 1);
		map.put("provinces", provinces);
		map.put("msg", "获取所有省成功!");
		
		String jsonStr = gson.toJson(map);
		
		response.getWriter().print(jsonStr);
	}
	
	/**
	 * 处理根据省的id获取所有的城市的请求
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getCitysByProvinceId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 解决请求乱码
		response.setContentType("application/json;charset=utf-8");
		
		// 获取省的id
		String provinceId = request.getParameter("provinceId");
		
		AddressService addressService = new AddressServiceImpl();
		List<City> citys = addressService.getCitysByProvinceId(provinceId);
		
		Gson gson = new Gson();
		
		HashMap<String,Object> map = new HashMap<>();
		map.put("code", 1);
		map.put("citys", citys);
		map.put("msg", "获取所有城市成功!");
		
		String jsonStr = gson.toJson(map);
		
		response.getWriter().print(jsonStr);
	}
	
	
	/**
	 * 处理根据城市的id获取所有的区/县的请求
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getCountysByCityId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 解决请求乱码
		response.setContentType("application/json;charset=utf-8");
		
		// 获取城市的id
		String cityId = request.getParameter("cityId");
		
		AddressService addressService = new AddressServiceImpl();
		List<County> countys = addressService.getCountysByCityId(cityId);
		
		Gson gson = new Gson();
		
		HashMap<String,Object> map = new HashMap<>();
		map.put("code", 1);
		map.put("countys", countys);
		map.put("msg", "获取所有区/县成功!");
		
		String jsonStr = gson.toJson(map);
		
		response.getWriter().print(jsonStr);
	}
	
	/**
	 * 处理保存用户默认地址的请求
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void saveAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 解决请求乱码
		response.setContentType("application/json;charset=utf-8");
		
		// 获取地址的信息，并封装成一个Address对象
		Address address = WEBUtils.param2Bean(request, new Address());
		
		// 获取用户的id,设置Address对象上，还要给Address设置是否是默认地址
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		address.setUserId(loginUser.getId());
//		address.setIsDefault("Y");
		
		// 调用Service层处理业务逻辑
		AddressService addressService = new AddressServiceImpl();
		boolean flag = addressService.saveAddress(address);
		
		HashMap<String, Object> map = new HashMap<>();
		
		if(flag) {
			// 保存默认地址成功了
			map.put("code", 1);
			map.put("msg", "保存成功");
		}else {
			// 没有保存成功
			map.put("code", 0);
			map.put("msg", "保存失败");
		}
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(map);
		response.getWriter().print(jsonStr);
		
	}
	
	/**
	 * 处理去地址管理的页面的请求
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void toAddressManage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 获取登陆的用户对象
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		
		// 调用Service层处理业务逻辑,获取该用户所有的地址
		AddressService addressService = new AddressServiceImpl();
		List<Address> addressList = addressService.getAddressListByUserId(loginUser.getId());
		
		request.setAttribute("addressList", addressList);
		
		request.getRequestDispatcher("/page/order/address.jsp").forward(request, response);
		
	}
	
	/**
	 * 处理修改地址的请求
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json;charset=utf-8");
		
		Address address = WEBUtils.param2Bean(request, new Address());
		
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		address.setUserId(loginUser.getId());
		
		AddressService addressService = new AddressServiceImpl();
		boolean flag = addressService.updateAddress(address);
		
		HashMap<String, Object> map = new HashMap<>();
		if(flag) {
			// 保存默认地址成功了
			map.put("code", 1);
			map.put("msg", "修改成功");
		}else {
			// 没有保存成功
			map.put("code", 0);
			map.put("msg", "修改失败");
		}
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(map);
		response.getWriter().print(jsonStr);
	}
	
	/**
	 * 处理删除地址的请求
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void delAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String addressId = request.getParameter("addressId");
		
		AddressService addressService = new AddressServiceImpl();
		boolean flag = addressService.deleteAddress(addressId);
		
		response.setContentType("text/json;charset=utf-8");
		
		HashMap<String, Object> map = new HashMap<>();
		
		if(flag) {
			// 保存默认地址成功了
			map.put("code", 1);
			map.put("msg", "删除成功");
		}else {
			// 没有保存成功
			map.put("code", 0);
			map.put("msg", "删除失败");
		}
		
		Gson g = new Gson();
		String jsonStr = g.toJson(map);
		response.getWriter().write(jsonStr);
	
	}
	
	/**
	 * 处理设置默认地址的请求
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void setDefaultAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json;charset=utf-8");
		
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		String addressId = request.getParameter("addressId");
		
		AddressService addressService = new AddressServiceImpl();
		boolean flag = addressService.setDefaultAddress(loginUser.getId() ,addressId);
		
		HashMap<String,Object> map = new HashMap<>();
		
		if(flag) {
			// 保存默认地址成功了
			map.put("code", 1);
			map.put("msg", "设置默认成功");
		}else {
			// 没有保存成功
			map.put("code", 0);
			map.put("msg", "设置默认失败");
		}
		
		Gson g = new Gson();
		String jsonStr = g.toJson(map);
		response.getWriter().write(jsonStr);
	
	}
	
}