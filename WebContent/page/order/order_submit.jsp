<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>粉笔网</title>
<%@ include file="/page/base/base.jsp" %>
<link rel='stylesheet' href="css/login.css" />
<link rel='stylesheet' href="css/order.css" />
<link rel='stylesheet' href="css/orderFade.css" />
</head>
<body>

	<%@ include file="/page/base/header.jsp" %>

	<div id="truman-body" class="text-center">
		<div id="orderDetail" class="text-center">
			<div class="course-order-navi text-left">
				<span onclick="">订单信息</span>
			</div>
			<div class="truman-body-order">
				<div class="course-order-info">
					<div class="course-order-info-left text-left">
						<p class="course-order-title">
							<span class="xianxia1 xianxiaimage"></span>${course.title }
						</p>
						<p class="course-order-class">
							<span class="time-icon"></span>&nbsp;&nbsp;<fmt:formatDate value="${course.startTime }" pattern="yyyy.M.d"/>&nbsp;-&nbsp;<fmt:formatDate value="${course.endTime }" pattern="yyyy.M.d"/>&nbsp;&nbsp;(${course.lessonCount }课时)
						</p>
					</div>
					<div class="course-order-info-right text-left">
						<span class="info-money-course">课程价格：</span>
						<div class=" info-money-price text-right">
							<span class="info-money-unit">¥&nbsp;&nbsp;</span> 
							<span class="info-money"><fmt:formatNumber value="${course.price }" pattern="#"></fmt:formatNumber></span>
						</div>
					</div>
				</div>
				
				<div class="split-line"></div>
				
				<div class="course-user-address true" id="course_address">
					<p class="course-user-address-info">
						<span>地址信息&nbsp;&nbsp;&nbsp;</span>书籍等实物将寄送到此地址
					</p>
					
					<c:if test="${empty address }">
						<div class="text-left user-address-no" id="div_address2">
							
							<div class="form-group user-name-input user-address-input">
								<span class="user-address-input-title">收件人<span style="color: red">*</span>：</span> 
								<input type="text" placeholder="请填写姓名" class="form-control" id="usernameaddress" name="receiver">
								<p class="address-name-tooltip address-illegal-tooltip">
									<span class="tooltip-icon"></span>&nbsp;&nbsp;&nbsp;
									<span>请填写收件人姓名</span>
								</p>
							</div>
							<div class="form-group phone-number-input user-address-detailinput">
								<span class="user-address-input-title">收货地址<span style="color: red">*</span>：</span>
								<div class="form-group region-filter">
									<select class="select" id="province_code" name="province_code">
										<option value="">请选择</option>
									</select> 
									<select class="select" id="city_code" name="city_code">
										<option value="">请选择</option>
									</select> 
									<select class="select" id="county_code" name="area_code">
										<option value="">请选择</option>
									</select>
									<textarea class="form-control" id="detailaddress" placeholder="具体到街道门牌号，否则邮寄的证书无法准确按时到达，最多可填写60字"></textarea>
								</div>
								
								<p class="address-detail-tooltip address-illegal-tooltip" style="visibility: invisible;">
									<span class="tooltip-icon"></span>&nbsp;&nbsp;&nbsp;
									<text>请选择省/直辖市</text>
								</p>
							</div>
							<div class="form-group user-address-input">
								<span class="user-address-input-title">联系电话<span style="color: red">*</span>：
								</span> <input type="text" class="form-control" id="phoneaddress" name="telephone">
								<p class="address-phone-tooltip address-illegal-tooltip">
									<span class="tooltip-icon"></span>&nbsp;&nbsp;&nbsp;
									<span>请填写正确的手机号码</span>
								</p>
							</div>
							<div class="form-group text-left">
								<div id="saveaddress" class="text-center">
									<a>保存</a>
								</div>
								<p id="prompt" style="display: none; color: red;">请补全地址信息</p>
							</div>
						</div>
					</c:if>
					
					<c:if test="${!empty address}">
						<div class="text-left user-address-hasdefault" id="div_address3" style="display: inline-block;">
							<span class="location-icon"></span> <span class="default-user-text text-left" id="current_address1">${address.provinceName }&nbsp;&nbsp;${address.cityName }&nbsp;&nbsp;${address.countyName }&nbsp;&nbsp;${address.address }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(${address.receiver }&nbsp;&nbsp;&nbsp;收)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${address.telephone }</span> 
							<a href="AddressServlet?method=toAddressManage&addressId=${address.id }&courseId=${course.id }">修改地址</a>
						</div>
					</c:if>
					
				</div>
				<div class="split-line"></div>
				<div class="course-order-pay">
					<p class="course-order-pay-title">支付方式</p>
					<div class="course-order-pay-way first-child active text-left">
						<div class="course-order-pay-left  text-left">
							<span class="payradio selected" data-payway="0"></span> 
							<span class="weixin-pay-ico"></span> 
							<span class="order-pay-text">微信</span>
						</div>
						<div class="course-order-pay-right  text-right">
							<span> 
								支付： <span class="info-money-unit">¥</span> <span class="info-money"><fmt:formatNumber value="${course.price }" pattern="#"></fmt:formatNumber></span>
							</span>
						</div>
					</div>
					<div class="split-line"></div>
					<div class="course-order-pay-way text-left">
						<div class="course-order-pay-left text-left">
							<span class="payradio" data-payway="1"></span> 
							<span class="zhifubao-pay-ico"></span> 
							<span class="order-pay-text">支付宝</span>
						</div>
						<div class="course-order-pay-right text-right">
							<span class=" text-left"> 
								支付： <span class="info-money-unit">¥</span> <span class="info-money"><fmt:formatNumber value="${course.price }" pattern="#"></fmt:formatNumber></span>
							</span>
						</div>
					</div>
				</div>
				<div class="split-line"></div>
				<div class="pay-content text-right">
					<button id="paybutton" style="display: inline-block;"
						class="pay-button" data-courseid="${course.id }" data-addressid="${address.id }" data-toggle="modal" data-target="">立即支付</button>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/page/base/footer.jsp" %>

	<script src="js/order.js"></script>	
</body>
</html>
