<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>粉笔网</title>
<%@ include file="/page/base/base.jsp" %>
<link rel="stylesheet" href="css/download.css" />
</head>
<body>

	<%@ include file="/page/base/header.jsp" %>

	<div id="truman-body" class="text-center">
		<div id="paramList"></div>
		<div id="download-tabs-header" class="text-center">
			<!-- Nav tabs -->
			<div id="download-header">
				<div class="truman-body-download-header">
					<a href="#fenbijiaoyu" class="header-active" aria-controls="fenbijiaoyu" role="tab" data-toggle="tab">
						<span class="fenbi-filter-image"></span>
						<p>粉笔</p>
					</a>
				</div>
				<div class="truman-body-download-header">
					<a href="#fenbishenlun" aria-controls="fenbishenlun" role="tab" data-toggle="tab">
						<span class="fenbishenlun-filter-image"></span>
						<p>粉笔申论</p>
					</a>
				</div>
				<div class="truman-body-download-header">
					<a href="#fenbikaoyan" aria-controls="fenbikaoyan" role="tab" data-toggle="tab">
						<span class="fenbikaoyan-filter-image"></span>
						<p>粉笔考研</p>
					</a>
				</div>
				<div class="truman-body-download-header">
					<a href="#fenbizhiboke" aria-controls="fenbizhiboke" role="tab" data-toggle="tab">
						<span class="pc-filter-image text-center"></span>
						<p>PC粉笔直播课</p>
					</a>
				</div>
			</div>
		</div>
		<div id="download-tabs-body" class="text-center">
			<!-- Tab panes -->
			<div class="tab-content truman-body-download-body">
				<!-- 粉笔教育 -->
				<div role="tabpanel" class="tab-pane active" id="fenbijiaoyu">
					<div class="fenbijiaoyu-image text-center">
						<div class="fenbijiaoyu-image-detail"></div>
					</div>
					<div class="fenbikaoyan-content">
						<div class="fenbikaoyan-text text-center">
							<p>粉笔科技为用户提供面向公务员，事业单位，教师招教和教师资格证及司法考试的题库，课程的一站式服务，请扫描二维码进行下载。</p>
						</div>
						<div class="fenbikaoyan-download text-left">
							<div id="fenbijiaoyucode">
								<img src="images/download/code.png"/>
							</div>
							<div class="fenbikaoyan-download-text">
								<p>
									用手机扫描二维码，或进入
									<a target="_blank" href="https://itunes.apple.com/cn/app/fen-bi-wang/id584660358">
										App Store 下载>
									</a>
								</p>
								<p>版本： 6.3.5&nbsp;&nbsp;&nbsp;更新时间： 2017年9月10日</p>
							</div>
						</div>
					</div>
				</div>
				<!-- 粉笔申论 -->
				<div role="tabpanel" class="tab-pane" id="fenbishenlun">
					<div class="fenbishenlun-image text-center">
						<div class="fenbishenlun-image-detail"></div>
					</div>
					<div class="fenbikaoyan-content">
						<div class="fenbikaoyan-text text-center">
							<p>粉笔申论提供面向公考用户的真题和批改服务，请扫描下方二维码进行下载。</p>
						</div>
						<div class="fenbikaoyan-download text-left">
							<div id="shenluncode">
								<img src="../images/download/code.png"/>
							</div>
							<div class="fenbikaoyan-download-text">
								<p>
									用手机扫描二维码，或进入
									<a target="_blank" href="https://itunes.apple.com/cn/app/%E7%B2%89%E7%AC%94%E7%94%B3%E8%AE%BA-%E6%8B%8D%E7%85%A7%E8%AF%86%E5%88%AB-%E7%B2%BE%E5%87%86%E6%89%B9%E6%94%B9/id1333004603?mt&#x3D;8">
										App Store 下载>
									</a>
								</p>
								<p>版本： 3.0.1&nbsp;&nbsp;&nbsp;更新时间： 2018年1月13日</p>
							</div>
						</div>
					</div>
				</div>
				<!-- 粉笔考研 -->
				<div role="tabpanel" class="tab-pane" id="fenbikaoyan">
					<div class="fenbikaoyan-image text-center">
						<div class="fenbikaoyan-image-detail"></div>
					</div>
					<div class="fenbikaoyan-content">
						<div class="fenbikaoyan-text text-center">
							<p>粉笔考研提供面向研究生用户的真题和批改服务，请扫描下方二维码进行下载。</p>
						</div>
						<div class="fenbikaoyan-download text-left">
							<div id="kaoyancode">
								<img src="../images/download/code.png"/>
							</div>
							<div class="fenbikaoyan-download-text">
								<p>
									用手机扫描二维码，或进入
									<a target="_blank" href="https://itunes.apple.com/cn/app/fen-bi-wang/id656497536">
										App Store 下载>
									</a>
								</p>
								<p>版本： 5.0.9&nbsp;&nbsp;&nbsp;更新时间： 2017年8月3日</p>
							</div>
						</div>
					</div>
				</div>
				<!-- pc -->
				<div role="tabpanel" class="tab-pane" id="fenbizhiboke">
					<div class="fenbizhiboke-left"></div>
					<div class="fenbizhiboke-right text-left">
						<div class="fenbizhiboke-right-text">
							<p>粉笔直播课为用户提供在电脑端观看直播课的功能，使用方法如下：</p>
							<br>
							<p>1、在app上已购买的课程的课程码</p>
							<p>2、在PC客户端上输入课程码即可观看</p>
						</div>
						<div>
							<!-- <h1>文件转发的方式</h1> -->
							<a href="#">
								<button id="download-button">
									<span class="download-button-icon"></span>
									<span>立即下载</span>
								</button>
							</a>
						</div>
						<div class="fenbizhiboke-right-version">
							<p>版本： 1.4.8.1066&nbsp;&nbsp;&nbsp;更新时间： 2018年2月28日</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/page/base/footer.jsp" %>
	
	<script src="js/download.js"></script>	
	
</body>
</html>
