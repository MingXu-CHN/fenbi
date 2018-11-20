$(function(){
	
	// 控制导航栏的高亮显示
	$(".header-course").addClass("active").children().addClass("active");
	
	
	$(".course-detail-navi").children("span:eq(0)").click(function(){
		
		// 调整到列表页面，并且是指定分类的列表页面。
		// 重新访问CourseServlet,访问它里面的getCourseListByCourseType方法
		
		var courseTypeId = $(this).attr("id");
		
		window.location = "CourseServlet?method=getCourseListByCourseType&courseTypeId=" + courseTypeId;
		
	});
	
	// 给立即购买按钮添加点击事件
	$("#btn_buy").click(function(){
		
		// 获取到课程的id
		var courseId = $(this).attr("data-courseId");
		
		// 请求OrderServlet，访问orderPreview()方法
		window.location = "OrderServlet?method=orderPreview&courseId=" + courseId;
		
	});
	
});