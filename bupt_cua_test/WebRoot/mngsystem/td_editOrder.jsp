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
			function addTd(){
				window.location.href = "<s:url action="td_loadForAdd" namespace="/"/>";
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
				<li class="active">
					<s:a action="td_findAllForEditOrder" namespace="/">修改旅游地顺序</s:a>
				</li>
				<li>
					<a href="<s:url action="strategyFile_page" namespace="/"/>">修改攻略文件信息</a>
				</li>
				<li> 
					<a href="<s:url action="theme_findAll" namespace="/"/>">修改主题信息</a>
				</li>
			</ul>
		</div>
		<br>
		<span style="color:#ff0000;font-weight:900;"><s:actionerror/></span>
		<s:form action="td_pageQuery" namespace="/" theme="simple" >
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>旅 游 地 列 表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="20%">
										旅游地名称
									</td>
									<td align="center" width="20%">
										所属省份
									</td>
									<td align="center" width="15%">
										所属区域
									</td>
									<td align="center" width="15%">
										当前顺序
									</td>
									<td align="center" width="15%" >
										上移
									</td>
									<td align="center" width="15%">
										下移
									</td>
								</tr>	
								<s:iterator value="top">							
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="20%">
										<s:property value="cityName"/>
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="20%">
										<s:property value="province"/>
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="15%">
										<s:property value="area"/>
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="15%">
										<s:property value="tdOrder"/>
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center">
											<s:a action="td_forwardOrder" namespace="/">
												<s:param name="cityName" value="cityName"/>
												<s:param name="tdOrder" value="tdOrder"/>
												<img  src="<c:url value='/images/forward.jpg'/>" border="0" style="CURSOR: hand">
											</s:a>
										</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center">
											<s:a action="td_backwardOrder" namespace="/">
												<s:param name="cityName" value="cityName"/>
												<s:param name="tdOrder" value="tdOrder"/>
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
</HTML>

