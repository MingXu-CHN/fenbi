$(function() {
	//登录成功后选择退出按钮移入移除事件
	$("div.content-logon-success").hover(function() {
		$("div#userlogout.popover.bottom").css("display", "block");
	},
	function() {
		$("div#userlogout.popover.bottom").css("display", "none");
	});
	
});