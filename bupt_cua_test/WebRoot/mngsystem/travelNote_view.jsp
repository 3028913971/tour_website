<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
				<li class="active">
					<a href="">修改游记信息</a>
				</li>
	
			</ul>
		</div>
		<s:form action="travelNote_view" namespace="/" theme="simple">
			&nbsp;<br/>
			<!--  
			<s:iterator>
				<img src = "<c:url value ='${top}' />"/>
				<s:property />
				<br/>
			</s:iterator>
			-->
			<hr/>
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>查看游记信息</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						游记编号：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:property value="travelNoteId"/>
					</td>
				</tr>
				
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						发布时间：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:property value="publicTime"/>
					</td>
				</tr>
				
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						游记名称：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:property value="travelNoteName"/>
					</td>
				</tr>
				
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						游记作者：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:property value="travelNoteAuthor"/>
					</td>
					
				</tr>
				
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						是否上首页：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:property value="isTop"/>
					</td>
				</tr>
				
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						审核状态：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:property value="status"/>
					</td>
				</tr>
				
				
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						游玩城市：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:property value="cityName"/>
					</td>
					
				</tr>
				<tr>
					<td width="18%"align="center" bgColor="#f5fafe" class="ta_01">
						游记内容
					</td>
					<!-- 
					lhy:链接未找到 
					-->
					<td width="82%" class="ta_01" bgColor="#ffffff" colspan="3">
						<s:a action="travelNoteThirdPage_loadTravelNote" namespace="/" target="view_window">
							<s:param name="travelNoteId" value="travelNoteId"/>
							点此查看游记内容
						</s:a>
					</td>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG></STRONG>
						</strong>
					</td>
				</tr>				


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