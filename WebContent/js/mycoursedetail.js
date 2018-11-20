$(function(){
	
	// 控制导航栏的高亮显示
	$(".header-mylectures").addClass("active").children().addClass("active");
	
	
	$(".course-detail-navi").children("span:eq(0)").click(function(){
		
		// 调整到列表页面，并且是指定分类的列表页面。
		// 重新访问MyCourseServlet,访问它里面的getMyCourseListByCourseType方法
		
		var courseTypeId = $(this).attr("id");
		
		window.location = "MyCourseServlet?method=getMyCourseListByCourseType&courseTypeId=" + courseTypeId;
		
	});
	
});