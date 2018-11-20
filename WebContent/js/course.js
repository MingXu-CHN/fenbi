$(function(){
	
	// 控制导航栏的高亮显示
	$(".header-course").addClass("active").children().addClass("active");
	
	$(".truman-body-course-info").click(function(){
		
		// 获取课程的id  courseId
		var courseId = $(this).attr("id");
		
		// 去重新访问CourseServlet，访问它里面的getCourseByCourseId的方法
		location.href = "CourseServlet?method=getCourseByCourseId&courseId=" + courseId;
	});
	
	// 给课程分类按钮添加点击事件
	$("div .btn-group,truman-filter-item").click(function(){
		
		// 重新去访问CourseServlet,访问它里面的getCourseListByCourseType()
		// 根据课程分类获取对应分类下的课程列表
		
		// 获取div的id属性
		var courseTypeId = $(this).attr("id");
		
		window.location = "CourseServlet?method=getCourseListByCourseType&courseTypeId=" + courseTypeId;
		
	});
	
});