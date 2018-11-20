$(function(){
	
	$(".header-download").addClass("active").children().addClass("active");
	
	$("#download-header a").click(function(){
		// 点亮对应的栏目
		$("#download-header a").removeClass("header-active");
		$(this).addClass("header-active");
		// 显示对应的区域
		var key = $(this).attr("href");
		key = key.substr(key.lastIndexOf("#"));
		console.log(key);
		$("#download-tabs-body .tab-pane").removeClass("active");
		$(key).addClass("active");
	});
});
