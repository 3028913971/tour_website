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
<meta charset="UTF-8">
<title>旅游攻略网站</title>
<link rel="stylesheet" href="webpage/css/homepage.css" charset="utf-8" />
<link rel="stylesheet" href="webpage/css/eric-meyer-reset.min.css" />
<link rel="stylesheet" href="webpage/css/common.css" />

<!-- 统计代码 -->
<script>
	var _hmt = _hmt || [];
	(function() {
		var hm = document.createElement("script");
		hm.src = "//hm.baidu.com/hm.js?9a4628a2c3fa798bc8282f6b539f9205";
		var s = document.getElementsByTagName("script")[0];
		s.parentNode.insertBefore(hm, s);
	})();
</script>
<!-- 统计代码 -->
</head>
<body>
	<%@ include file="head.jsp"%>
	<div class="banner">
		<!--banner start-->
		<div id="container">
			<div id="list" style="left:-1424px">
				<s:a action="cdpage_loadCity" namespace="/"> <img
					src='<c:url value="/topPhotoFiles/${lastTopPhotoRealName}"/>' />
					<s:param name="cityName">${lastTopPhotoCityName}</s:param>
				</s:a>
				<s:iterator value="topPhotoList" id="topPhotoList1" status="s1">
					<s:if test="#s1.getIndex()<5">
						<s:a action="cdpage_loadCity" namespace="/"> <img
							src='<c:url value="/topPhotoFiles/${topPhotoList1.key}"/>' />
							<s:param name="cityName" value="#topPhotoList1.value">
							</s:param>
						</s:a>
					</s:if>
				</s:iterator>
				<s:a action="cdpage_loadCity" namespace="/"> <img
					src='<c:url value="/topPhotoFiles/${firstTopPhotoRealName}"/>' />
					<s:param name="cityName">${firstTopPhotoCityName }</s:param>
				</s:a>
			</div>
			<div id="buttons">
				<span index="1" class="on"></span> <span index="2"></span> <span
					index="3"></span> <span index="4"></span> <span index="5"></span>
			</div>
			    <a href="javascript:;" id="prev">&lt;</a>
   				 <a href="javascript:;" id="next">&gt;</a>
		</div>
		<!--banner end-->

		<ul class="topmenu">

			<li><i id="icon1"></i> <a class="title">本季热门推荐</a>

				<p style="position:relative;top:-35px;left:52px;line-height:20px">
					<s:iterator value="topSeasonCityList" id="topSeasonCityList1"
						status="ss">
						<s:if test="#ss.getIndex()<3">
							<s:a action="cdpage_loadCity" namespace="/" theme="simple">
								<s:param name="cityName" value="topSeasonCityList1"></s:param>
								<s:property value="topSeasonCityList1" />
							</s:a>
						</s:if>
					</s:iterator>
				</p>
				<div class="submenu">
					<div class="leftdiv">
						<dl>
							<dt>
								<a href="">本季热门推荐</a>
							</dt>
							<dd>
								<s:iterator value="topSeasonCityList" id="topSeasonCityList1">
									<s:a action="cdpage_loadCity" namespace="/" theme="simple">
										<s:param name="cityName" value="topSeasonCityList1"></s:param>
										<s:property value="topSeasonCityList1" />
									</s:a>
								</s:iterator>
							</dd>
						</dl>
					</div>

				</div></li>
			<li><i id="icon2"></i> <a class="title">主题目的地推荐</a>

				<p style="position:relative;top:-35px;left:52px;line-height:20px">
					<s:iterator value="themeTypeCityList" id="themeTypeCityList1"
						status="ss">
						<s:if test="#ss.getIndex()<2">
							<s:iterator value="#themeTypeCityList1.value"
								id="themeTypeCityList2" status="s1">
								<s:if test="#s1.getIndex()<1">
									<s:a action="cdpage_loadCity" namespace="/" theme="simple">
										<s:param name="cityName" value="themeTypeCityList2"></s:param>
										<s:property value="themeTypeCityList2" />
									</s:a>
								</s:if>
							</s:iterator>
						</s:if>
					</s:iterator>
				</p>
				<div class="submenu">
					<div class="leftdiv">
						<dl>
							<s:iterator value="themeTypeCityList" id="themeTypeCityList1">
								<dt>
									<a href=""><s:property value="#themeTypeCityList1.key" /></a>
								</dt>
								<dd>
									<s:iterator value="#themeTypeCityList1.value"
										id="themeTypeCityList2">

										<s:a action="cdpage_loadCity" namespace="/" theme="simple">
											<s:param name="cityName" value="themeTypeCityList2"></s:param>
											<s:property value="themeTypeCityList2" />
										</s:a>
									</s:iterator>
								</dd>
							</s:iterator>

						</dl>
					</div>

				</div></li>
			<li><i id="icon3"></i> <a class="title">国内目的地推荐</a>

				<p style="position:relative;top:-35px;left:52px;line-height:20px">
					<s:iterator value="topSeasonCityList" id="topSeasonCityList1"
						status="ss">
						<s:if test="#ss.getIndex()<3">
							<s:a action="cdpage_loadCity" namespace="/" theme="simple">
								<s:param name="cityName" value="topSeasonCityList1"></s:param>
								<s:property value="topSeasonCityList1" />
							</s:a>
						</s:if>
					</s:iterator>
				</p>
				<div class="submenu">
					<div class="leftdiv">
						<dl>
							<s:iterator value="areaCityList" id="areaCityList1">
								<dt>
									<a href=""> <s:property value="#areaCityList1.key" />
									</a>
								</dt>
								<dd>
									<s:iterator value="#areaCityList1.value" id="areaCityList2">
										<s:a action="cdpage_loadCity" namespace="/" theme="simple">
											<s:param name="cityName" value="areaCityList2"></s:param>
											<s:property value="areaCityList2" />
										</s:a>
									</s:iterator>
								</dd>
							</s:iterator>
					</div>

				</div></li>
			<li><i id="icon4"></i> <a class="title">热门游记推荐</a>

				<p style="position:relative;top:-35px;left:52px;line-height:20px">
					<s:iterator value="themeTypeCityList" id="themeTypeCityList1"
						status="ss">
						<s:if test="#ss.getIndex()<2">
							<s:iterator value="#themeTypeCityList1.value"
								id="themeTypeCityList2" status="s1">
								<s:if test="#s1.getIndex()<1">
									<s:a action="travelNoteSecondPage_pageIsTop" namespace="/"
										theme="simple">
										<s:param name="cityName" value="themeTypeCityList2"></s:param>
										<s:property value="themeTypeCityList2" />
									</s:a>
								</s:if>
							</s:iterator>
						</s:if>
					</s:iterator>
				</p>
				<div class="submenu">
					<div class="leftdiv">
						<dl>
							<s:iterator value="themeTypeCityList" id="themeTypeCityList1">
								<dt>
									<a> <s:property value="#themeTypeCityList1.key" />
									</a>
								</dt>
								<dd>
									<s:iterator value="#themeTypeCityList1.value"
										id="themeTypeCityList2">
										<s:a action="travelNoteSecondPage_pageIsTop" namespace="/"
											theme="simple">
											<s:param name="cityName" value="themeTypeCityList2"></s:param>
											<s:property value="themeTypeCityList2" />
										</s:a>
									</s:iterator>
								</dd>
							</s:iterator>
						</dl>
					</div>
				</div></li>
		</ul>
	</div>

	<style>
.wrap_main {
	width: 100%;
	height: 200%;
	/*background-color: #F3F3F3;*/
	padding-top: 20px;
}

.banner {
	width: 100%;
	height: 400px;
}
</style>

	<div class="clearfix"></div>
	<div class="wrap_main">
		<!--本季推荐start-->
		<section class="layer_body season clear_fix" id="now_hot">
			<div class="box_hd">
				<i class="icon"></i>

				<h2>本季推荐</h2>

				<div class="line clear_fix"></div>
				<a href="<s:url action="cd_loadCity" namespace="/"/>">MORE&gt;&gt;</a>
			</div>



			<s:iterator value="tdTopSeasonList" status="ss">
				<s:if test="#ss.getIndex()<4">
					<div class="layer_inner clear_fix">
						<div class="tab_inner clear_fix">
							<div class="sesson-city">
								<div class="city_img">
									<s:a action="cdpage_loadCity" namespace="/" theme="simple">
										<s:param name="cityName" value="cityName" />
										<img
											src='<c:url value="/tdDescriptionPhotos/${cityPhotoRealName}"/>'
											alt="" width="230" height="140" title="" />
									</s:a>
								</div>
								<div class="city_desc">
									<div class="city_title">
										<span class="city_name">${cityName}</span> <i class="point"></i>
										<span class="site_name">${themeNickname}</span>
									</div>
									<p>${description }</p>
								</div>
							</div>
						</div>
					</div>
				</s:if>
			</s:iterator>
		</section>
		<!--本季推荐end-->
		<div class="clear_fix"></div>
		<!--主题目的地推荐start-->
		<section class="layer_body destination" id="theme">
			<div class="box_hd">
				<i class="icon"></i>

				<h2>主题目的地推荐</h2>

				<div class="line clear_fix"></div>
				<a href="<s:url action="cd_loadCity" namespace="/"/>">MORE&gt;&gt;</a>
			</div>

			<s:iterator value="tdThemeTypeList" status="ss">
				<s:if test="#ss.getIndex()<5">
					<div class="layer_inner">
						<s:a action="cdpage_loadCity" namespace="/" theme="simple">
							<s:param name="cityName" value="cityName" />
							<div class="des_img">
								<img
									style="background:url('<c:url value="/tdDescriptionPhotos/${cityPhotoRealName}"/>') center center;width:190px;height:280px" />

							</div>
							<div class="desc_img">
								<h2>${themeNickname }</h2>
							</div>
						</s:a>

					</div>
				</s:if>
			</s:iterator>
		</section>
		<!--主题目的地推荐end-->

		<div class="clear_fix"></div>
		<!--攻略下载start-->
		<section class="layer_body  strategy" id="gonglve">
			<div class="box_hd">
				<i class="icon"></i>

				<h2>目的地攻略下载</h2>

				<div class="line clear_fix"></div>
				<a href="<s:url action="sffirstpage_loadStrategy" namespace="/"/>">MORE&gt;&gt;</a>
			</div>

			<div class="sort">
				<a class=active>本季最受欢迎</a> <span>|</span> <a>下载人气</a> <span>|</span>
				<a>更新时间</a>

				<div class="clear_fix"></div>
			</div>
			<div class="clear_fix"></div>
			<div class="wrap_gonglve">
				<s:iterator value="sfIsTopSeasonList" status="ss">
					<s:if test="#ss.getIndex()<6">
						<div class="layer_inner">
							<div class="des_img">
								<s:a action="sfdownload_loadStrategy" namespace="/"
									theme="simple">
									<s:param name="cityName" value="cityName" />
									<img
										src='<c:url value="/strategyFilePhotos/${strategyPhotoRealName}"/>'
										alt="旅游攻略" width="140" height="180" />
								</s:a>

							</div>
							<div class="desc_img" style="bottom:0px;background-color: white">
								<em style="color: black">更新时间：${updateTime }</em>

								<div class="down_cout">
									<span></span>

									<p>${amountOfDownload }&nbsp;人下载</p>
								</div>
							</div>
						</div>
					</s:if>
				</s:iterator>
			</div>
			<div class="wrap_gonglve" style="display: none">
				<s:iterator value="sfAmountOfDownloadList" status="ss">
					<s:if test="#ss.getIndex()<6">
						<div class="layer_inner">
							<div class="des_img">
								<s:a action="sfdownload_loadStrategy" namespace="/"
									theme="simple">
									<s:param name="cityName" value="cityName" />
									<img
										src='<c:url value="/strategyFilePhotos/${strategyPhotoRealName}"/>'
										alt="qq" width="140" height="180" />
								</s:a>
							</div>
							<div class="desc_img">
								<em style="color: black">更新时间：${updateTime }</em>

								<div class="down_cout">
									<span></span>

									<p>下载次数：${amountOfDownload }</p>
								</div>
							</div>
						</div>
					</s:if>
				</s:iterator>
			</div>
			<div class="wrap_gonglve" style="display: none">
				<s:iterator value="sfUpdateTimeList" status="ss">
					<s:if test="#ss.getIndex()<6">
						<div class="layer_inner">
							<div class="des_img">
								<s:a action="sfdownload_loadStrategy" namespace="/"
									theme="simple">
									<s:param name="cityName" value="cityName" />
									<img
										src='<c:url value="/strategyFilePhotos/${strategyPhotoRealName}"/>'
										alt="qq" width="140" height="180" />
								</s:a>
							</div>
							<div class="desc_img">
								<em style="color: black">更新时间：${updateTime }</em>

								<div class="down_cout">
									<span></span>

									<p>下载次数：${amountOfDownload }</p>
								</div>
							</div>
						</div>
					</s:if>
				</s:iterator>
			</div>
		</section>
		<!--攻略下载end-->

		<!-- 国内目的地攻略下载start-->
		<div class="city_list clear_fix title">
			<h1>国内目的地攻略下载</h1>
			<ul>
				<s:iterator value="homeCityList" id="homeCityList1">
					<li><s:a action="sfdownload_loadStrategy" namespace="/"
							theme="simple">
							<s:param name="cityName" value="homeCityList1" />
							<s:property value="homeCityList1" />
						</s:a></li>
				</s:iterator>
			</ul>
		</div>
		<!-- 国内目的地攻略下载end-->

		<!-- foot start-->
		<%@ include file="foot.jsp"%>
		<!-- foot end-->
	</div>
	<script type="text/javascript" src="webpage/js/slider.js"></script>
	<script type="text/javascript" src="webpage/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="webpage/js/homepage.js"></script>
</body>
</html>