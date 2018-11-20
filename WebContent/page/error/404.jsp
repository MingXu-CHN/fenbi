<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/page/base/base.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>粉笔网</title>
<link rel="stylesheet" href="css/error.css" />
</head>
<body>

	<%@ include file="/page/base/header.jsp" %>

	<div id="truman-body" class="text-center">
		<div id="paramList" data-islogin="false"></div>
		<div id="truman-body-error" class=" text-center">
			<div class="error-image-404"></div>
			<div class="error-button text-center">
				<div class="error-fresh">
					<span>刷新重试</span>
				</div>
				<div class="error-index">
					<span>回到首页</span>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/page/base/footer.jsp" %>
	
</body>
</html>
