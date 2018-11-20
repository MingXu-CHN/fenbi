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
<link rel="stylesheet" href="css/coursedetail.css" />
</head>
<body>

	<%@ include file="/page/base/header.jsp" %>
	
		<div id="truman-body" class="text-center">
		<div id="course-detail" class=" text-center">
			<div class="course-detail-navi">
				<span id="${course.typeId }">${course.courseTypeName }</span> <span> > &nbsp;${course.title }</span>
			</div>
			<div id="paramList"></div>

			<div class="truman-body-course-detail">
				<div class="course-detail-info">

					<div class="course-detail-info-left">
						<p class="course-detail-title">
							<span class="xianxia1 xianxiaimage"></span> ${course.title }
						</p>
						<p class="course-detail-class">
							<span class="time-icon"></span>&nbsp;&nbsp;<fmt:formatDate value="${course.startTime }" pattern="yyyy.M.d"/>&nbsp;-&nbsp;<fmt:formatDate value="${course.endTime }" pattern="yyyy.M.d"/>&nbsp;&nbsp;${course.lessonCount }课时
						</p>
						<div class="course-detail-teachers text-left">
							
							<c:forEach items="${course.teachers }" var="teacher">
							
								<div class="course-detail-teacher-item text-center">
									<img src="${teacher.photoUrl }" width="70px" height="71px">
									<p class="text-center">
										<text>${teacher.name }</text>
									</p>
								</div>
								
							</c:forEach>
						</div>

					</div>
					<div class="course-detail-info-right text-right">
						<div class="course-detail-price show-commen">
							¥&nbsp;<span>${course.price }</span>
						</div>
						<div class="course-detail-price not-show-discount">
							<div class="course-info-price-discount">
								<div class="discount-price">
									<span class="price-discount-number">¥&nbsp;<span><text>${course.price }</text></span></span>
									<span class="course-info-price-grey ">${course.price }&nbsp;</span>
								</div>
								<p class="course-info-short-title "></p>
							</div>
						</div>

						<div class="course-detail-student-number">
							<p class=" student-str">${course.saleNum }人购买 </p>
						</div>
						<p>
							
							<c:if test="${isBuy }">
								<button id='tonoticepage' class="info-bug-button">已购买
								</button>
							</c:if>
							
							<c:if test="${!isBuy }">
								<button id='tonoticepage' class="info-bug-button" onclick="buy(3)"
									style="display: inline-block;">立即购买
								</button>
							</c:if>
							
						</p>
					</div>
				</div>
			</div>
			<div class="course-detail-introduction">
				<div class="course-detail-introduction-left">
					<!-- Nav tabs -->
					<ul class="nav nav-tabs">
						<li class="active"><a href="${requestScope['javax.servlet.forward.request_uri'] }?${requestScope['javax.servlet.forward.query_string'] }#courseIntroduction">课程介绍</a></li>
						<li><a href="${requestScope['javax.servlet.forward.request_uri'] }?${requestScope['javax.servlet.forward.query_string'] }#classSchedule">课程安排</a></li>
						<li><a href="${requestScope['javax.servlet.forward.request_uri'] }?${requestScope['javax.servlet.forward.query_string'] }#teacherIntroductionTitle">老师介绍</a></li>
					</ul>
					<!-- Tab panes -->
					<div class="tab-content">
						<div id="courseIntroduction">
							<div class="class-schedule-title">课程介绍</div>
							<div class="course-introduction-detail">
								<p>
									
									${course.description }
									
								</p>
							</div>
						</div>
						<div class="class-schedule-split-line"></div>
						<div id="classSchedule" class=" text-left">

							<div class="class-schedule-title">课程表</div>
							
							<c:forEach items="${course.lessons }" var="lesson">
							
								<div class="class-schedule-detail">
									<div class="class-schedule-detail-image">
									</div>
									<div class="class-schedule-detail-text">
										<p><fmt:formatDate value="${lesson.startTime }" pattern="yyyy.M.d HH:mm"/> - <fmt:formatDate value="${lesson.endTime }" type="time" pattern="HH:mm"/></p>
										<p>${lesson.teacherName } - ${lesson.title }</p>
									</div>
								</div>
								
							</c:forEach>
							
						</div>
						<div class="class-schedule-split-line"></div>
						<div id="teacherIntroductionTitle" class="class-schedule-title">老师介绍</div>
						<div id="teacherIntroduction" class="text-left">
							
							<c:forEach items="${course.teachers }" var="teacher">
								<div class="teacher-introduction-detail text-center">
									<div class="teacher-introduction-info text-left">
										<div class="teacher-introduction-info-image">
											<img src="${teacher.photoUrl }"></img>
										</div>
										<div class="teacher-introduction-info-text">
											<p class="text-center teacher-introduction-info-name">
												<text>${teacher.name }</text>
											</p>
											<p class="text-left teacher-introduction-info-score">
												<span class="showstar"> <span
													class="teacher-score-icon"></span> <span
													class="teacher-score-icon"></span> <span
													class="teacher-score-icon"></span> <span
													class="teacher-score-icon"></span> <span
													class="teacher-score-icon"></span>
												</span>
												<text class="showstar">${teacher.score }</text>
											</p>
										</div>
									</div>
									<div class="teacher-introduction-label text-left">
										<span><text>粉笔IT讲师</text></span> <!-- <span><text>十年IT开发经验</text></span>
										<span><text>多年培训经验</text></span> -->
									</div>
									<div class="teacher-introduction-text text-left">${teacher.description }</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
				<div class="course-detail-introduction-right text-left">
					<p class="course-introduction-right-title">在线听课只需三步</p>
					<div class="course-introduction-step text-left">
						<div class="course-introduction-step-image1"></div>
						<div class="course-introduction-step-text">
							<p class="introduction-step-title">在线选课</p>
							<p class="introduction-step-content">登录粉笔账号，进入课程页点击购买按钮（我们支持支付宝和微信支付）
							</p>
						</div>
					</div>
					<div class="course-introduction-step text-left">
						<div class="course-introduction-step-image2"></div>
						<div class="course-introduction-step-text">
							<p class="introduction-step-title">下载客户端</p>
							<p class="introduction-step-content">
								选课后请及时下载客户端，看直播，看回放等更多功能在客户端才能进行哦。<a href=#>立即下载</a>
							</p>
						</div>
					</div>
					<div class="course-introduction-step text-left">
						<div class="course-introduction-step-image3"></div>
						<div class="course-introduction-step-text">
							<p class="introduction-step-title">上课</p>
							<p class="introduction-step-content">直播入口通常会在开课前半小时开放，课后可以无限次数回放。</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/page/base/footer.jsp" %>
	
	<script src="js/mycoursedetail.js"></script>

</body>
</html>
