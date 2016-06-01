<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>页面找不到</title>
<meta charset="UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="联航,404">
<meta http-equiv="description" content="联航,错误页面,联航旅游">
<link rel="stylesheet" href="webpage/css/eric-meyer-reset.min.css" />
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
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>

/*导航菜单end*/
.info {
	margin: 100px auto;
	width: 800px;
	text-align: center;
	height: auto;
}

.info h1 {
	font-size: 26pt;
	font-family: "microsoft yahei";
	color: rgba(14, 14, 14, 0.68)
}

.info img {
	position: relative;
	left: -250px
}
</style>
</head>

<body>
	<div class="info">
		<!--<img src="webpage/images/error.jpg" width="200" height="200"/> -->
		<h1>很抱歉，你要查找的网页找不到。>_<</h1>
	</div>
</body>
</html>
