$(function(){
	
	$("#input_username").change(function(){
		
		// 获取到文本框中的内容
		var username = this.value;
		
		// 对手机号进行校验（用正则。。。）
		
		// 悄悄的给服务器发一个Ajax请求，验证用户名是否可用。
		$.get("UserServlet",
				{"username":username, "method":"checkUserName"},
				function(response){
					
					if(response == "1") {
						// 可用
						$("#div_info").html("用户名可用！");
						// 让提交按钮可用
						$("#btn_sub").attr("disabled",false);
					}else {
						// 不可用
						$("#div_info").html("该用户名已注册！");
						// 让提交按钮不可用
						$("#btn_sub").attr("disabled",true);
					}
					
				},
				"text"
		);
		
	});
	
})