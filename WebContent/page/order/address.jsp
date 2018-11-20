<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>粉笔网</title>
<%@ include file="/page/base/base.jsp" %>
<link rel='stylesheet' href="css/address.css" />
</head>
<body>

	<%@ include file="/page/base/header.jsp" %>

	<div id="truman-body" class="text-center">
		<div id="paramList" data-toindex="false" data-isLogin="true"></div>
		<div id="address-detail" class="text-center">
			<div class="course-address-navi text-left">
				<span onclick="">地址管理</span>
			</div>
			<div class="truman-body-address text-left">
				<!--  保存地址 -->
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
						<div id="saveaddress" class=" text-center">
							<a>保存</a>
						</div>
						<div id="saveeditaddress" class=" text-center">
							<a>保存修改</a>
						</div>
						<div id="canceleditaddress" class=" text-center">
							<a>取消修改</a>
						</div>
					</div>
				</div>
				<!--  地址列表 -->
				<p class="user-address-list-info">最多可存储10个地址</p>
				<div class="user-address-list">
					<table>
						<thead>
							<tr>
								<th class='th-choose-radio'></th>
								<th class='th-region'>所在地区</th>
								<th class='th-address'>详细地址</th>
								<th class='th-name'>收货人</th>
								<th class='th-phone'>联系电话</th>
								<th class='th-action'>操作</th>
								<th class='th-default'></th>
							</tr>
						</thead>
						<tbody>
						
							<c:forEach items="${addressList }" var="address">
								<tr class='user-addresses' data-addressid='${address.id }'>
									<td class='tb-choose-radio'>
										<span class="addressradio${address.id == param.addressId ? ' selected' : ''}"></span>
									</td>
									<td class='tb-region'>
										<span class='tb-province' data-provinceId="${address.provinceId }">${address.provinceName }</span>&nbsp;&nbsp;
										<span class='tb-city' data-cityId="${address.cityId }">${address.cityName }</span>&nbsp;&nbsp; 
										<span class='tb-county' data-countyId="${address.countyId }">${address.countyName }</span></td>
									<td class='tb-address'>${address.address }</td>
									<td class='tb-name'>${address.receiver }</td>
									<td class='tb-phone'>${address.telephone }</td>
									<td class='tb-action'><a class='update'>修改</a>｜<a class='delete'>删除</a></td>
									<td class='tb-default${address.isDefault=="Y" ? " isdefault" : " notdefault"}'>
										
										<c:if test="${address.isDefault=='Y' }">
											<button>默认地址</button>
										</c:if>
										
										<c:if test="${address.isDefault=='N' }">
											<button>设为默认</button>
										</c:if>
										
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!--  地址列表 -->
				<div id='confirmaddress' data-courseid="${param.courseId }" class='text-center' data-baseurl="/order/gwy/19462">
					<a>确认收货地址</a>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/page/base/footer.jsp" %>
	
	<script src="js/address.js"></script>

</body>
</html>
