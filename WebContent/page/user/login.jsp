<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/page/base/base.jsp" %>
<link rel="stylesheet" href="css/login.css" />
<meta charset="UTF-8" />
<title>粉笔网</title>
</head>
<body>

	<%@ include file="/page/base/header.jsp" %>

	<!-- body -->
	<div id="truman-body" class="text-center">
		<div id="paramList" data-isLogin="false" data-signup="" data-retrieve="">
			<!-- registered -->
			<div class="modal-header text-center">
				<h4 class="modal-title" id="exampleModalLabel">登录粉笔帐号</h4>
			</div>
			<form action="UserServlet?method=login" method="post">
			
				<!-- <input type="hidden" name="method" value="login"> -->
			
				<c:if test="${!empty msg }">
					<div class="form-group error-msg">
						<span class="error-icon"></span> ${msg }
					</div>
				</c:if>
			
				<div class="form-group phone-number">
					<input type="text" name="username" value="${!empty param.username ? param.username : cookie.username.value}" class="form-control" placeholder="手机号"/>
				</div>

				<div class="form-group password-code-input">
					<input type="password" name="password" class="form-control" placeholder="密码"/>
				</div>
				<div class="form-group">
					<div class="login text-center">
						<input type="submit" value="立即登录">
					</div>
				</div>
				<div class="has-registered text-right">
					<a href="page/user/register.jsp">没有粉笔账号，去注册</a>
				</div>
			</form>
		</div>
	</div>

	<%@ include file="/page/base/footer.jsp" %>

</body>
</html>