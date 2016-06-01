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
				window.location.href = "<c:url value='/mngsystem/strategyTopPhoto_add.jsp'/>";
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
					<s:a action="topPhoto_page" namespace="/">修改首页滚动图片信息</s:a>
				</li>	
				<li class="active">
					<s:a action="strategyTopPhoto_page" namespace="/">修改攻略首页滚动图片信息</s:a>
				</li>
				<li>
					<s:a action="travelnoteTopPhoto_page" namespace="/">修改游记首页滚动图片信息</s:a>
				</li>
				<li>
					<s:a action="tdTopPhoto_page" namespace="/">修改目的地推荐首页上方图片信息</s:a>
				</li>	
			</ul>
		</div>
		<br>
		<s:form action="strategyTopPhoto_page" namespace="/" theme="simple">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>攻 略 首 页 滚 动 图 片 列 表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="&#28155;&#21152;" class="button_add" onclick="addUser()">
								添加新的图片
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

									<td align="center" width="30%">
										图片名称
									</td>
									<td align="center" width="30%">
										图片更新时间
									</td>
									<td align="center" width="20%">
										是否上首页
									</td>
									<td width="10%" align="center">
										修改
									</td>
									<td width="10%" align="center">
										删除
									</td>
								</tr>
								<s:iterator>
									<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="30%">
												<s:property value="strategyTopPhotoFileName"/>
											</td>  
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="30%">
												<s:property value="updateTime"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="20%">
												<s:property value="isTop"/>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<s:a action="strategyTopPhoto_loadForEdit" namespace="/">
													<s:param name="strategyTopPhotoId" value="strategyTopPhotoId"/>
													<img src="<c:url value='/images/i_edit.gif'/>" border="0" style="CURSOR: hand">
												</s:a>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<s:a action="strategyTopPhoto_delete" namespace="/" onclick="return confirm('您是否真的要删除该记录')">
													<s:param name="strategyTopPhotoId" value="strategyTopPhotoId"/>
													<s:param name="strategyTopPhotoRealName" value="strategyTopPhotoRealName"/>
													<img src="<c:url value='/images/i_del.gif'/>" width="16" height="16" border="0" style="CURSOR: hand">
												</s:a>
											</td>
										</tr>
									</s:iterator>
							</table>
						</td>
					</tr>
					<tr><td align="left">&nbsp;</td></tr>
					<tr>
						<td align="center">
							
							<s:url action="strategyTopPhoto_page" namespace="/" id="firstPage">
								<s:param name="pageNum">1</s:param>
							</s:url>
							<s:a href="%{firstPage}" cssStyle="color:blue">[首页]</s:a>
							<s:url action="strategyTopPhoto_page" namespace="/" id="prePage">
								<s:param name="pageNum">
									<s:property value="pageNum-1"/>
								</s:param>
							</s:url>
							<s:a href="%{prePage}" cssStyle="color:blue">[上一页]</s:a>
							<s:url action="strategyTopPhoto_page" namespace="/" id="nextPage">
								<s:param name="pageNum">
									<s:property value="pageNum+1"/>
								</s:param>
							</s:url>
							<s:property value="pageNum"/>/<s:property value="totalpage"/>
							<s:a href="%{nextPage}" cssStyle="color:blue">[下一页]</s:a>
							<s:url action="strategyTopPhoto_page" namespace="/" id="lastPage">
								<s:param name="pageNum">
									<s:property value="totalpage"/>
								</s:param>
							</s:url>
							<s:a href="%{lastPage}" cssStyle="color:blue">[末页]</s:a>
						</td>
					</tr>
				</TBODY>
			</table>
		</s:form>
	</body>
</HTML>

