$(function(){
	
	// 清空表单中的数据
	resetAddressInput();
	
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


// 保存地址按钮点击事件
$("#saveaddress").click(function() {
	
	/*alert($('#province_code option:selected').text());*/
	
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
	
	
	// 将地址保存
	// 发送Ajax请求保存的地址
	$.post("AddressServlet",
			{"method":"saveAddress", "receiver":receiver, "provinceId":provinceId, "cityId":cityId, "countyId":countyId, "address":address, "telephone":telephone, "isDefault":"N"},
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


// 给“确认收货地址按钮”添加点击事件
$("#confirmaddress").click(function(){
	
	// 获取当前被点击的地址的id
	var addressId = $(".addressradio.selected").parent().parent().attr("data-addressid");
	// http://localhost:8080/fenbi/OrderServlet?method=orderPreview&courseId=3
	
	var courseId = $("#confirmaddress").attr("data-courseid");
	
	window.location = "OrderServlet?method=orderPreview&courseId=" + courseId + "&addressId=" + addressId;
	
});


$("tbody").on("click", ".tb-choose-radio,.tb-region,.tb-address,.tb-name,.tb-phone",
	function(t) {
		 $(".addressradio").removeClass("selected"),
		 $(t.currentTarget).parent().find(".addressradio").addClass("selected")
});

$("tbody").on("click", ".notdefault",
	function(t) {
	
		var addressId = $(t.currentTarget).parent().attr("data-addressid");
	    
	    $.post("AddressServlet",
	    		{"addressId": addressId,"method":"setDefaultAddress"},
	    		function(data){
	    			var code = data.code;
	    			var msg = data.msg;
	    			if(code == 1){
	    				alert(msg);
	    				// 将原先是默认的设置成不是默认，然后设置按钮文字为"设为默认"
	    			    $(".isdefault").removeClass("isdefault").addClass("notdefault");
	    			    $(".isdefault").find("button").text("设置默认");
	    			    
	    			    // 当前被点击的设置成默认
	    			    $(t.currentTarget).removeClass("notdefault").addClass("isdefault");
	    			    $(t.currentTarget).find("button").text("默认地址");
	    			}else {
	    				alert(msg);
	    			}
	    		},
	 		"json");
	}
);


$("tbody").on("click", ".update",
function(t) {
	
	// 清除提示
    $(".address-illegal-tooltip").css("visibility", "hidden");
    
    // 获取当前被点击的a标签的父节点的父节点，就是tr节点
    var trEle = $(t.currentTarget).parent().parent();
    // 获取data-addressid,就是地址id
    var addressId = trEle.attr("data-addressid");
    
    // 给保存按钮添加一个属性，值为addressId
    $("#saveeditaddress").attr("data-addressid", addressId);
    
    // 获取收件人的姓名,省,市,区
    var receiver = trEle.find(".tb-name").text();
    var provinceName = trEle.find(".tb-province").text();
    var cityName = trEle.find(".tb-city").text();
    var countyName = trEle.find(".tb-county").text();
    var address = trEle.find(".tb-address").text();
    var telephone = trEle.find(".tb-phone").text();
    
    var provinceId = trEle.find(".tb-province").attr("data-provinceId");
    var cityId = trEle.find(".tb-city").attr("data-cityId");
    var countyId = trEle.find(".tb-county").attr("data-countyId");
    
    $("#province_code>option[value='" + provinceId + "']").attr("selected","selected");
    
    getCitySelected(provinceId,cityId);
    getCountySelected(cityId,countyId);
    
    // 给编辑框赋值
    $("#usernameaddress").val(receiver);
    $("#phoneaddress").val(telephone);
    $("#detailaddress").val(address);
    
    $("#saveaddress").css("display", "none");
    $("#saveeditaddress").css("display", "inline-block");
    $("#canceleditaddress").css("display", "inline-block");
    scroll(0, 0);
});

//根据省份id获取城市,并将指定的id的城市选中
function getCitySelected(provinceId,cityId) {
	
	$("#city_code option:gt(0)").remove();
	$("#county_code option:gt(0)").remove();
	
	$.getJSON(
			"AddressServlet",
			{"provinceId":provinceId,"method":"getCitysByProvinceId"},
			function(response){
				
				if(response.code == 1) {
					
					$(response.citys).each(function(){
						// 获取城市的id和name
						var id = this.cityId;
						var name = this.name;
						$("#city_code").append("<option value='"+id+"'>"+name+"</option>");
					});
					
					$("#city_code>option[value='" + cityId + "']").attr("selected","selected");
				}else {
					alert(response.msg);
				}
				
			}
		);
};

//根据城市id获取区县,并将指定的区县id的选中
function getCountySelected(cityId,countyId) {
	// 当城市发生改变以后，需要将原先的所有的县清除掉
	$("#county_code option:gt(0)").remove();
	
	// 发送请求获取区县的信息
	$.getJSON("AddressServlet",{
			"cityId":cityId,"method":"getCountysByCityId"},
			function(response){
				
				if(response.code == 1) {
					$(response.countys).each(function(){
						$("#county_code").append("<option value='"+this.countyId+"'>"+this.name+"</option>");
					});
					
					$("#county_code>option[value='" + countyId + "']").attr("selected","selected");

				}else {
					alert(response.msg);
				}
				
			}
		);
}

$("#saveeditaddress").click(function(t) {
	
	// 获取需要修改的地址id
    var addressId = $("#saveeditaddress").attr("data-addressid");
    
	// 先判断地址各个信息的合法性，然后提示用户或者显示新界面
	var receiver =  $("#usernameaddress").val();
	var provinceId =  $("#province_code").val();
	var cityId =  $("#city_code").val();
	var countyId =  $("#county_code").val();
	var address =  $("#detailaddress").val();
	var telephone =  $("#phoneaddress").val();
	var reg = /^1[3456789]\d{9}$/g;
	 
	// 让提示的进行隐藏
	$(".address-illegal-tooltip").css("visibility", "hidden");
	 
	if(receiver == ""){
		$(".address-name-tooltip").css("visibility", "visible");
		return;
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
	
	// 发送ajax请求，修改用户的地址
	$.post(
			"AddressServlet",
			{"method":"updateAddress", "receiver": receiver,"provinceId":provinceId, "cityId":cityId, "countyId":countyId,"address":address,"telephone":telephone,"id":addressId},
			function(response){
				var code = response.code;
				var msg = response.msg;
				if(code == 1){
					// 修改成功了，重写加载页面
					location.reload();
				}else {
					alert(msg);
				}
			},
		 	"json");
	 
});


// 删除地址添加点击事件
$("tbody").on("click", ".delete",
	function(t) {
	    var trEle = $(t.currentTarget).parent().parent();
	    var addressId = trEle.attr("data-addressid");
	    
	    i = trEle.find(".addressradio").hasClass("selected"),
	    a = trEle.find(".tb-default").hasClass("isdefault");
	    
	    // 发送ajax请求，删除用户的地址
		$.getJSON(
				"AddressServlet",
				{"method":"delAddress","addressId":addressId},
				function(response){
					var code = response.code;
					var msg = response.msg;
					if(code == 1){
						// 删除成功了，重写加载页面
						location.reload();
					}else {
						alert(msg);
					}
				}
			);
	    
});

// 取消修改点击事件
$("#canceleditaddress").click(function() {
    resetAddressInput();
    $("#saveaddress").css("display", "inline-block");
    $("#saveeditaddress").css("display", "none");
    $("#canceleditaddress").css("display", "none");
    
    // 将下拉框内容全部还原
    $("#province_code option").removeAttr("selected");
    $("#province_code option:eq(0)").attr("selected","selected");
    $("#city_code option:gt(0)").remove();
	$("#county_code option:gt(0)").remove();
	
});

// 清空添加地址表单中的数据
function resetAddressInput(){
	
	// 让提示的进行隐藏
	$(".address-illegal-tooltip").css("visibility", "hidden");
	
	$("#usernameaddress").val("");
	$("#detailaddress").val("");
	$("#phoneaddress").val("");
}

