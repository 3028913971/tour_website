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
					<s:a action="topPhoto_page" namespace="/">修改首页滚动图片信息</s:a>
				</li>	
				<li>
					<s:a action="strategyTopPhoto_page" namespace="/">修改攻略首页滚动图片信息</s:a>
				</li>
				<li>
					<s:a action="travelnoteTopPhoto_page" namespace="/">修改游记首页滚动图片信息</s:a>
				</li>	
				<li class="active">
					<s:a action="tdTopPhoto_page" namespace="/">修改目的地推荐首页上方图片信息</s:a>
				</li>
			</ul>
		</div>
		<br>
		<s:form action="tdTopPhoto_add" namespace="/" theme="simple" onsubmit="return CheckTopPhotoForm();" enctype="multipart/form-data">
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>添 加 首 页 滚 动 图 片 信 息</STRONG>
						</strong>
					</td>
				</tr>
				<tr>	
					<td align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						目的地推荐首页上方图片上传：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:file name="upload" id="uploadFileName" onchange="CheckPhotoType('uploadFileName','首页滚动图片','uploadFileNameError')"/>
						<span style="color:#ff0000;font-weight:900;"id="uploadFileNameError"></span>
					</td> 
					<td align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						是否上首页：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:select name="isTop" list="{'是','否'}" id="isTop" headerKey="" headerValue="===选择是否热门===" onchange="CheckNull('isTop','是否热门','isTopError')"/>
						<span style="color:#ff0000;font-weight:900;"id="isTopError"></span>
					</td>
				</tr>
				<tr>
					<td  class="ta_01" bgColor="#ffffff"  colspan="4">
						<span style="color:#ff0000;font-weight:900;">建议上传 1920 x 640 ，大小约为2M的图片文件！</span> 
					</td>				
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG></STRONG>
						</strong>
					</td>
				</tr>	


				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<button type="submit" name="submit" value="提交" class="button_ok">
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