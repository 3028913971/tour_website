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
					<a href="">修改产品信息</a>
				</li>
			</ul>
		</div>
		<br>
		<s:form action="product_view" namespace="/" theme="simple" enctype="multipart/form-data">
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>查 看 产 品 信 息</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						产品编号：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:property value="model.productId"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						游玩城市：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:property value="model.cityName"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						产品名称：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:property value="model.productName"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						产品描述：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:property value="model.productDescription"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						产品特色：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:property value="model.productFeature"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						产品价格：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:property value="model.productPrice" />
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						费用说明：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:property value="model.costDescription"/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						联系电话：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:property value="model.productCellphone"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						开始日期：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:property value="model.startDate"/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						结束日期：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:property value="model.endDate"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						产品文件名称：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:property value="model.productFileName"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						是否热门：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:property value="model.isTop"/>
					</td>
					
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						是否发布：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:property value="model.isPublic"/>
					</td>
					
				</tr>
				
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG></STRONG>
						</strong>
					</td>
				</tr>
			</table>
			&nbsp;
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>行 程 列 表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="16%">
										行程编号
									</td>
									<td align="center" width="16%">
										行程第几天
									</td>
									<td align="center" width="18%">
										行程名称
									</td>
									<td align="center" width="34%">
										行程描述
									</td>
									<td align="center" width="16%">
										行程文件名
									</td>
								</tr>
								<s:iterator>						
									<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
										<td style="CURSOR: hand; HEIGHT: 22px" align="center">
											<s:property value="journeyId"/>
										</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center">
											<s:property value="journeyDayNumber"/>
										</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center">
											<s:property value="journeyTitle"/>
										</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center">
											<s:property value="journeyDescription"/>
										</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center">
											<s:property value="journeyFileName"/>
										</td>
									</tr>
								</s:iterator>
							</table>
						</td>
					</tr>
				</TBODY>
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