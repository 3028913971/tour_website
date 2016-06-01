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
				<li >
					<s:a action="question_page" namespace="/">修改问题信息</s:a>
				</li>
				<li class="active">
					<s:a action="question_findAllForEditOrder" namespace="/">修改问题顺序</s:a>
				</li>
			</ul>
		</div>
		<br>
		<s:form action="question_editOrder" namespace="/" theme="simple">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" bgColor="#ffffff" colspan="3">
							<span style="color:#ff0000;font-weight:900;">
								<s:actionerror/>
							</span>
						</td>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>问题 列 表</strong>
						</TD>
					</tr>
				
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="18%">
										问题编号
									</td>
									<td align="center" width="18%">
										问题名称
									</td>
									<td align="center" width="20%">
										回答内容
									</td>
									<td align="center" width="15%">
										提问时间
									</td>
									<td align="center" width="10%" >
										顺序
									</td>
									<td align="center" width="10%" >
										上移
									</td>
									<td align="center" width="10%">
										下移
									</td>
								</tr>
								<s:iterator status="st">
									<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
										<td style="CURSOR: hand; HEIGHT: 22px" align="center">
											<s:property value="questionId"/>
										</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center">
											<s:property value="questionName"/>
										</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center">
											<s:if test="questionContent.length() >= 100">
												<s:property value="questionContent.substring(0,100)"/>
											</s:if>
											<s:else>
												<s:property value="questionContent"/>
											</s:else>
										</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center">
											<s:property value="questionTime"/>
										</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center">
											<s:property value="questionOrder"/>
										</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center">
											<s:a action="question_forwardOrder" namespace="/">
												<s:param name="questionId" value="questionId"/>
												<s:param name="questionOrder" value="questionOrder"/>
												<img  src="<c:url value='/images/forward.jpg'/>" border="0" style="CURSOR: hand">
											</s:a>
										</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center">
											<s:a action="question_backwardOrder" namespace="/">
												<s:param name="questionId" value="questionId"/>
												<s:param name="questionOrder" value="questionOrder"/>
												<img  src="<c:url value='/images/backward.jpg'/>" border="0" style="CURSOR: hand">
											</s:a>
										</td>
									</tr>
								</s:iterator>
							</table>
						</td>
					</tr>
				</TBODY>
			</table>
		</s:form>
  </body>
</html>