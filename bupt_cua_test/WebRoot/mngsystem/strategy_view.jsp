<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="<c:url value='/css/Style.css'/>" type="text/css" rel="stylesheet">
		<script language="javascript" src="<c:url value='/js/public.js'/>"></script>
	</HEAD>
		<body>
			<style type="text/css">
			.nav{
				width:100%;
				height:30px;
				background-color: gray;
				
			}
			.nav ul{
				margin:0 auto;
				background-color: #E2E2E2;
			}
			.nav li{
				float:left;
				margin-left:30px;
				line-height: 30px;
				list-style: none;
				padding-left:10px;
				padding-right:10px;
			}
			.nav li:hover{
				background-color: white;
			}
			
			.clear_fix:before, .clear_fix:after {
	   			 clear: both;
	   			 content: "";
	    		display: block;
			}
			
			.active{
				background-color: white;
			}
		</style>
		<div class="nav">
			<ul class="clear_fix">
				<li>
					<a href="<s:url action="td_page" namespace="/"/>">修改旅游地信息</a>
				</li>
				<li>
					<s:a action="td_findAllForEditOrder" namespace="/">修改旅游地顺序</s:a>
				</li>
				<li class="active">
					<a href="<s:url action="strategyFile_page" namespace="/"/>">修改攻略文件信息</a>
				</li>
				<li> 
					<a href="<s:url action="theme_findAll" namespace="/"/>">修改主题信息</a>
				</li>
			</ul>
		</div>
		<br>
		<s:form action="strategyFile_view" namespace="/" theme="simple" enctype="multipart/form-data">
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>查 看 攻 略 文 件 信 息</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						城市名：
					</td>
					<td class="ta_01" bgColor="#ffffff" >
						<s:property value="cityName"/>
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						是否热门：
					</td>
					<td class="ta_01" bgColor="#ffffff" >
						<s:property value="isTop"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						攻略文件PDF名称:
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:property value="strategyFileName"/>
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						攻略文件JPG名称:
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:property value="strategyJpgName"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						攻略图片名称：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:property value="strategyPhotoFileName"/>
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						攻略下载次数：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:property value="amountOfDownload"/>
					</td>
				</tr>
				<tr>						
					<td align="center" bgColor="#f5fafe" class="ta_01">
						攻略更新时间：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:property value="updateTime"/>
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
		</s:form>
	</body>
</HTML>