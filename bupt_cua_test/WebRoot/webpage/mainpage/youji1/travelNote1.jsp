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
<link rel="stylesheet" type="text/css"
	href="webpage/mainpage/youji1/css/nav.css">
<link rel="stylesheet" type="text/css" href="webpage/css/common.css">
<title>旅游攻略 旅游游记</title>
<script type="text/javascript" src="webpage/js/slider.js"></script>
<script>
	window.onload = function() {
		slider(980);
	}
</script>

<style>
.banner {
	width: 100%;
	height: 400px;
}
#container{
	width:980px
}
#list{
	width:6860px;
}
#list img{
	width:980px
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
	<!-- main content start -->
	<%@ include file="../../head.jsp"%>
	<!--banner start-->
	<div class="banner">

		<div id="container">
			<div id="list" style="left:-980px">
				<a href="#"> <img
					src='<c:url value="/travelnoteTopPhotoFiles/${picList[4]}"/>'
					alt="" />
				</a>
				<s:iterator value="picList" id="picList1" status="ss">
					<s:if test="#ss.getIndex()<5">
						<a href="#"> <img
							src='<c:url value="/travelnoteTopPhotoFiles/${picList1}"/>'
							alt="" />
						</a>
					</s:if>
				</s:iterator>
				<a href="#"> <img
					src='<c:url value="/travelnoteTopPhotoFiles/${picList[0]}"/>'
					alt="" />
				</a>
			</div>
			<div id="buttons">
				<span index="1" class="on"></span> <span index="2"></span> <span
					index="3"></span> <span index="4"></span> <span index="5"></span>
			</div>
			  
		</div>
		<!--banner end-->



		<ul class="topmenu">

			<li><i id="icon1"></i> <a class="title">本季热门推荐</a>

				<p style="position:relative;top:-35px;left:52px;line-height:20px">
					<s:iterator value="themeTypeList" id="themeTypeList1" status="s1">
						<s:if test="#s1.getIndex()<2">
							<s:iterator value="#themeTypeList1.value" id="themeTypeList2"
								status="s2">
								<s:if test="#s2.getIndex()<1">
									<s:a action="travelNoteSecondPage_pageIsTop" namespace="/"
										theme="simple">
										<s:param name="cityName" value="themeTypeList2" />
										<s:property value="themeTypeList2" />
									</s:a>
								</s:if>
							</s:iterator>
						</s:if>
					</s:iterator>

				</p>
				<div class="submenu">
					<div class="leftdiv">
						<dl>
							<s:iterator value="homeList" id="homeList1">
								<dt>
									<a href=""> <s:property value="#homeList1.key" />
									</a>
								</dt>
								<dd>
									<s:iterator value="#homeList1.value" id="homeList2">
										<s:a action="travelNoteSecondPage_pageIsTop" namespace="/"
											theme="simple">
											<s:param name="cityName" value="homeList2" />
											<s:property value="homeList2" />
										</s:a>
									</s:iterator>
								</dd>
							</s:iterator>
						</dl>

					</div>

				</div></li>
			<li><i id="icon2"></i> <a class="title">主题目的地推荐</a>

				<p style="position:relative;top:-35px;left:52px;line-height:20px">
					<s:iterator value="homeList" id="homeList1" status="s3">
						<s:if test="#s3.getIndex()<3">
							<s:iterator value="#homeList1.value" id="homeList2" status="s4">
								<s:if test="#s4.getIndex()<1">
									<s:a action="travelNoteSecondPage_pageIsTop" namespace="/"
										theme="simple">
										<s:param name="cityName" value="homeList2" />
										<s:property value="homeList2" />
									</s:a>
								</s:if>
							</s:iterator>
						</s:if>
					</s:iterator>
				</p>
				<div class="submenu">
					<div class="leftdiv">
						<dl>
							<s:iterator value="themeTypeList" id="themeTypeList1">
								<dt>
									<a href=""> <s:property value="#themeTypeList1.key" />
									</a>
								</dt>
								<dd>
									<s:iterator value="#themeTypeList1.value" id="themeTypeList2">
										<s:a action="travelNoteSecondPage_pageIsTop" namespace="/"
											theme="simple">
											<s:param name="cityName" value="themeTypeList2" />
											<s:property value="themeTypeList2" />
										</s:a>
									</s:iterator>
								</dd>
							</s:iterator>
						</dl>
					</div>
				</div></li>
		</ul>

	</div>


	<div class="box">
		<ul class="btn clear_fix">
			<li style="margin-left: 180px;border-right: 1px solid gray;"><s:a
					cssClass="active" theme="simple"
					action="travelNoteFirstPage_pageIsTop" namespace="/">
            热门
        </s:a></li>
			<li><s:a theme="simple"
					action="travelNoteFirstPage_pagePublicTime" namespace="/">
            最新
        </s:a></li>
			<div class="line"></div>
			<li class="hot_icon"></li>
			<li id="btn_pub"><a
				href="<c:url value="/noteeditor/jsp/editor.jsp"/>" style="">发表游记</a></li>
		</ul>
		<div class="content clearfix">
			<div class="hot clearfix">
				<div class="hot-center clearfix">
					<div class="hot-main-s clearfix">
						<s:iterator value="isTopList">
							<div class="hot-main-square clearfix">
								<div class="hot-main-up">
									<s:a action="travelNoteThirdPage_loadTravelNote" namespace="/"
										theme="simple">
										<s:param name="travelNoteId" value="travelNoteId" />
										<img
											src='<c:url value="/travelNoteFiles/${travelNoteRealName}"/>'
											width="325" height="192">
									</s:a>
								</div>
								<div class="hot-main-middle">
									<p class="note-title">
										<s:a action="travelNoteThirdPage_loadTravelNote" namespace="/"
											theme="simple">
											<s:param name="travelNoteId" value="travelNoteId" />
											<s:property value="travelNoteName" />
										</s:a>
									</p>
								</div>
								<div class="hot-main-down">
									<p>
										作者： <span><s:property value="travelNoteAuthor" /></span> <span
											class="reader-info"> <span><s:property
													value="publicTime" /></span>
										</span>
									</p>
								</div>
							</div>
						</s:iterator>

					</div>
				</div>

				<div class="pages">
					<ul class="active" id="yw0">
						<s:url action="travelNoteFirstPage_pageIsTop" namespace="/"
							id="firstPage">
							<s:param name="pageNum">1</s:param>
						</s:url>
						<s:a href="%{firstPage}"
							cssClass="ui_page_item ui_page_item_current">首页</s:a>
						<s:url action="travelNoteFirstPage_pageIsTop" namespace="/"
							id="prePage">
							<s:param name="pageNum">
								<s:property value="pageNum-1" />
							</s:param>
						</s:url>
						<s:a href="%{prePage}" cssClass="ui_page_item page_turning">上一页</s:a>
						<s:property value="pageNum" />
						/
						<s:property value="totalpage" />
						<s:url action="travelNoteFirstPage_pageIsTop" namespace="/"
							id="nextPage">
							<s:param name="pageNum">
								<s:property value="pageNum+1" />
							</s:param>
						</s:url>
						<s:a href="%{nextPage}" cssClass="ui_page_item page_turning">下一页</s:a>
						<s:url action="travelNoteFirstPage_pageIsTop" namespace="/"
							id="lastPage">
							<s:param name="pageNum">
								<s:property value="totalpage" />
							</s:param>
						</s:url>
						<s:a href="%{lastPage}"
							cssClass="ui_page_item ui_page_item_current">末页</s:a>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../../foot.jsp"%>

	<script type="text/javascript" src="webpage/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$("nav").find("li").eq(4).addClass("nav_active");
		})
	</script>
</body>
</html>