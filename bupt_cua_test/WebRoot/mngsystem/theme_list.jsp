<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<c:url value='/css/Style.css'/>" rel="stylesheet" type="text/css" />
		<script language="javascript" src="<c:url value='/js/public.js'/>"></script>
		<script type="text/javascript">
			function addUser(){
				window.location.href = "<c:url value='/mngsystem/theme_add.jsp'/>";
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
				<li>
					<a href="<s:url action="td_page" namespace="/"/>">修改旅游地信息</a>
				</li>
				<li>
					<s:a action="td_findAllForEditOrder" namespace="/">修改旅游地顺序</s:a>
				</li>
				<li>
					<a href="<s:url action="strategyFile_page" namespace="/"/>">修改攻略文件信息</a>
				</li>
				<li class="active"> 
					<a href="<s:url action="theme_findAll" namespace="/"/>">修改主题信息</a>
				</li>		
			</ul>
		</div>
		<br>
		<s:form action="theme_findAll" namespace="/" theme="simple">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>主题信息 列 表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="&#28155;&#21152;" class="button_add" onclick="addUser()">
								添加新的主题
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

									<td align="center" width="20%">
										主题名称
									</td>
									<td align="center" width="20%">
										是否推送首页
									</td>
									<td align="center" width="30%">
										主题图片名称
									</td>
									<td width="15%" align="center">
										编辑
									</td>
									<td width="15%" align="center">
										删除
									</td>
								</tr>
								<s:iterator>
									<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="20%">
												<s:property value="themeName"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="20%">
												<s:property value="themeIsTop"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="30%">
												<s:property value="themeFileName"/>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<s:a action="theme_loadForEdit" namespace="/">
													<s:param name="themeId" value="themeId"/>
													<img src="<c:url value='/images/i_edit.gif'/>" border="0" style="CURSOR: hand">
												</s:a>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<s:a action="theme_delete" namespace="/" onclick="return confirm('您是否真的要删除该记录')">
													<s:param name="themeId" value="themeId"/>
													<s:param name="themeRealName" value="themeRealName"/>
													<img src="<c:url value='/images/i_del.gif'/>" width="16" height="16" border="0" style="CURSOR: hand">
												</s:a>
											</td>
										</tr>
									</s:iterator>
							</table>
						</td>
					</tr>
					<tr><td align="left">&nbsp;</td></tr>
				</TBODY>
			</table>
		</s:form>
	</body>
</HTML>

