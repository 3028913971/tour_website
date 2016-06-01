<%@page import="cn.cua.domain.JourneyInfo"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="<c:url value='/css/Style.css'/>" type="text/css" rel="stylesheet">
		<script language="javascript" src="<c:url value='/js/public.js'/>"></script>
		<script language="javascript" src="<c:url value='/js/check.js'/>"></script>
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
					<a href="<s:url action="product_page" namespace="/"/>">修改产品信息</a>
				</li>
			</ul>
		</div>
		<br>
		<s:form action="product_addJourney" namespace="/" theme="simple" enctype="multipart/form-data" onsubmit="%{'return CheckAddJourneyForm('+proDays+');'}">
			&nbsp;
			<s:hidden name="proDays" value="%{proDays}"/>
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>添 加 行 程 信 息</STRONG>
						</strong>
					</td>
				</tr>
				
				<s:iterator value="new int[100]" status="st">
					<s:if test="#st.index < proDays">
						<s:hidden name="%{'journeyInfo['+ #st.index + '].journeyDayNumber'}" value="%{#st.index+1}"/>
						<s:hidden name="%{'journeyInfo['+ #st.index + '].productName'}" value = "%{proName}"/>
						<tr>
							<td align="center" bgColor="#f5fafe" class="ta_01" colspan="3">
								行程第<s:property value="%{#st.index +1}"/>天
							</td>
						</tr>
						<tr>
							<td align="center" bgColor="#f5fafe" class="ta_01">
								<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
								行程题目：
							</td>
							<td class="ta_01" bgColor="#ffffff" colspan="3">
								<!--  
								<s:hidden name="%{'check' + #st.index}" value="%{'CheckName(\'jouneyTitle'+ #st.index +'\',\'行程题目\',\'journeyTitleError'+#st.index+'\')}"/>
								<s:hidden name="%{'error'}" value="%{'journeyTitleError'+#st.index}"/>
								-->
								<s:textfield name="%{'journeyInfo['+ #st.index + '].journeyTitle'}" size="100" id="%{'journeyTitle'+#st.index}" onblur="CheckNull('journeyTitle','行程题目','journeyTitleError',%{#st.index})"/>
								
								<span style="color:#ff0000;font-weight:900;" id="journeyTitleError${st.index}">
								
								<!--  
								<s:textfield name="%{'journeyInfo['+ #st.index + '].journeyTitle'}" size="100"/>
								<span style="color:#ff0000;font-weight:900;">
									<s:fielderror fieldName="journeyTitle"/>
								</span>
								-->
							</td>
							
						</tr>
						<tr>
							<td align="center" bgColor="#f5fafe" class="ta_01">
								&nbsp;&nbsp;行程描述：
							</td>
							<td class="ta_01" bgColor="#ffffff" colspan="3">
								<s:textarea name="%{'journeyInfo['+ #st.index + '].journeyDescription'}" cols="105" rows="5"/>
								
								<span style="color:#ff0000;font-weight:900;">
									<s:fielderror fieldName="journeyDescription"/>
								</span>
								
							</td>
							
						</tr>
						<tr>
							<td align="center" bgColor="#f5fafe" class="ta_01">
								<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
								行程文件上传：
							</td>
							<td class="ta_01" bgColor="#ffffff" colspan="3">
								<s:file name="jfile" id="%{'journeyFile'+#st.index}" onchange="CheckPhotoType1('journeyFile','行程文件','journeyFileError',%{#st.index})"/>
								
								<span style="color:#ff0000;font-weight:900;" id="journeyFileError${st.index}">
								
								<!--  
								<s:file name="jfile"/>
								<span style="color:#ff0000;font-weight:900;">
									<s:fielderror fieldName="jfile"/>
								</span>
								-->
							</td>
							
						</tr>
						<tr>
							<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4" height="26">
								<strong>
									<STRONG></STRONG>
								</strong>
							</td>
						</tr>
					</s:if>
				</s:iterator>

				<tr>
					<td  class="ta_01" bgColor="#ffffff"  colspan="4">
						<span style="color:#ff0000;font-weight:900;">建议上传 680 x 480 ，大小约为2M的图片文件！</span> 
					</td>				
				</tr>
				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<button type="submit" name="submit" value="保存" class="button_ok">
							&#30830;&#23450;
						</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="重置" class="button_cancel">&#37325;&#32622;</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</HTML>