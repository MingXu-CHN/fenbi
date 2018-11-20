<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="js/login.js">
</script>

<!-- header -->
<div id="truman-header" class="text-center">
	<div id="headercontent" class="text-center" data-isLogin="false">
		<!-- logo -->
		<div class="header-content-image text-center"></div>
		<!-- 标题 -->
		<div class="header-filter-content text-left">
			<a class="content-filters header-course text-center" href="CourseServlet?method=getCourseList"> 
				<span class="truman-header-index truman-header-link-button">直播课程</span>
			</a>
			<a class="content-filters header-mylectures text-center" href="MyCourseServlet?method=getMyCourseList"> 
				<span class="truman-header-index truman-header-link-button">我的课程</span>
			</a> 
			<a class="content-filters header-index text-center" href="page/about.jsp"> 
				<span class="truman-header-index truman-header-link-button">关于粉笔</span>
			</a> 
			<a class="content-filters header-download text-center" href="page/download.jsp"> 
				<span class="truman-header-index truman-header-link-button">软件下载</span>
			</a> 
			<a class="content-filters header-joinus text-center" href="page/joinus.jsp"> 
				<span class="truman-header-index truman-header-link-button ">加入我们</span>
			</a>
		</div>
		
		
		<c:if test="${empty loginUser }">
		
			<!-- 登陆注册框 -->
			<div class="header-content-logon text-right" style="display:inline-block;">
				<a id="userlogin" href="page/user/login.jsp" class="active"><span>登录</span></a>
				<a id="usersignup" href="page/user/register.jsp"><span>注册</span></a>
			</div>
		
		</c:if>
		
		<c:if test="${!empty loginUser }">
		
			<div class="content-logon-success text-right">
				<span class="show-logout"> <span class="user-icon"></span>
					<p class="user-name">${loginUser.username }</p> <span class="action-icon icon-open"></span>
				</span>
					
				<div id="userlogout" class="popover bottom" style="display: none;">
					<div id="logoutshow1" class=" popover-content">
						<p>
							<span style="display: inline;"><a href="UserServlet?method=logOut">退出登陆</a></span>
						</p>
					</div>
				</div>
			</div>
			
		</c:if>
		
	</div>
</div>
