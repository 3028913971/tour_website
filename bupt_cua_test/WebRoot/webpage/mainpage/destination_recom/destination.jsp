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
<title>旅游 目的地旅游攻略</title>
<meta name="description" content="我们帮您寻找到适合你的旅行目的地，让你的旅行更精彩！">
<meta name="keywords" content="最新旅行手册路书下载,最新游记照片">
<link href="webpage/mainpage/destination_recom/css/base.css"
	rel="stylesheet" type="text/css">
<!-- 百度统计代码 -->
<script>
	var _hmt = _hmt || [];
	(function() {
		var hm = document.createElement("script");
		hm.src = "//hm.baidu.com/hm.js?9a4628a2c3fa798bc8282f6b539f9205";
		var s = document.getElementsByTagName("script")[0];
		s.parentNode.insertBefore(hm, s);
	})();
</script>
<!-- 百度统计代码 -->
</head>
<body>

	<%@ include file="../../head.jsp"%>

	<div class="container" data-cs-t="目的地首页">
		<div class="place-focus" data-cs-p="头图">
			<div class="show-banner">
				<div class="cover" style="height: auto;">
					<a class="bigimg" href=""> <img
						src='<c:url value="/tdTopPhotoFiles/${topPhoto.tdTopPhotoRealName}"/>'
						width="980" height="400">

					</a>
				</div>
			</div>
			<div class="place-search-panel place-search-panel-sm">
				<!--  <h2>Don't fear the unknown</h2> -->
				<s:form action="cd_searchCity" namespace="/" theme="simple">
					<div class="searchbar">
						<s:textfield name="search" cssClass="search-input"
							placeholder="请输入搜索的城市名" />
						<input type="submit" class="search-button" />
					</div>
				</s:form>

				<div class="place-search-hot">
					<s:iterator value="topSeasonCityList" status="ss">
						<s:if test="#ss.getIndex()<4">
							<s:a action="cdpage_loadCity" namespace="/" theme="simple">
								<s:param name="cityName" value="cityName" />
								<s:property value="cityName" />
							</s:a>
						</s:if>
					</s:iterator>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="wrapper">
				<div class="r-title">
					<span style="color: red">热门推荐</span> <i class="icon"></i>

					<div style="border-bottom: 2px solid red">最棒旅游目的地大搜罗</div>
				</div>
				<div class="discovery-tiles" style="display: block">
					<div class="tiles-left">
						<div class="tiles-item tiles-b">
							<s:a action="cdpage_loadCity" namespace="/" theme="simple"
								cssStyle="height:290px;width:615px">
								<s:param name="cityName"
									value="topSeasonCityList.get(0).cityName" />
								<div class="title">${topSeasonCityList.get(0).cityName}</div>
								<div class="info">
									<div class="middle">
										<h3>${topSeasonCityList.get(0).cityName}</h3>

										<p>${topSeasonCityList.get(0).description}</p>
									</div>
								</div>
								<img
									src='<c:url value="/tdDescriptionPhotos/${topSeasonCityList.get(0).cityPhotoRealName}"/>'
									style="margin: -15px 0px 0px; width: 100%; height: auto;">
							</s:a>
						</div>

						<div class="tiles-item tiles-c2">
							<s:a action="cdpage_loadCity" namespace="/" theme="simple"
								cssStyle="height:280px;width:300px">
								<s:param name="cityName"
									value="topSeasonCityList.get(1).cityName" />
								<div class="title">${topSeasonCityList.get(1).cityName}</div>
								<div class="info">
									<div class="middle">
										<h3>${topSeasonCityList.get(1).cityName}</h3>

										<p>${topSeasonCityList.get(1).description}</p>
									</div>
								</div>
								<img
									src='<c:url value="/tdDescriptionPhotos/${topSeasonCityList.get(1).cityPhotoRealName}"/>'
									style="margin: 0px 0px 0px -114.110429447853px; height: 100%; width: auto;">
							</s:a>
						</div>
						<div class="tiles-item tiles-c2">
							<s:a action="cdpage_loadCity" namespace="/" theme="simple"
								cssStyle="height:280px;width:300px">
								<s:param name="cityName"
									value="topSeasonCityList.get(2).cityName" />
								<div class="title">${topSeasonCityList.get(2).cityName}</div>
								<div class="info">
									<div class="middle">
										<h3>${topSeasonCityList.get(2).cityName}</h3>

										<p>${topSeasonCityList.get(2).description}</p>
									</div>
								</div>
								<img
									src='<c:url value="/tdDescriptionPhotos/${topSeasonCityList.get(2).cityPhotoRealName}"/>'
									style="margin: 0px 0px 0px -61.0294117647059px; height: 100%; width: auto;">
							</s:a>
						</div>
					</div>
					<div class="tiles-right">
						<div class="tiles-item tiles-r3">
							<s:a action="cdpage_loadCity" namespace="/" theme="simple"
								cssStyle="height:185px;width:370px">
								<s:param name="cityName"
									value="topSeasonCityList.get(3).cityName" />
								<div class="title">${topSeasonCityList.get(3).cityName}</div>
								<div class="info">
									<div class="middle">
										<h3>${topSeasonCityList.get(3).cityName}</h3>

										<p>${topSeasonCityList.get(3).description}</p>
									</div>
								</div>
								<img
									src='<c:url value="/tdDescriptionPhotos/${topSeasonCityList.get(3).cityPhotoRealName}"/>'
									style="width: 370px; height: 185px;">
							</s:a>
						</div>
						<div class="tiles-item tiles-r3">
							<s:a action="cdpage_loadCity" namespace="/" theme="simple"
								cssStyle="height:185px;width:370px">
								<s:param name="cityName"
									value="topSeasonCityList.get(4).cityName" />

								<div class="title">${topSeasonCityList.get(4).cityName}</div>
								<div class="info">
									<div class="middle">
										<h3>${topSeasonCityList.get(4).cityName}</h3>

										<p>${topSeasonCityList.get(4).description}</p>
									</div>
								</div>
								<img
									src='<c:url value="/tdDescriptionPhotos/${topSeasonCityList.get(4).cityPhotoRealName}"/>'
									style="width: 370px; height: 185px;">
							</s:a>
						</div>
						<div class="tiles-item tiles-r3">
							<s:a action="cdpage_loadCity" namespace="/" theme="simple"
								cssStyle="height:185px;width:370px">
								<s:param name="cityName"
									value="topSeasonCityList.get(5).cityName" />
								<div class="title">${topSeasonCityList.get(5).cityName}</div>
								<div class="info">
									<div class="middle">
										<h3>${topSeasonCityList.get(5).cityName}</h3>

										<p>${topSeasonCityList.get(5).description}</p>
									</div>
								</div>
								<img
									src='<c:url value="/tdDescriptionPhotos/${topSeasonCityList.get(5).cityPhotoRealName}"/>'
									style="width: 370px; height: 185px;">
							</s:a>
						</div>
					</div>
				</div>


				<div class="wrapper">
					<div class="iamad-fxckme middle" style="margin:15px auto 0;">
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="wrapper">
				<div class="row-list" data-cs-p="国内目的地" id="domestic">
					<i class="row-icon" id="theme-icon"></i>
					<h2 class="hd" id="chinamdd">主题目的地</h2>
					<div class="row-line"></div>
					<div class="bd bd-china">
						<s:iterator value="themeTypeCityList" id="themeTypeCityList1">
							<dl class="item">

								<dt class="sub-title">
									<img class="theme-type-icon"
										src='<c:url value="/themeFiles/${themeTypeCityList1.key.themeRealName}"/>' />
									<a style="position: relative;top: 2px;"><s:property
											value="#themeTypeCityList1.key.themeName" /></a>
								</dt>
								<dd>
									<ul>
										<s:iterator value="#themeTypeCityList1.value"
											id="themeTypeCityList2">
											<li><s:a action="cdpage_loadCity" namespace="/"
													theme="simple" cssClass="link-hot">
													<s:param name="cityName" value="themeTypeCityList2" />
													<s:property value="themeTypeCityList2" />
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
				<div class="row-list" data-cs-p="国内目的地" id="domestic">
					<i class="row-icon" id="mdd-icon"></i>
					<h2 class="hd" id="chinamdd">国内目的地</h2>
					<div class="row-line"></div>
					<div class="bd bd-china">
						<s:iterator value="homeCityList" id="homeCityList1">
							<dl class="item">
								<dt class="sub-title" style="line-height: 34px;">
									<s:property value="#homeCityList1.key" />
								</dt>
								<dd>
									<ul>
										<s:iterator value="#homeCityList1.value" id="homeCityList2">
											<li><s:a action="cdpage_loadCity" namespace="/"
													theme="simple" cssClass="link-hot">
													<s:param name="cityName" value="homeCityList2" />
													<s:property value="homeCityList2" />
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
	</div>


	<link href="css/mfw-footer.css" rel="stylesheet" type="text/css">

	<%@ include file="../../foot.jsp"%>
	<script src="webpage/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$("nav").find("li").eq(1).addClass("nav_active");
			$(".search-button").click(function() {

				var value = $("#cd_searchCity_search").val();
				if (value == null || value.trim() == "") {
					alert("请输入要查询的城市名！");
					return false;
				}
			});
		})
	</script>
</body>
</html>