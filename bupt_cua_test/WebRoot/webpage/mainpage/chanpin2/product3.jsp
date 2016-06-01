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
<meta content="all" name="robots">
<meta name="robots" content="index,follow">
<meta name="keywords" content="旅游产品">
<title>旅游攻略系统</title>
<link charset="utf-8" type="text/css" rel="stylesheet"
	href="webpage/mainpage/chanpin2/css/detail.css">
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
			href="<s:url action="productPage_pageIsTop.action" namespace="/"/>">产品首页&gt;&gt;</a></li>
		<li><s:a action="productCityPage_pageIsTop.action" namespace="/">
				<s:property value="cityName" />产品
    	<s:param name="cityName" value="cityName"></s:param>
        &gt;&gt; </s:a></li>
		<li><a class="current"><s:property value="cityName" /></a></li>
	</ul>
	<!-- 面包屑end-->
	<!--页头结束-->
	<div class="ipad_v1">
		<div class="bg_miancolor">
			<div class="vacation_bd">
				<!--基本信息-->
				<div class="detail_main_wrap basefix">
					<div class="detail_main_title">
						<h1>
							<s:property value="productName" />
							<!-- <div class="tips">
                            <span class="icon_red">热门产品</span>
                        </div> -->
						</h1>
					</div>
					<!--图片信息-->
					<div class="main_left">
						<div id="js_photoviewer" class="attraction_photo_wrap">
							<div id="js-preview-photo" class="attraction_photo_big"
								data-id="">
								<img src='<c:url value="/productFiles/${productRealName}"/>'
									alt="万丽酒店-外景" height="280px" width="500px">
								<div class="photo_name">
									<p>
										<s:property value="productName" />
									</p>
								</div>
							</div>
						</div>
					</div>
					<div class="main_right mice_in_bottom">
						<div class="main_price_wrap basefix">
							<!--起价说明-->
							<div class="main_price_wrap_left">
								<strong class="total_price" id="js-product-min-price">
									<dfn>￥</dfn> <s:property value="productPrice" /><em>元</em>
								</strong> <span class="favorable_tips" id="js-product-min-price-remark">
								</span>
							</div>
						</div>
						<div class="product_scroll_wrap">
							<!--支付方式-->
							<dl>
								<dt>产品销售热线：</dt>
								<dd>
									<s:property value="productCellphone" />
								</dd>
							</dl>

							<dl>
								<dt>销售起始时间：</dt>
								<dd>
									<s:property value="startDate" />
									~
									<s:property value="endDate" />
								</dd>
							</dl>
							<dl>
								<dt>产品描述：</dt>
								<dd>
									<s:property value="productDescription" />
								</dd>
							</dl>
						</div>
					</div>
				</div>
				<div class="new_detail_content">
					<ul>
						<li class="active">产品详情</li>
						<li>相关评论</li>
					</ul>
				</div>
				<div class="under_tab_detail">
					<!--推荐玩法-->
					<div class="" id="divTourSchedule">
						<!--推荐玩法-->
						<div class="detail_content first_detail_content">
							<!--行程-->
							<h3 class="resource_title">
								行&nbsp;&nbsp;程 <i class="icon_b icon_b_03"></i>
							</h3>
							<!--    <div class="route_tab basefix">
                            <a href="javascript:void(0);" class="tab_li current">行程<b></b></a>
                        </div> -->

							<ul class="journey_list basefix" id="js_detail_travelCtrip">
								<s:iterator value="journeyList">
									<li><a id="day2"
										style="margin-top: -100px;
                                position: absolute;">&nbsp;</a>
										<div class="journey_title">
											<h5 class="time_list">
												第
												<s:property value="journeyDayNumber" />
												天
											</h5>
											<i class="icon_b icon_b_day">D<s:property
													value="journeyDayNumber" /></i>
											<h4>
												<s:property value="journeyTitle" />
											</h4>
										</div>
										<div class="journey_detail">
											<i class="icon_s icon_s_scene"></i>
											<dl>
												<dd>
													<div class="js_simple_no_show">
														<p>
															<s:property value="journeyDescription" />
														</p>
														<div class="journey_pic">
															<img title="天涯海角"
																src='<c:url value="/journeyFiles/${journeyRealName}"/>'
																height="105px" width="186px">
														</div>
													</div>
												</dd>
											</dl>
										</div></li>
								</s:iterator>


								<li class="journey_end">
									<div class="journey_detail border_none">
										<i class="icon_s icon_s_end"></i>

										<p>以上行程时间安排可能会因天气、路况等原因做相应调整，敬请谅解。</p>
									</div>
								</li>
							</ul>

						</div>

					</div>
					<!--费用-->

					<div class="detail_content">
						<i id="fy" class="under_tab_anchor"></i>

						<h3 class="resource_title">
							产品特色 <i class="icon_b icon_b_04"></i>
						</h3>
						<dl class="detail_date">
							<dt>产品特色</dt>
							<dd>
								<!-- <ul class="num_list">
                                <li>全程往返机票，包含机票税及燃油附加费。</li>
                                <li>当地酒店住宿费用。</li>
                            </ul> -->
								<s:property value="productFeature" />
							</dd>
						</dl>
					</div>

					<div class="detail_content">
						<i id="fy" class="under_tab_anchor"></i>

						<h3 class="resource_title">
							费&nbsp;&nbsp;用 <i class="icon_b icon_b_03"></i>
						</h3>
						<dl class="detail_date">
							<dt>费用包含</dt>
							<dd>
								<!-- <ul class="num_list">
                                <li>全程往返机票，包含机票税及燃油附加费。</li>
                                <li>当地酒店住宿费用。</li>
                            </ul> -->
								<s:property value="costDescription" />
							</dd>
						</dl>
					</div>


					<!--预订须知-->

					<div class="detail_content">
						<i id="ydxz" class="under_tab_anchor"></i>
						<h3 class="resource_title">
							预订须知 <i class="icon_b icon_b_06"></i>
						</h3>
						<dl class="detail_date">
							<dt>出行警示及说明</dt>
							<dd>
								<ul class="num_list">
									<li>为普及旅游安全知识及旅游文明公约，使您的旅程顺利圆满完成，特制定 <a rel="nofollow"
										href="http://www.flycua.com/guide2/xqfw/lkxz/4680/index.html"> 《联航旅游须知》 </a> ，请您认真阅读并切实遵守。
									</li>
									<li>请您携带身份证等有效证件和产 品确认单，建议您携带游泳衣、防晒 霜、晴雨伞、沙滩鞋、创可贴、雨衣、
										常备药品等物品出行。</li>
								</ul>
							</dd>
						</dl>

						<dl class="detail_date border_none">
							<dt>安全指南</dt>
							<dd>
								<p>旅游安全是旅游的生命线， 为保障游客“住得安心、吃得放心、 玩的舒心”，联航从出行常识、旅游
									活动和特殊人群三方面为您提供旅游安 全指南。出行前，提醒您仔细阅读相关 内容，重视旅游安全，使您的出游真正成为
									“快乐之游、难忘之游、收获之游”。</p>
							</dd>
						</dl>
					</div>
				</div>
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