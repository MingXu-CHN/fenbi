$(function(){
	
	$(".header-mylectures").addClass("active").children().addClass("active");
	
	// 给课程分类按钮添加点击事件
	$("div .btn-group,truman-filter-item").click(function(){
		
		// 重新去访问MyCourseServlet,访问它里面的getMyCourseListByCourseType()
		// 根据课程分类获取对应分类下的课程列表
		
		// 获取div的id属性
		var courseTypeId = $(this).attr("id");
		
		window.location = "MyCourseServlet?method=getMyCourseListByCourseType&courseTypeId=" + courseTypeId;
	});
	
	$(".truman-body-course-info").click(function(){
		
		// 获取课程的id  courseId
		var courseId = $(this).attr("id");
		
		// 去重新访问CourseServlet，访问它里面的getCourseByCourseId的方法
		location.href = "MyCourseServlet?method=getCourseByCourseId&courseId=" + courseId;
	});
});