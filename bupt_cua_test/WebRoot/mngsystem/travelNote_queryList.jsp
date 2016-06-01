<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="Content-Language" content="zh-cn">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="<c:url value='/css/Style.css'/>" rel="stylesheet" type="text/css" />
	<script language="javascript" src="<c:url value='/js/public.js'/>"></script>
  </head>
  
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
					<a href="">修改游记信息</a>
				</li>
			</ul>
		</div>
		<br>
		<s:form action="travelNote_queryPage" namespace="/" theme="simple">
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
									<td width="18%" height="22" align="center" bgColor="#f5fafe" class="ta_01" >
										游记名称:
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:textfield name="tnName" />
									</td>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01" >
										审核状态：
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:select headerKey="" headerValue="全部" list="{'审核通过','未审核'}" name="tnStatus"/>
									</td>
								
									
								</tr>
								<tr>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01" >
										是否上首页:
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:select headerKey="" headerValue="==请选择==" list="{'是','否'}" name="tnIsTop" />
									</td>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01" >
										游玩城市：
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:textfield name="tnCityName"/>
									</td>
								</tr>
								<tr>
									<td height="22" align="center" bgColor="#f5fafe"
										class="ta_01">
										&nbsp;
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<font face="宋体" color="red"> &nbsp;</font>
									</td>
									<td align="center" bgColor="#ffffff" class="ta_01">
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
							<strong>游记 列 表</strong>
						</TD>
					</tr>
					

					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="5%">
										游记编号
									</td>
									<td align="center" width="20%">
										游记名称
									</td>
									<td align="center" width="5%">
										游记作者
									</td>
									<td align="center" width="25%">
										审核状态
									</td>
									<td align="center" width="10%">
										发表时间
									</td>
									<td align="center" width="10%">
										是否上首页
									</td>
									<td align="center" width="10%">
										游玩城市
									</td>
									<td align="center" width="5%">
										编辑
									</td>
									<td align="center" width="5%">
										查看
									</td>
									<td align="center" width="5%">
										删除
									</td>
								</tr>
								<s:iterator>						
									<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
										<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="5%">
											<s:property value="travelNoteId"/>
										</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="20%">
											<s:property value="travelNoteName"/>
										</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="5%">
											<s:property value="travelNoteAuthor"/>
										</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="25%">
											<s:property value="status"/>
										</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="10%">
											<s:property value="publicTime"/>
										</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="10%">
											<s:property value="isTop"/>
										</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="10%">
											<s:property value="cityName"/>
										</td>
										<td align="center" style="HEIGHT: 22px">
											<s:a action="travelNote_loadForEdit" namespace="/">
												<s:param name="travelNoteId" value="travelNoteId"/>
												<img src="<c:url value='/images/i_edit.gif'/>" border="0" style="CURSOR: hand">
											</s:a>
										</td>
										<td align="center" style="HEIGHT: 22px">
											<s:a action="travelNote_view" namespace="/">
												<s:param name="travelNoteId" value="travelNoteId"/>
												<img src="<c:url value='/images/button_view.gif'/>" border="0" style="CURSOR: hand">
											</s:a>
										</td>
										<td align="center" style="HEIGHT: 22px" onclick="return confirm('您是否确定删除该记录？')">
											<s:a action="travelNote_delete" namespace="/">
												<s:param name="travelNoteId" value="travelNoteId"/>
												<img src="<c:url value='/images/i_del.gif'/>" border="0" style="CURSOR: hand">
											</s:a>
										</td>
									</tr>
								</s:iterator>
							</table>
						</td>
					</tr>
					<tr>
						<td align="center">
							
							<!-- 首页链接设置 -->
							<s:url action="travelNote_queryPage1" namespace="/" id="firstPage">
								<s:param name="pageNum">1</s:param>
								<s:param name="tnName" value="tnName"/>
								<s:param name="tnStatus" value="tnStatus"/>
								<s:param name="tnIsTop" value="tnIsTop"/>
								<s:param name="tnCityName" value="tnCityName"/>
							</s:url>
							<s:a href="%{firstPage}" cssStyle="color:blue">[首页]</s:a>
							
							<!-- 上一页链接设置 -->
							<s:url action="travelNote_queryPage1" namespace="/" id="prePage">
								<s:param name="pageNum">
									<s:property value="pageNum-1"/>
								</s:param>
								<s:param name="tnName" value="tnName"/>
								<s:param name="tnStatus" value="tnStatus"/>
								<s:param name="tnIsTop" value="tnIsTop"/>
								<s:param name="tnCityName" value="tnCityName"/>
							</s:url>
							<s:a href="%{prePage}" cssStyle="color:blue">[上一页]</s:a>
							
							<!-- 显示当前页数/总页数 -->
							<s:property value="pageNum"/>/<s:property value="totalPage"/>
							
							<!-- 下一页链接设置 -->
							<s:url action="travelNote_queryPage1" namespace="/" id="nextPage">
								<s:param name="pageNum">
									<s:property value="pageNum+1"/>
								</s:param>
								<s:param name="tnName" value="tnName"/>
								<s:param name="tnStatus" value="tnStatus"/>
								<s:param name="tnIsTop" value="tnIsTop"/>
								<s:param name="tnCityName" value="tnCityName"/>
							</s:url>
							<s:a href="%{nextPage}" cssStyle="color:blue">[下一页]</s:a>
							
							<!-- 尾页链接设置 -->
							<s:url action="travelNote_queryPage1" namespace="/" id="lastPage">
								<s:param name="pageNum">
									<s:property value="totalPage"/>
								</s:param>
								<s:param name="tnName" value="tnName"/>
								<s:param name="tnStatus" value="tnStatus"/>
								<s:param name="tnIsTop" value="tnIsTop"/>
								<s:param name="tnCityName" value="tnCityName"/>
							</s:url>
							<s:a href="%{lastPage}" cssStyle="color:blue">[末页]</s:a>
							
						</td>
					</tr>
				</TBODY>
			</table>
		</s:form>
  </body>
</html>
