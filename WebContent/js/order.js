$(function(){
	
	// 1.当页面一加载，就通过Ajax向服务器发送请求，获取所有的省的信息
	$.get("AddressServlet",
		{"method":"getProvinces"},
		function(response){
			
			if(response.code == 1) {
				// 说明获取省成功
				var provinces =  response.provinces;
				
				/*for(var i = 0; i < provinces.length; i++) {
					var provinceId = provinces[i].provinceId;
					var name = provinces[i].name;
					$("#province_code").append("<option value='"+ provinceId +"'>"+name+"</option>");
				}*/
				
				$.each(provinces,function(i,province){
					var provinceId = province.provinceId;
					var name = province.name;
					$("#province_code").append("<option value='"+ provinceId +"'>"+name+"</option>");
				})
				
				
			}else{
				alert(response.msg);
			}
			
		},
		"json"
	);
	
	// 2.当我们选中了一个省以后，需要向服务器发送请求，根据省的id去获取该省的所有的城市。
	// 给省的下拉框添加一个改变的事件监听
	$("#province_code").change(function() {
		
		// 把之前的城市清空以及把之前的区县清空
		$("#city_code option:gt(0)").remove();
		$("#county_code option:gt(0)").remove();
		
		// 获取省的id
		var provinceId = this.value;
		
		// 根据省的id获取所有的城市
		$.get("AddressServlet",
				{"method":"getCitysByProvinceId","provinceId":provinceId},
				function(response){
					
					if(response.code == 1) {
						// 说明获取城市成功
						var citys =  response.citys;
						
						$.each(citys,function(i,city){
							var cityId = city.cityId;
							var name = city.name;
							$("#city_code").append("<option value='"+ cityId +"'>"+name+"</option>");
						})
						
					}else{
						alert(response.msg);
					}
					
				},
				"json"
			);
		
	});
	
	// 3.当我们选中了一个城市以后，需要向服务器发送请求，根据城市的id去获取该城市的所有的区/县。
	// 给城市的下拉框添加一个改变的事件监听
	$("#city_code").change(function() {
		
		// 把之前的区县清空
		$("#county_code option:gt(0)").remove();
		
		// 获取城市的id
		var cityId = this.value;
		
		// 根据省的id获取所有的城市
		$.get("AddressServlet",
				{"method":"getCountysByCityId","cityId":cityId},
				function(response){
					
					if(response.code == 1) {
						// 说明获取城市成功
						var countys =  response.countys;
						
						$.each(countys,function(i,county){
							var countyId = county.countyId;
							var name = county.name;
							$("#county_code").append("<option value='"+ countyId +"'>"+name+"</option>");
						})
						
					}else{
						alert(response.msg);
					}
					
				},
				"json"
			);
		
	});
	
})


// 支付选项的切换
$(".course-order-pay-left").click(function(t) {
    $(".course-order-pay-way").removeClass("active"),
    $(".course-order-pay-way .selected").removeClass("selected");
    var i = $(t.currentTarget);
    i.parent().addClass("active"),
    i.find(".payradio").addClass("selected")
});

// 
$("#saveaddress").click(function() {
	// 先判断地址各个信息的合法性，然后提示用户或者显示新界面
	var receiver =  $("#usernameaddress").val();
	var provinceId =  $("#province_code").val();
	var cityId =  $("#city_code").val();
	var countyId =  $("#county_code").val();
	var address =  $("#detailaddress").val();
	var telephone =  $("#phoneaddress").val();
	var reg = /^1[3456789]\d{9}$/g;
	 
	$(".address-name-tooltip").css("visibility", "hidden");
	$(".address-detail-tooltip").css("visibility", "hidden");
	$(".address-phone-tooltip").css("visibility", "hidden");
	 
	if(receiver == ""){
		$(".address-name-tooltip").css("visibility", "visible");
		return false;
	}else {
		$(".address-name-tooltip").css("visibility", "hidden");
	}
	 
	if(provinceId == ""){
		$(".address-detail-tooltip").css("visibility", "visible");
		$(".address-detail-tooltip>text").text("请选择省/直辖市");
		return false;
	}else {
		$(".address-detail-tooltip").css("visibility", "hidden");
	}
	 
	if(cityId == ""){
		$(".address-detail-tooltip").css("visibility", "visible");
		$(".address-detail-tooltip>text").text("请选择市");
		return false;
	}else {
		$(".address-detail-tooltip").css("visibility", "hidden");
	}
	 
	if(countyId == ""){
		$(".address-detail-tooltip").css("visibility", "visible");
		$(".address-detail-tooltip>text").text("请选县/区");
		return false;
	}else {
		$(".address-detail-tooltip").css("visibility", "hidden");
	}
	 
	if(address == ""){
		$(".address-detail-tooltip").css("visibility", "visible");
		$(".address-detail-tooltip>text").text("请填写详细地址");
		return false;
	}else {
		$(".address-detail-tooltip").css("visibility", "hidden");
	}
	 
	if(telephone == "" || !reg.test(telephone)){
		$(".address-phone-tooltip").css("visibility", "visible");
		$(".address-phone-tooltip>text").text("请填写正确的手机号码");
		return false;
	}else {
		$(".address-phone-tooltip").css("visibility", "hidden");
	}
	
	
	// 发送Ajax请求保存默认的地址
	$.post("AddressServlet",
			{"method":"saveAddress", "receiver":receiver, "provinceId":provinceId, "cityId":cityId, "countyId":countyId, "address":address, "telephone":telephone, "isDefault":"Y"},
			function(response){
				
				if(response.code == 1) {
					// 重新刷新页面
					location.reload();
				}else {
					alert(response.msg);
				}
				
			},
			"json"
	);
	
});

$("#paybutton").click(function() {
	
	var courseId = $(this).attr("data-courseid");
	var addressId = $(this).attr("data-addressid");
	var payWay = $(".payradio.selected").attr("data-payway");
	
	if(addressId=="" || addressId==null) {
		 return alert("请保存地址后，再进行支付！");
	 }else {
		 window.location = "OrderServlet?method=pay&addressId="+addressId+"&courseId="+courseId+"&payWay="+payWay;
	 }
	
});








