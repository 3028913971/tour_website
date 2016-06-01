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
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>中联航旅游攻略系统</title>
<meta content="旅游，攻略，游记" name="keywords">
<meta content="" name="description">

<link rel="stylesheet" type="text/css"
	href="webpage/mainpage/youji2/css/gonglue-center.css">
<link href="webpage/mainpage/youji2/css/main.css" rel="stylesheet">
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
	<!--面包屑-->
	<ul id="breadcrumbs-four">
		<li><a
			href="<s:url action="travelNoteFirstPage_findAllIsTop.action" namespace="/"/>">游记首页&gt;&gt;</a></li>
		<li><a class="current"><s:property value="cityName" /></a></li>
	</ul>
	<!-- 面包屑end-->

	<!-- print main content -->
	<div id="niuren_list" class="bodybg clearfix">

		<div class="wrap mainbody clearfix">
			<div class="fl clearfix main-content">
				<div class="partbox">
					<div class="topTit clearfix">
						<h1>
							<s:property value="city.cityName" />
							游记
						</h1>
						<%--<a href="<c:url value="/kindeditor/jsp/demo.jsp"/>" class="btn" rel="nofollow">发表游记</a>--%>
					</div>

					<div id="gonglueBox" class="gonglue_box">
						<ul class="btn clear_fix">
							<li style="border-right: 1px solid gray;"><s:a
									action="travelNoteSecondPage_pageIsTop1" namespace="/"
									theme="simple">
                                热门
                                <s:param name="cityName"
										value="city.cityName"></s:param>
								</s:a></li>
							<li><s:a cssClass="active"
									action="travelNoteSecondPage_pagePublicTime" namespace="/"
									theme="simple">
                                最新
                                <s:param name="cityName"
										value="city.cityName"></s:param>
								</s:a></li>
							<div class="line"></div>
							<a href="<c:url value="/kindeditor/jsp/demo.jsp"/>">
								<li class="hot_icon"></li>
								<li id="btn_pub"><a
									href="<c:url value="/noteeditor/jsp/editor.jsp"/>">发表游记</a></li>
							</a>
						</ul>
						<div id="pic_con" class="pic_con">
							<div class="pic_item">
								<s:iterator value="publishTimeList">
									<div class="pic_list clearfix">
										<div class="pic">
											<s:a action="travelNoteThirdPage_loadTravelNote"
												namespace="/" theme="simple">
												<s:param name="travelNoteId" value="travelNoteId" />
												<img width="240" height="135"
													src='<c:url value="/travelNoteFiles/${travelNoteRealName}"/>'
													style="display: inline;">
											</s:a>

											<!-- <div class="pic_icon icon_tuijian"></div> -->
										</div>
										<div class="des">
											<h3 class="note_title">
												<s:a action="travelNoteThirdPage_loadTravelNote"
													namespace="/" theme="simple">
													<s:param name="travelNoteId" value="travelNoteId" />
													<s:property value="travelNoteName" />
												</s:a>
											</h3>

											<p class="auther">
												<span>作者：<s:property value="travelNoteAuthor" /></span><span>发表于：<s:property
														value="publicTime" /></span>
											</p>

											<!--   <p class="mainmes">
                                              没东西啊
                                          </p> -->


										</div>
									</div>
								</s:iterator>

								<!--start pageration-->
								<div class="pagination">
									<div class="page-bottom">
										<s:url action="travelNoteSecondPage_pagePublicTime"
											namespace="/" id="firstPage">
											<s:param name="pageNum">1</s:param>
											<s:param name="cityName" value="cityName" />
										</s:url>
										<s:a theme="simple" href="%{firstPage}"
											cssClass="ui_page_item ui_page_item_current">首页</s:a>
										<s:url action="travelNoteSecondPage_pagePublicTime"
											namespace="/" id="prePage">
											<s:param name="pageNum">
												<s:property value="pageNum-1" />
											</s:param>
											<s:param name="cityName" value="cityName" />
										</s:url>
										<s:a theme="simple" href="%{prePage}" cssClass="ui_page_item">上一页</s:a>
										<span class="page-cur"><s:property value="pageNum" />/<s:property
												value="totalpage" /></span>
										<s:url action="travelNoteSecondPage_pagePublicTime"
											namespace="/" id="nextPage">
											<s:param name="pageNum">
												<s:property value="pageNum+1" />
											</s:param>
											<s:param name="cityName" value="cityName" />
										</s:url>
										<s:a theme="simple" href="%{nextPage}" cssClass="ui_page_item">下一页</s:a>
										<s:url action="travelNoteSecondPage_pagePublicTime"
											namespace="/" id="lastPage">
											<s:param name="pageNum">
												<s:property value="totalpage" />
											</s:param>
											<s:param name="cityName" value="cityName" />
										</s:url>
										<s:a theme="simple" href="%{lastPage}"
											cssClass="ui_page_item ui_page_item_current">末页</s:a>

									</div>
								</div>
								<!--end pageration-->
							</div>

						</div>
					</div>


				</div>


			</div>
			<!--  <div class="fr clearfix side-content" >
             周边目的地start
             <div class="block mod-around hot_line2 hot_pic_list" style="height: 800px;">
                 <h3 class="spe">
                     这里是广告。。。
                     <a href="" class="more">更多&gt;</a>
                 </h3>

                 <div class="clearfix">
                 </div>
             </div>
             周边目的地end
         </div> -->
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