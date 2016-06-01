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
				<li class="active">
					<a href="">修改管理员信息</a>
				</li>
	
			</ul>
		</div>
		<form id="userAction_save_do" name="Form1" action="<c:url value='/user/userAction_save.do'/>" method="post" enctype="multipart/form-data">
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>查看管理员信息</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						管理员编号：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:property value="adminNumber"/>
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						登录名：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:property value="loginName"/>
					</td>
				</tr>
				
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						管理员姓名:
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:property value="adminName"/>
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						性别：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:property value="adminSex"/>
					</td>
					
				</tr>
				<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">
						所属部门：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:property value="adminDepartment"/>
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						邮箱：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:property value="adminMail"/>
					</td>
					
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						电话：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:property value="adminPhoneNumber"/>
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						权限等级：
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						 <s:property value="adminRole"/>
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