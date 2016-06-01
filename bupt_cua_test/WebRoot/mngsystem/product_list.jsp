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

	<script type="text/javascript">
			function addProduct(){
				window.location.href = "<c:url value='/mngsystem/product_add.jsp'/>";
			}
	</script>
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
					<a href="">修改产品信息</a>
				</li>
			</ul>
		</div>
		<br>
		<s:form action="product_queryPage" namespace="/" theme="simple">
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
										产品名称:
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:textfield name="proName" />
									</td>
									<td width="18%" height="22" align="center" bgColor="#f5fafe" class="ta_01" >
										产品描述：
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:textfield name="proDescription"/>
									</td>
								</tr>
								<tr>
									<td width="18%" height="22" align="center" bgColor="#f5fafe" class="ta_01" >
										游玩城市：
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:textfield name="proCityName"/>
									</td>
									<td width="18%" height="22" align="center" bgColor="#f5fafe" class="ta_01" >
										是否热门:
									</td>
									<td class="ta_01" bgColor="#ffffff" colspan="3">
										<s:select headerKey="" headerValue="==请选择==" list="{'是','否'}" name="topOrNot" />
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
							<strong>产 品 列 表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="&#28155;&#21152;" class="button_add" onclick="addProduct()">
								添加新的产品
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

									<td align="center" width="7%">
										产品编号
									</td>
									<td align="center" width="12%">
										产品名称
									</td>
									<td align="center" width="26%">
										产品描述
									</td>
									<td align="center" width="8%">
										是否热门
									</td>
									<td align="center" width="8%">
										是否上首页
									</td>
									<td align="center" width="8%">
										游玩城市
									</td>
									<td align="center" width="7%" >
										编辑
									</td>
									<td align="center" width="7%">
										查看
									</td>
									<td align="center" width="7%">
										删除
									</td>
								</tr>
								<s:iterator>						
									<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
										<td style="CURSOR: hand; HEIGHT: 22px" align="center">
											<s:property value="productId"/>
										</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center">
											<s:property value="productName"/>
										</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center">
											<s:if test="productDescription.length() >= 100">
												<s:property value="productDescription.substring(0,100)"/>
											</s:if>
											<s:else>
												<s:property value="productDescription"/>
											</s:else>
										</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center">
											<s:property value="isTop"/>
										</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center">
											<s:property value="isPublic"/>
										</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center">
											<s:property value="cityName"/>
										</td>
										<td align="center" style="HEIGHT: 22px">
											<s:a action="product_loadForEdit" namespace="/">
												<s:param name="productId" value="productId"/>
												<s:param name="productName" value="productName"/>
												<img src="<c:url value='/images/i_edit.gif'/>" border="0" style="CURSOR: hand">
											</s:a>
										</td>
										<td align="center" style="HEIGHT: 22px">
											<s:a action="product_view" namespace="/">
												<s:param name="productId" value="productId"/>
												<s:param name="productName" value="productName"/>
												<img src="<c:url value='/images/button_view.gif'/>" border="0" style="CURSOR: hand">
											</s:a>
										</td>
										<td align="center" style="HEIGHT: 22px" onclick="return confirm('您是否确定删除该记录？')">
											<s:a action="product_delete" namespace="/">
												<s:param name="productId" value="productId"/>
												<s:param name="productName" value="productName"/>
												<s:param name="productRealName" value="productRealName"/>
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
							<s:url action="product_page" namespace="/" id="firstPage">
								<s:param name="pageNum">1</s:param>
							</s:url>
							<s:a href="%{firstPage}" cssStyle="color:blue">[首页]</s:a>
							
							<!-- 上一页链接设置 -->
							<s:url action="product_page" namespace="/" id="prePage">
								<s:param name="pageNum">
									<s:property value="pageNum-1"/>
								</s:param>
							</s:url>
							<s:a href="%{prePage}" cssStyle="color:blue">[上一页]</s:a>
							
							<!-- 显示当前页数/总页数 -->
							<s:property value="pageNum"/>/<s:property value="totalPage"/>
							
							<!-- 下一页链接设置 -->
							<s:url action="product_page" namespace="/" id="nextPage">
								<s:param name="pageNum">
									<s:property value="pageNum+1"/>
								</s:param>
							</s:url>
							<s:a href="%{nextPage}" cssStyle="color:blue">[下一页]</s:a>
							
							<!-- 尾页链接设置 -->
							<s:url action="product_page" namespace="/" id="lastPage">
								<s:param name="pageNum">
									<s:property value="totalPage"/>
								</s:param>
							</s:url>
							<s:a href="%{lastPage}" cssStyle="color:blue">[末页]</s:a>
							
						</td>
					</tr>
				</TBODY>
			</table>
		</s:form>
  </body>
</html>
