<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<c:url value='/css/Style.css'/>" rel="stylesheet" type="text/css" />
		<script language="javascript" src="<c:url value='/js/public.js'/>"></script>
		<script type="text/javascript">
			function addUser(){
				window.location.href = "<c:url value='/mngsystem/admin_add.jsp'/>";
			}
		</script>
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
		<br>
		<span style="color:#ff0000;font-weight:900;"><s:actionerror/></span>
		<s:form action="admin_pageQuery" namespace="/" theme="simple">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>查 询 条 件</strong>
						</td>
					</tr>
					<tr>
						<td>
							<table cellpadding="0" cellspacing="0" border="0" width="100%">
								<tr>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										管理员编号:
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:textfield name="qadminNumber" size="15"/>
									</td>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										管理员姓名:
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:textfield name="qadminName" size="15"/>
									</td>
								</tr>
								<tr>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										性别:
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:select list="{'男','女'}" name="qadminSex" headerKey="" headerValue="--选择性别--"/>
									</td>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										所属部门:
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:select list="{'信息部','市场部'}" name="qadminDepartment" headerKey="" headerValue="--选择部门--"/>
									</td>
								</tr>
								<tr>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										权限等级:
									</td>
									<td class="ta_01" bgColor="#ffffff" colspan="3">
										<s:select list="{'超级管理员','普通管理员'}" name="qadminRole" headerKey="" headerValue="--选择权限等级--"/>
									</td>
								</tr>
							
								<tr>
									<td width="100" height="22" align="center" bgColor="#f5fafe"
										class="ta_01">
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<font face="宋体" color="red"> &nbsp;</font>
									</td>
									<td align="right" bgColor="#ffffff" class="ta_01">
										<button type="submit" id="search" name="search" value="查询" class="button_view">
											查询
										</button>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="reset" name="reset" value="重置" class="button_view"/>
									</td>
									<td align="right" bgColor="#ffffff" class="ta_01"><br><br></td>
									
								</tr>
							</table>
						</td>

					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>管 理 员 列 表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="&#28155;&#21152;" class="button_add" onclick="addUser()">
								添加新的管理员
							</button>

						</td>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="11%">
										管理员编号
									</td>
									<td align="center" width="10%">
										登录名
									</td>
									<td align="center" width="12%">
										管理员姓名
									</td>
									<td align="center" width="12%">
										所属部门
									</td>
									<td align="center" width="5%">
										性别
									</td>
									<td align="center" width="20%">
										电话
									</td>
									<td align="center" width="8%">
										权限等级
									</td>
									<td align="center" width="8%">
										编辑
									</td>
									
									<td align="center" width="7%">
										查看
									</td>
									<td align="center" width="7%">
										删除
									</td>
								</tr>
								
							</table>
						</td>
					</tr>
					<tr><td align="left">&nbsp;</td></tr>
				</TBODY>
			</table>
		</s:form>
	</body>
</HTML>

