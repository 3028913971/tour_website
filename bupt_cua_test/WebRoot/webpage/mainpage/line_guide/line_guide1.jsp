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
<title>旅游目的地简介</title>
<meta name="description" content="旅游攻略,旅游目的地">
<meta name="keywords" content="旅游攻略,旅游目的地">
<link href="webpage/mainpage/line_guide/css/main.css" rel="stylesheet"
	type="text/css">
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

	<div id="container" data-cs-t="目的地详情页">
		<!--面包屑-->
		<ul id="breadcrumbs-four">
			<li><a href="<s:url action="cd_loadCity.action" namespace="/"/>">目的地推荐&gt;&gt;</a></li>
			<li><a class="current"><s:property value="cityName" /></a></li>
		</ul>
		<!-- 面包屑end-->
		<div class="row row-primary">
			<div class="wrapper">
				<link href="css/place-nav.css" rel="stylesheet" type="text/css">

				<style type="text/css">
</style>
				<div class="screen clearfix">
					<div class="r-main">
						<a class="photo" href="#"> <img
							src='<c:url value="/tdDescriptionPhotos/${cityPhotoRealName}"/>'
							height="360" width="680">

							<div class="text">
								<h1>
									<s:property value="cityName" />
								</h1>
								<span>&nbsp;&nbsp;<s:property value="themeNickname" /></span>
							</div>
						</a>
					</div>
					<div class="r-side">
						<div class="m-impress">
							<h3 class="hd">
								<s:property value="cityName" />
							</h3>

							<div class="bd">
								<p>
									<s:property value="description" />
								</p>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>



		<div class="row row-feature">
			<div class="wrapper">

				<div class="col col-hotel">
					<h2 class="hd">交通</h2>
					<div>
						<div class="r-photo">
							<img
								src='<c:url value="/tdTrafficPhotos/${trafficPhotoRealName}"/>'
								height="183" width="277">
						</div>
						<div class="r-text">
							<s:property value="trafficDescription" />
						</div>
					</div>
				</div>
				<div class="ft"></div>

				<div class="col col-hotel">
					<h2 class="hd">美食</h2>
					<div>
						<div class="r-photo">
							<img src='<c:url value="/tdFoodPhotos/${foodPhotoRealName}"/>'
								height="183" width="277">
						</div>
						<div class="r-text">
							<s:property value="foodDescription" />
						</div>
					</div>
				</div>
				<div class="ft"></div>
				<div class="col col-hotel">
					<h2 class="hd">景点</h2>
					<div>
						<div class="r-photo">
							<img src='<c:url value="/tdSpotPhotos/${spotPhotoRealName}"/>'
								height="183" width="277">
						</div>
						<div class="r-text">
							<s:property value="spotDescription" />
						</div>
					</div>
				</div>
				<div class="ft"></div>
				<div class="col col-hotel">
					<h2 class="hd">购物</h2>
					<div>
						<div class="r-photo">
							<img
								src='<c:url value="/tdShoppingPhotos/${shoppingPhotoRealName}"/>'
								height="183" width="277">
						</div>
						<div class="r-text">
							<s:property value="shoppingDescription" />
						</div>
					</div>
				</div>
				<div class="ft"></div>
				<div class="download">
					
					<s:a action="sfdownload_loadStrategy" namespace="/">
						<s:param name="cityName" value="cityName"></s:param>去下载旅游攻略
					</s:a>
				</div>
			</div>
		</div>


	</div>
	<%@ include file="../../foot.jsp"%>

	<script src="webpage/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$("nav").find("li").eq(1).addClass("nav_active");
		})
	</script>
</body>
</html>