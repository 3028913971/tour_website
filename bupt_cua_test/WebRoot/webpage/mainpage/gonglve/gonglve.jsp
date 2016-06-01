<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>旅游攻略下载</title>
<meta name="description" content="旅游攻略信息由真实的旅行用户志愿提供">
<meta name="keywords" content="联航旅游,旅游攻略下载,自助游攻略,自由行攻略,路书,旅游指南">


<link href="webpage/mainpage/gonglve/css/gonglve.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript" src="webpage/js/myfocus-2.0.1.min.js"></script>
<script type="text/javascript" src="webpage/js/common.js"></script>
<script type="text/javascript"
	src="webpage/mainpage/gonglve/js/gonglue.js"></script>
<script type="text/javascript">
	//设置
	myFocus.set({
		id : 'myFocus',//ID
		pattern : 'mF_YSlider'//风格mF_kiki
	});
</script>

<style id="style-1-cropbar-clipper">
.banner {
	height: 340px;
	overflow: hidden;
	margin: 0 auto;
}
</style>
<script>
	var _hmt = _hmt || [];
	(function() {
		var hm = document.createElement("script");
		hm.src = "//hm.baidu.com/hm.js?9a4628a2c3fa798bc8282f6b539f9205";
		var s = document.getElementsByTagName("script")[0];
		s.parentNode.insertBefore(hm, s);
	})();
</script>

</head>
<body>
	<%@ include file="../../head.jsp"%>
	<div class="wrapper">
		<div class="focus">
			<div class="mdd_nav">
				<div class="gonglve-nav" data-cs-t="攻略导航">
					<s:iterator value="themeTypeCityList" id="themeTypeCityList1"
						status="sss">
						<s:if test="#sss.getIndex()<5">
							<div class="nav-item">
								<div class="nav-title">
									<img class="theme_icon"
										src='<c:url value="/themeFiles/${themeTypeCityList1.key.themeRealName}"/>' />
									<a><span class="theme_name"> <s:property
												value="#themeTypeCityList1.key.themeName" />
									</span></a>
									<!--   <b class="gn-arrow"></b> -->

									<div class="nav-panel rank-panel">
										<ol>
											<s:iterator value="#themeTypeCityList1.value"
												id="themeTypeCityList2" status="s">
												<li class="top3"><strong> <s:a
															action="sfdownload_loadStrategy" namespace="/"
															theme="simple">
															<s:param name="cityName" value="cityName"></s:param>
															<s:property value="cityName" />
														</s:a>
												</strong> <s:a action="sfdownload_loadStrategy" namespace="/"
														theme="simple">
														<s:param name="cityName" value="cityName"></s:param>
														<s:property value="themeNickname" />
													</s:a></li>

											</s:iterator>
										</ol>
									</div>
								</div>
							</div>
						</s:if>
					</s:iterator>
				</div>
				<div class="input_like">
					<div>

						<s:form action="sfdownload_searchStrategy" namespace="/"
							theme="simple">
							<s:textfield name="search" id="search_word" placeholder="请输入城市名" />
							<input class="sub-btn" type="submit"  />
						</s:form>
						<div class="clear"></div>
					</div>
				</div>
			</div>
			<!--banner start-->
			<div class="banner" id="myFocus">
				<div class="loading">
					<img src="webpage/images/loading.gif" alt="客官您稍等..." />
				</div>
				<!--载入画面(可删除)-->
				<div class="pic">
					<ul>
						<s:iterator value="topPicList" id="topPicList1">
							<li><a href="#"> <img
									src='<c:url value="/strategyTopPhotoFiles/${topPicList1}"/>'
									alt="" width="720" height="350" />
							</a></li>
						</s:iterator>
					</ul>

				</div>

			</div>
			<!--banner end-->
		</div>
		<div class="p_upw">
			<div class="uptime_p">
				<a class="active">本季最受欢迎</a> <span>|</span> <a>下载人气</a> <span>|</span>
				<a>更新时间</a>

				<div class="clear"></div>
			</div>
			<div class="clear"></div>
		</div>
		<!-- 攻略列表开始-->
		<div class="gonglve_wrap">
			<div class="gl_fw">
				<div class="gl_cw">
					<s:iterator value="isTopList" status="ss">
						<s:if test="#ss.getIndex()<18">
							<div class="gl_list">
								<s:a action="sfdownload_loadStrategy" namespace="/"
									theme="simple">
									<s:param name="cityName" value="cityName"></s:param>
									<img
										src='<c:url value="/strategyFilePhotos/${strategyPhotoRealName}"/>'
										alt="青岛" width="130" height="184">
								</s:a>
								<%--<div class="update_time">${cityName }</div>--%>
								<div class="update_time">更新时间：${updateTime }</div>
								<div class="down_cout">
									<span></span>

									<p>${amountOfDownload }人下载</p>
								</div>
							</div>
						</s:if>
					</s:iterator>
					<div class="clear"></div>
				</div>
				<div class="gl_cw" style="display: none">
					<s:iterator value="amountOfDownloadList" status="ss">
						<s:if test="#ss.getIndex()<18">
							<div class="gl_list">
								<s:a action="sfdownload_loadStrategy" namespace="/"
									theme="simple">
									<s:param name="cityName" value="cityName"></s:param>
									<img
										src='<c:url value="/strategyFilePhotos/${strategyPhotoRealName}"/>'
										alt="青岛" width="130" height="184">
								</s:a>
								<%--<div class="update_time">${cityName }</div>--%>
								<div class="update_time">更新时间：${updateTime }</div>
								<div class="down_cout">
									<span></span>

									<p>${amountOfDownload }人下载</p>
								</div>
							</div>
						</s:if>
					</s:iterator>
					<div class="clear"></div>
				</div>
				<div class="gl_cw" style="display: none">
					<s:iterator value="updatetimeList" status="ss">
						<s:if test="#ss.getIndex()<18">
							<div class="gl_list">
								<s:a action="sfdownload_loadStrategy" namespace="/"
									theme="simple">
									<s:param name="cityName" value="cityName"></s:param>
									<img
										src='<c:url value="/strategyFilePhotos/${strategyPhotoRealName}"/>'
										alt="成都" width="130" height="184">
								</s:a>
								<%--<div class="update_time">${cityName }</div>--%>
								<div class="update_time">更新时间：${updateTime }</div>
								<div class="down_cout">
									<span></span>

									<p>${amountOfDownload }人下载</p>
								</div>
							</div>
						</s:if>
					</s:iterator>

					<div class="clear"></div>
				</div>
			</div>

		</div>
		<!-- 攻略列表end-->
	</div>

	<div class="row">
		<div class="wrapper">
			<div class="row-list">
				<i class="row-icon" id="theme-icon"></i>
				<h2 class="hd">主题推荐</h2>
				<div class="row-line"></div>
				<div class="bd bd-china">
					<s:iterator value="themeCityList" id="themeCityList1">
						<dl class="item">

							<a><dt class="sub-title">
									<img class="theme-type-icon"
										src='<c:url value="/themeFiles/${themeCityList1.key.themeRealName}"/>' />
									<s:property value="#themeCityList1.key.themeName" />
								</dt></a>
							<dd>
								<ul>
									<s:iterator value="#themeCityList1.value" id="themeCityList2">
										<li style="margin-top:1px;"><s:a
												action="sfdownload_loadStrategy" namespace="/"
												theme="simple" cssClass="link-hot">
												<s:param name="cityName" value="themeCityList2"></s:param>
												<s:property value="themeCityList2" />
											</s:a></li>
									</s:iterator>
								</ul>
							</dd>
						</dl>
					</s:iterator>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="wrapper">
			<div class="row-list" id="domestic">
				<i class="row-icon" id="mdd-icon"></i>
				<h2 class="hd" id="chinamdd">国内目的地</h2>
				<div class="row-line"></div>
				<div class="bd bd-china">
					<s:iterator value="areaCityList" id="areaCityList1">
						<dl class="item">
							<dt class="sub-title" style="line-height: 43px;font-size:11pt">
								<s:property value="#areaCityList1.key" />
							</dt>
							<dd>
								<ul>
									<s:iterator value="#areaCityList1.value" id="areaCityList2">
										<li><s:a action="sfdownload_loadStrategy"
												cssClass="link-hot">
												<s:param name="cityName" value="areaCityList2"></s:param>
												<s:property value="areaCityList2" />
											</s:a></li>
									</s:iterator>
								</ul>
							</dd>
						</dl>
					</s:iterator>
				</div>
			</div>
		</div>
	</div>
	<script src="webpage/js/jquery-1.11.1.min.js"></script>
	<script language="javascript" type="text/javascript">
		$(function() {
			$("nav").find("li").eq(3).addClass("nav_active");
			blockSwitch();
		});
	</script>
	<!-- foot start-->
	<%@ include file="../../foot.jsp"%>
	<!-- foot end-->
</body>
</html>