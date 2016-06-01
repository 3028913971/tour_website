<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<link rel="stylesheet" type="text/css"
	href="webpage/mainpage/youji3/css/main.css">
<title>旅游攻略系统</title>
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
	<style>
.header h3 {
	top: -14px;
}
</style>
	<!--面包屑-->
	<ul id="breadcrumbs-four">
		<li><a
			href="<s:url action="travelNoteFirstPage_findAllIsTop.action" namespace="/"/>">游记首页&gt;&gt;</a></li>
		<li><s:a action="travelNoteSecondPage_pageIsTop.action"
				namespace="/">
				<s:property value="cityName" />游记&gt;&gt;
     		<s:param name="cityName" value="cityName"></s:param>
			</s:a></li>
		<li><a class="current"><s:property value="cityName" /></a></li>
	</ul>
	<!-- 面包屑end-->

	<!--main content START-->
	<div class="bodybg">
		<div class="wrap clearfix">
			<div class="blog-top clearfix">
				<div class="author-info">
					<div class="info-right">
						<div class="title clearfix">
							<h1 title="">
								<s:property value="travelNoteName" />
							</h1>
						</div>
						<span style="color:#ff6b3d">作者：<s:property
								value="travelNoteAuthor" /></span> <span
							style="margin-left:20px;color:#ff6b3d">发表日期：<s:property
								value="publicTime" /></span>

					</div>

				</div>
			</div>
			<div class="blog-right">
				<!--相关目的地 start-->
				<!--相关目的地 start-->
				<div class="rel-blog">
					<div class="rel-title">相似目的地</div>
					<div class="left-details">
						<s:iterator value="tdList" status="ss">
							<s:if test="#ss.getIndex()<6">
								<div class="hot-place">
									<a href="" class="scenery"><img
										src='<c:url value="/tdDescriptionPhotos/${cityPhotoRealName}"/>'
										width="50" height="50" style="display: inline;"></a> <span
										class="scenery-details"> <a href="" target="_blank"
										title="剑川县"><s:property value="cityName" /></a>

									</span>
								</div>
							</s:if>
						</s:iterator>

					</div>
				</div>


			</div>
			<div class="blog-left clearfix">
				<div class="blog-main">
					<s:property value="travelNoteContent" escape="false" />
				</div>
			</div>

		</div>
	</div>
	</div>
	<%@ include file="../../foot.jsp"%>
	<script src="webpage/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$("nav").find("li").eq(4).addClass("nav_active");
			var picList = document.getElementsByClassName("pic_list")[0];
			if (picList == null)
				$(".foot").css("bottom", "-250px");
		})
	</script>
</body>
</html>