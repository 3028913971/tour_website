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
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:wb="http://open.weibo.com/wb" mode="normal">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-transform">
<title>旅游攻略系统</title>
<meta name="keywords" content="联航旅游，旅游产品，实惠旅游">
<meta name="description" content="联航旅游：提供的特价预订获得更多的打折促销优惠。">

<link rel="stylesheet" href="webpage/mainpage/chanpin/css/main.css"/>
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
	<!--面包屑-->
	<ul id="breadcrumbs-four">
		<li><a
			href="<s:url action="productPage_pageIsTop" namespace="/"/>">产品首页&gt;&gt;</a></li>
		<li><a class="current"><s:property value="city.cityName" /></a></li>
	</ul>
	<!-- 面包屑end-->
	<div class="focus">
		<div>
			<img
				src='<c:url value="/tdDescriptionPhotos/${city.cityPhotoRealName}"/>'
				alt="" width="980" height="400" />
		</div>
		<div class="wrap_city">
			<div class="city_detail">

				<p class="desc_city">
					<s:property value="city.description" />
				</p>
			</div>
			<h1 class="title">
				<s:property value="city.cityName" />
			</h1>
		</div>
	</div>
	<!--页头结束-->
	<div class="qyWrap">
		<div class="lm-index-sort-wrap clearfix">
			<ul class="lmsifts qyer-sort">
				<li><s:a action="productCityPage_pageIsTop1" namespace="/"
						theme="simple" style="border-right: 1px solid gray;">
            	热门推荐
            	<s:param name="cityName" value="city.cityName"></s:param>
					</s:a></li>
				<li id="sort_price" class="active"><s:a
						action="productCityPage_pagePrice" namespace="/" theme="simple">
            		价格排序
            		<s:param name="cityName" value="city.cityName"></s:param>
					</s:a></li>
			</ul>
			<div class="line" style="left: 184px;width: 780px;"></div>
		</div>
		<!-- 排行区域 -->

		<!-- 列表区 -->

		<ul class="lm-index-product-list mt10 clearfix">
			<s:iterator value="priceCityList">
				<li><s:a action="productDescription_loadProduct" namespace="/"
						theme="simple">
						<s:param name="productId" value="productId" />
						<div class="list-surface">
							城市玩乐 |
							<s:property value="cityName" />
						</div>
						<div class="list-tuwen">
							<img src='<c:url value="/productFiles/${productRealName}"/>'
								data-original="http://pic.qyer.com/public/supplier/lastminute/2015/07/29/14381504497218/339x226"
								class="list-photo" style="display: inline;">

							<div class="list-buymask">
								<p class="list-buybtn">
									<span class="buy-btn-text">立即查看</span><i class="buy-btn-ico"></i>
								</p>
							</div>
							<div class="list-wenzi-wrap">
								<h4 title="【9月3日秒杀】台北桃园/松山机场至台北市区包车单程接/送机服务">
									<s:property value="productName" />
								</h4>

								<div class="wenzi-cell clearfix">
									<div class="wenzi-cell-time">
										<p class="cell-traveltime">旅行时间</p>

										<p class="cell-travelmonth">
											<s:property value="startDate" />
											~
											<s:property value="endDate" />
										</p>
									</div>
									<p class="wenzi-cell-price">
										<em><s:property value="productPrice" /></em>元起
									</p>
								</div>
								<div class="hidden-cell"></div>
							</div>
						</div>
					</s:a></li>
			</s:iterator>
		</ul>
		<div class="list-pages">
			<div class="ui_page">
				<s:url action="productCityPage_pagePrice" namespace="/"
					id="firstPage">
					<s:param name="pageNum">1</s:param>
				</s:url>
				<s:a href="%{firstPage}"
					cssClass="ui_page_item ui_page_item_current">首页</s:a>
				<s:url action="productCityPage_pagePrice" namespace="/" id="prePage">
					<s:param name="pageNum">
						<s:property value="pageNum-1" />
					</s:param>
				</s:url>
				<s:a href="%{prePage}" cssClass="ui_page_item">上一页</s:a>
				<s:property value="pageNum" />
				/
				<s:property value="totalpage" />
				<s:url action="productCityPage_pagePrice" namespace="/"
					id="nextPage">
					<s:param name="pageNum">
						<s:property value="pageNum+1" />
					</s:param>
				</s:url>
				<s:a href="%{nextPage}" cssClass="ui_page_item">下一页</s:a>
				<s:url action="productCityPage_pagePrice" namespace="/"
					id="lastPage">
					<s:param name="pageNum">
						<s:property value="totalpage" />
					</s:param>
				</s:url>
				<s:a href="%{lastPage}" cssClass="ui_page_item ui_page_item_current">末页</s:a>
			</div>
		</div>


	</div>



	<%@ include file="../../foot.jsp"%>
	<script src="webpage/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$("nav").find("li").eq(2).addClass("nav_active");
		})
	</script>
</body>
</html>