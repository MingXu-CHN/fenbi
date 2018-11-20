<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>粉笔网</title>
<%@ include file="/page/base/base.jsp" %>
<link rel="stylesheet" href="css/course.css" />
</head>
<body>

	<%@ include file="/page/base/header.jsp" %>
	
	<div id="truman-body" class="text-center">
		<div id="truman-body-course" class=" text-center">
			<div class="truman-body-filters text-center">
				<div id="" class="truman-filters-detail text-left">
				
					<c:forEach items="${courseTypeList }" var="courseType">
					
						<div id="${courseType.id }" class="btn-group truman-filter-item">
							<button type="button" class="btn${courseType.id==param.courseTypeId ? ' choosing' : '' }">${courseType.name }</button>
						</div>
						
					</c:forEach>
					
				</div>
			</div>
			<div class="truman-course-detail ">
				<div id="courseInfos" class="text-left">
				
				
					<c:if test="${!empty courseList }">
					
						<c:forEach items="${courseList }" var="course">
	
							<div id="${course.id }" class="truman-body-course-info ">
								<p class="course-info-title ">${course.title }</p>
								<p class="course-info-class ">
									<span class="time-icon"></span>&nbsp;&nbsp;<fmt:formatDate value="${course.startTime }" pattern="yyyy.M.d"/>&nbsp;-&nbsp;<fmt:formatDate value="${course.endTime }" pattern="yyyy.M.d"/>&nbsp;&nbsp;(${course.lessonCount }课时)
								</p>
								<div class="course-info-teachers text-left ">
									<c:forEach items="${course.teachers }" var="teacher">
										<div class="course-info-teacher-item text-center ">
											<img src="${teacher.photoUrl }" width="70px" height="71px">
											<p class="text-center ">
												<span>${teacher.name }</span>
											</p>
										</div>
									</c:forEach>
								</div>
								<div class="course-info-split "></div>
								<div class="course-info-students ">
									<div class="course-info-student-number ">
										<p class="show-false student-str">${course.saleNum }人购买</p>
										<p class="show-false">
											<span></span>
										</p>
									</div>
									<div class="course-info-price show-commen ">
										¥&nbsp; <span><fmt:formatNumber value="${course.price }" pattern="#"></fmt:formatNumber></span>
									</div>
								</div>
							</div>
							
						</c:forEach>
					</c:if>
					
					<c:if test="${empty courseList }">
						<!-- 空图片 -->
						<div class="course-empty-image text-center"></div>
					</c:if>
					
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/page/base/footer.jsp" %>
	
	<script src="js/course.js"></script>

</body>
</html>
