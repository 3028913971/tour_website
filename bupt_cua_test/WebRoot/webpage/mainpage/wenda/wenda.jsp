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
<title>中联航旅游攻略系统</title>
<meta name="keywords" content="旅游问答, 餐饮,交通,住宿,购物,游玩娱乐,出游准备问答">
<meta name="description" content="是为准中的您解答讨论：餐饮,交通,住宿,很多热心旅行家都会为您解答的.">
<link rel="stylesheet" href="webpage/mainpage/wenda/css/main.css">
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

<body id="" class="index1000">
	<%@ include file="../../head.jsp"%>
	<!--main start-->
	<div class="qa-wraper">
		<div class="qa-wrap clearfix">
			<div class="qa-wrap-list">
				<div class="qa-search">
					<form action="wenda_pageQuestion" method="get">
						<div class="search-first" id="searchFirst">
							<input class="qa-search-input " id="pkg_destination_index"
								placeholder="请输入查询问题关键字" type="text" value="" name="quesCont">
						</div>
						<input type="submit" class="qa-search-button qacate"
							id="filterSubmit" value="筛 选">

					</form>

				</div>


				<div class="qa-main J-QAList">
					<!--tab S-->
					<div class="qa-main-tab">
						<a class="qa-tab tab-select">所有问题</a>
						<!-- <a class="qa-tab" href="http://ask.tuniu.com/d1/p1/">最新问题</a> -->


					</div>
					<!--tab E-->
					<!--所有问题 S-->
					<div class="qa-main-content">
						<!--列表1 start-->
						<s:iterator>

							<div class="moudle-list J_MList">
								<div class="moudle-content">

									<div class="moudle-details">
										<p class="moudle-title">
											<a class="qa-cityname"><s:property value="questionName" /></a>
											<a></a>
										</p>

										<p class="moudle-bewrite">
											<s:property value="questionContent" />
										</p>


										<div class="moudle-bottom">
											<div class="moudle-bottom-right">
												<span class="moudle-right-list"><s:property
														value="questionTime" /></span>

											</div>
										</div>
									</div>
									<div class="moudle-border"></div>
								</div>
							</div>
						</s:iterator>

						<!--列表1 end-->

						<div class="pagination">
							<div class="page-bottom">

								<s:url action="wenda_page" namespace="/" id="firstPage">
									<s:param name="pageNum">1</s:param>
								</s:url>
								<s:a href="%{firstPage}" cssClass="start_end">首页</s:a>


								<s:url action="wenda_page" namespace="/" id="prePage">
									<s:param name="pageNum">
										<s:property value="pageNum-1" />
									</s:param>
								</s:url>
								<s:a href="%{prePage}" cssClass="next_prev">上一页</s:a>

								<a><s:property value="pageNum" />/<s:property
										value="totalpage" /> </a>

								<s:url action="wenda_page" namespace="/" id="nextPage">
									<s:param name="pageNum">
										<s:property value="pageNum+1" />
									</s:param>
								</s:url>
								<s:a href="%{nextPage}" cssClass="next_prev">下一页</s:a>


								<s:url action="wenda_page" namespace="/" id="lastPage">
									<s:param name="pageNum">
										<s:property value="totalpage" />
									</s:param>
								</s:url>
								<s:a href="%{lastPage}" cssClass="start_end">末页</s:a>
							</div>
						</div>
					</div>
					<!--所有问题 E-->
				</div>
			</div>
		</div>

		<!-- foot start-->
		<%@ include file="../../foot.jsp"%>
		<!-- foot end-->


		<script src="webpage/js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript">
			$(function() {
				$("nav").find("li").eq(5).addClass("nav_active");
			})
		</script>
</body>
</html>
