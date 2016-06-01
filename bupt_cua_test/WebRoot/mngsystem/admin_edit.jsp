<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="<c:url value='/css/Style.css'/>" type="text/css" rel="stylesheet">
		<script language="javascript" src="<c:url value='/js/public.js'/>"></script>
		<script language="javascript" src="<c:url value='/js/check.js'/>"></script>
		<!-- 日期插件，使用jquery -->
		<script type="text/javascript" src="<c:url value='/jquery/jquery-1.4.2.js'/>"></script>
		<link rel="stylesheet" href="<c:url value='/jquery/jquery.datepick.css'/>" type="text/css">
		<script type="text/javascript" src="<c:url value='/jquery/jquery.datepick.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/jquery/jquery.datepick-zh-CN.js'/>"></script>
	</HEAD>
	<script type="text/javascript">
		$(document).ready(function(){
			//使用class属性处理  'yy-mm-dd' 设置格式"yyyy/mm/dd"
			$('#birthday').datepick({dateFormat: 'yy-mm-dd'}); 
		});
	</script>
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
		<s:form action="admin_edit" namespace="/" theme="simple" onsubmit="return CheckAdminForm();">
			<s:hidden name="adminId" value="%{adminId}"/>
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>编辑管理员信息</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						管理员编号：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:textfield name="adminNumber" id="adminNumber" onblur="CheckNullAndLengthAndCharacter('adminNumber','管理员编号','adminNumberError')"/>
				 		<span style="color:#ff0000;font-weight:900;"id="adminNumberError"></span>
				 		<span style="color:#ff0000;"><s:fielderror fieldName="adminNumberError" /></span>	
					</td>
					<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
						登录名:
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:textfield name="loginName" size="15" id="loginName" onblur="CheckNullAndLengthAndCharacter('loginName','登录名','loginNameError')"/>
						<span style="color:#ff0000;font-weight:900;"id="loginNameError"></span>
						<span style="color:#ff0000;"><s:fielderror fieldName="loginNameError"/></span>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						 密码：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:password name="adminPassword" showPassword="true" id="adminPassword" onblur="CheckNullAndLengthAndCharacter('adminPassword','密码','adminPasswordError')"/>
						<span style="color:#ff0000;font-weight:900;"id="adminPasswordError"></span>
					</td>
					<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
						管理员姓名:
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:textfield name="adminName" size="15" id="adminName" onblur="CheckName('adminName','姓名','adminNameError')"/>
						<span style="color:#ff0000;font-weight:900;"id="adminNameError"></span>
					</td>
					
				</tr>
				<tr>
					<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
						所属部门:
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:select list="{'信息部','市场部'}" name="adminDepartment" id="adminDepartment" headerKey="" headerValue="--选择部门--" onchange="CheckNull('adminDepartment','所属部门','adminDepartmentError')"/>
						<span style="color:#ff0000;font-weight:900;"id="adminDepartmentError"></span>
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						性别：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:radio list="{'男','女'}" name="adminSex" id="adminSex" onblur="CheckRadios('adminSex','性别','adminSexError')"/>
						<span style="color:#ff0000;font-weight:900;"id="adminSexError"></span>
					</td>					
				</tr>
				<tr>
					<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
						电话:
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:textfield name="adminPhoneNumber" id="adminPhoneNumber" size="20" onblur="CheckCellphone('adminPhoneNumber','手机号','adminPhoneNumberError')"/>
						<span style="color:#ff0000;font-weight:900;"id="adminPhoneNumberError"></span>
					</td>
					<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
						权限等级:
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:select list="{'超级管理员','普通管理员'}" name="adminRole" id="adminRole" headerKey="" headerValue="--选择权限等级--" onchange="CheckNull('adminRole','权限等级','adminRoleError')"/>
						<span style="color:#ff0000;font-weight:900;"id="adminRoleError"></span>
					</td>
				</tr>
				<tr>
					<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
						邮箱:
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:textfield name="adminMail" size="20" id="adminMail" onblur="CheckMail('adminMail','adminMailError')"/>
						<span style="color:#ff0000;font-weight:900;"id="adminMailError"></span>
					</td>
				</tr>
				<tr>
					<td height="22" align="center" bgColor="#f5fafe" class="ta_01" colspan="4">
						<span style="color:#ff0000;font-weight:900;"><!-- <s:actionerror/> --></span>	
					</td>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG></STRONG>
						</strong>
					</td>
				</tr>
				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<button type="submit" id="userAction_save_do_submit" name="submit" value="&#30830;&#23450;" class="button_ok">
							&#30830;&#23450;
						</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="&#37325;&#32622;" class="button_cancel">&#37325;&#32622;</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
		</s:form>&quot;
	</body>
</HTML>