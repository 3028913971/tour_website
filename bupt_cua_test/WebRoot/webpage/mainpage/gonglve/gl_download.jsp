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
<title>中联航旅游攻略</title>
<meta name="description" content="联航攻略下载">
<meta name="keywords" content="攻略下载,旅游攻略,联航旅游">

<link href="webpage/mainpage/gonglve/css/gonglve.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" href="webpage/css/lightbox.css">
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
		<!--面包屑-->
		<ul id="breadcrumbs-four">
			<li><a
				href="<s:url action="sffirstpage_loadStrategy.action" namespace="/"/>">攻略首页&gt;&gt;</a>
			</li>
			<li><a class="current"><s:property value="cityName" /> </a></li>
		</ul>
		<!-- 面包屑end-->
		<div class="mdd_img" style="cursor: pointer">
			<img
				src='<c:url value="/strategyFilePhotos/${strategyPhotoRealName}"/>'
				alt="">
		</div>
		<div class="middle_de">
			<h1>
				<s:property value="cityName" />
			</h1>

			<div class="gl_title">

				<div class="clear"></div>
			</div>
			<div class="jianjie">
				<p>
					<strong>简介</strong>
					<s:property value="descriptionOfCity" />
				</p>
			</div>
		</div>
		<div class="down_glb">
			<h2>
				<s:property value="amountOfDownload" />
				<span>&nbsp;人下载</span>
			</h2>

			<div class="down_p">
				<s:a action="sfdownload_download" namespace="/" theme="simple">
					<s:param name="cityName" value="cityName" />
					<s:param name="strategyFileName" value="strategyFileName" />
					<s:param name="strategyFileRealName" value="strategyFileRealName" />
                下载PDF版本
            </s:a>
				<br>
				<s:a action="sfdownload_downloadZip" namespace="/" theme="simple">
					<s:param name="cityName" value="cityName" />
					<s:param name="strategyJpgName" value="strategyJpgName" />
					<s:param name="strategyJpgRealName" value="strategyJpgRealName" />
                下载JPG版本
            </s:a>
			</div>
			<div class="up_time">
				<p>
					更新时间
					<s:property value="updateTime" />
				</p>
			</div>
		</div>
		<div class="clear"></div>
		<!-- 攻略预览start -->
		<script src="webpage/js/lightbox-plus-jquery.min.js"></script>
		<div class="preview clear">
			<ul>
				<s:iterator value="jspList">
					<li><a class="example-image-link"
						href='<c:url value="/strategyJpgListFiles/${dirName}/${fileName}"/>'
						data-lightbox="example-set"><img class="example-image"
							src='<c:url value="/strategyJpgListFiles/${dirName}/${fileName}"/>'
							alt="" /> </a> <a href="" class="preview_btn" style="display:block">点击预览</a></li>
				</s:iterator>

			</ul>
			<div class="clear"></div>
		</div>
		<!-- 攻略预览end -->
		<div class="gl_l">
			<div class="mdd_zj">
				<h1>直达目的地</h1>
				<s:iterator value="relevantCityNewList" status="ss">
					<s:if test="#ss.getIndex()<2">
						<div class="mdd_m">
							<h2>
								<s:a action="cdpage_loadCity" namespace="/" theme="simple">
									<s:param name="cityName" value="cityName" />
									<img
										src='<c:url value="/tdDescriptionPhotos/${cityPhotoRealName}"/>'
										alt="大理" height="90" width="140">
								</s:a>
							</h2>
							<dl>
								<dt>
									<s:a action="cdpage_loadCity" namespace="/" theme="simple">
										<s:param name="cityName" value="cityName" />
										<s:property value="cityName" />
									</s:a>

								</dt>
								<dd>

									<s:property value="themeType" />
								</dd>
							</dl>
							<div class="clear"></div>
						</div>
					</s:if>
				</s:iterator>
			</div>
		</div>
		<div class="gl_r">
			<div class="guess_like">
				<h2>跟此相关的攻略</h2>

				<div class="clear"></div>
			</div>
			<div class="gl_fw gl_fw1">
				<div class="gl_cw gl_cw1">

					<s:iterator value="relevantCityList" status="ss">
						<s:if test="#ss.getIndex()<4">
							<div class="gl_list">
								<s:a action="sfdownload_loadStrategy" namespace="/"
									theme="simple">
									<s:param name="cityName" value="cityName" />
									<img
										src='<c:url value="/strategyFilePhotos/${strategyPhotoRealName}"/>'
										alt="丽江" width="130" height="184">
								</s:a>

								<div class="down_cout">

									<p>
										<s:property value="amountOfDownload" />
										人下载
									</p>
									<span></span>
									<h4 style="margin-left:50px;letter-spacing:10px">
										<s:property value="cityName" />
									</h4>

								</div>
							</div>
						</s:if>
					</s:iterator>

					<div class="clear"></div>
				</div>
			</div>

		</div>
		<div class="clear"></div>
	</div>
	<style>
</style>

	<!-- foot start-->
	<%@ include file="../../foot.jsp"%>
	<!-- foot end-->

	<script src="webpage/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$("nav").find("li").eq(3).addClass("nav_active");
		})
	</script>
</body>
</html>