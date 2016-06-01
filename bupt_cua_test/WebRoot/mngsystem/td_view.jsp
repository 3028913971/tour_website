<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="<c:url value='/css/Style.css'/>" type="text/css" rel="stylesheet">
		<script language="javascript" src="<c:url value='/js/public.js'/>"></script>
	</HEAD>
	<body>
		<form id="userAction_save_do" name="Form1" action="<c:url value='/user/userAction_save.do'/>" method="post" enctype="multipart/form-data">
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>查看旅游地信息</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						旅游地名称:
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:property value="cityName"/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						所属省份:
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:property value="province"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						所属区域:
					</td>				
					<td class="ta_01" bgColor="#ffffff" >
						<s:property value="area"/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						热门季节:
					</td>

					<td class="ta_01" bgColor="#ffffff">
						<s:property value="topSeason"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						主题类型:
					</td>				
					<td class="ta_01" bgColor="#ffffff" >
						<s:property value="themeType"/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						主题类型昵称:
					</td>	
					<td class="ta_01" bgColor="#ffffff" >
						<s:property value="themeNickname"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						国内或国外:
					</td>	
					<td class="ta_01" bgColor="#ffffff" >
						<s:property value="homeOrAbroad"/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						是否为首页热门季节推荐:
					</td>	
					<td class="ta_01" bgColor="#ffffff">
						<s:property value="isHomeTopSeason"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						是否为首页热门主题目的地推荐：
					</td>	
					<td class="ta_01" bgColor="#ffffff">
						<s:property value="isHomeThemeType"/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						是否为热门季节推荐:
					</td>	
					<td class="ta_01" bgColor="#ffffff">
						<s:property value="isTopSeason"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						是否为热门主题目的地推荐：
					</td>	
					<td class="ta_01" bgColor="#ffffff">
						<s:property value="isThemeType"/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						 
						是否发布：
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:property value="isPublic"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						旅游地概述:
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:property value="description"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						旅游地封面图片:
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:property value="cityPhotoFileName"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						旅游地交通描述:
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:property value="trafficDescription"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						旅游地交通图片:
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:property value="trafficPhotoFileName"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						旅游地景点:
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:property value="spotDescription"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						旅游地景点图片:
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:property value="spotPhotoFileName"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						旅游地购物描述:
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:property value="shoppingDescription"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						旅游地购物图片:
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:property value="shoppingPhotoFileName"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						旅游地美食描述:
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:property value="foodDescription"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						旅游地美食图片:
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:property value="foodPhotoFileName"/>
					</td>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG></STRONG>
						</strong>
					</td>
				</tr>				


				<TR>
					<td class="ta_01" style="WIDTH: 100%" align="center" bgColor="#f5fafe" colSpan="4">
						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
						<span id="Label1"></span>
					</td>
				</TR>
			</table>
		</form>
	</body>
</HTML>