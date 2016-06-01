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
				window.location.href = "<c:url value='/mngsystem/strategy_add.jsp'/>";
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
				<li class="active">
					<a href="<s:url action="strategyFile_page" namespace="/"/>">修改攻略文件信息</a>
				</li>
				<li> 
					<a href="<s:url action="theme_findAll" namespace="/"/>">修改主题信息</a>
				</li>
			</ul>
		</div>
		<br>
		<s:form action="strategyFile_pageQuery" namespace="/" theme="simple">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>查 询 攻 略 文 件 信 息</strong>
						</td>
					</tr>
					<tr>
						<td>
							<table cellpadding="0" cellspacing="0" border="0" width="100%">
								<tr>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										城市名
									</td>
									<td class="ta_01" bgColor="#ffffff" colspan="3">
										<s:textfield name="qcityName"/>
									</td>
								<tr>
									<td width="100" height="22" align="center" bgColor="#f5fafe"
										class="ta_01">
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<font face="宋体" color="red"> &nbsp;</font>
									</td>
									<td align="right" bgColor="#ffffff" class="ta_01"><br><br></td>
									<td align="center" bgColor="#ffffff" class="ta_01">
										<button type="submit" name="search" value="查询" class="button_view">
											查询
										</button>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="reset" name="reset" value="重置" class="button_view"/>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>攻 略 列 表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="&#28155;&#21152;" class="button_add" onclick="addUser()">
								添加新的攻略
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

									<td align="center" width="10%">
										城市名
									</td>
									<td align="center" width="5%">
										是否热门
									</td>
									<td align="center" width="15%">
										攻略文件PDF名称
									</td>
									<td align="center" width="10%">
										攻略文件JPG名称
									</td>
									<td align="center" width="10%">
										攻略下载次数
									</td>
									<td align="center" width="20%">
										攻略更新时间
									</td>
									<td width="10%" align="center">
										编辑
									</td>
									<td width="10%" align="center">
										查看
									</td>
									<td width="10%" align="center">
										删除
									</td>
								</tr>
								<s:iterator>
									<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												<s:property value="cityName"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="5%">
												<s:property value="isTop"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="15%">
												<s:property value="strategyFileName"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												<s:property value="strategyJpgName"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												<s:property value="amountOfDownload"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="20%">
												<s:property value="updateTime"/>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<s:a action="strategyFile_loadForEdit" namespace="/">
													<s:param name="strategyFileId" value="strategyFileId"/>
													<img src="<c:url value='/images/i_edit.gif'/>" border="0" style="CURSOR: hand">
												</s:a>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<s:a action="strategyFile_load" namespace="/">
													<s:param name="strategyFileId" value="strategyFileId"/>
													<img src="<c:url value='/images/button_view.gif'/>" border="0" style="CURSOR: hand">
												</s:a>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<s:a action="strategyFile_delete" namespace="/" onclick="return confirm('您是否真的要删除该记录')">
													<s:param name="strategyFileId" value="strategyFileId"/>
													<s:param name="strategyFileRealName" value="strategyFileRealName"/>
													<s:param name="strategyPhotoRealName" value="strategyPhotoRealName"/>
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
							
							<s:url action="strategyFile_pageQuery1" namespace="/" id="firstPage">
								<s:param name="pageNum">1</s:param>
								<s:param name="qcityName" value="qcityName"></s:param>
							</s:url>
							<s:a href="%{firstPage}" cssStyle="color:blue">[首页]</s:a>
							<s:url action="strategyFile_pageQuery1" namespace="/" id="prePage">
								<s:param name="pageNum">
									<s:property value="pageNum-1"/>
								</s:param>
								<s:param name="qcityName" value="qcityName"></s:param>
							</s:url>
							<s:a href="%{prePage}" cssStyle="color:blue">[上一页]</s:a>
							<s:url action="strategyFile_pageQuery1" namespace="/" id="nextPage">
								<s:param name="pageNum">
									<s:property value="pageNum+1"/>
								</s:param>
								<s:param name="qcityName" value="qcityName"></s:param>
							</s:url>
							<s:property value="pageNum"/>/<s:property value="totalpage"/>
							<s:a href="%{nextPage}" cssStyle="color:blue">[下一页]</s:a>
							<s:url action="strategyFile_pageQuery1" namespace="/" id="lastPage">
								<s:param name="pageNum">
									<s:property value="totalpage"/>
								</s:param>
								<s:param name="qcityName" value="qcityName"></s:param>
							</s:url>
							<s:a href="%{lastPage}" cssStyle="color:blue">[末页]</s:a>
							<s:url action="strategyFile_pageQuery1" namespace="/" id="lastPage">
								<s:param name="qcityName" value="qcityName"></s:param>
							</s:url>
						</td>
					</tr>
				</TBODY>
			</table>
		</s:form>
	</body>
</HTML>

