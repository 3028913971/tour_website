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
		<!-- 日期插件，使用jquery -->
		<script type="text/javascript" src="<c:url value='/jquery/jquery-1.4.2.js'/>"></script>
		<link rel="stylesheet" href="<c:url value='/jquery/jquery.datepick.css'/>" type="text/css">
		<script type="text/javascript" src="<c:url value='/jquery/jquery.datepick.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/jquery/jquery.datepick-zh-CN.js'/>"></script>
	</HEAD>
	<script type="text/javascript">
		$(document).ready(function(){
			//使用class属性处理  'yy-mm-dd' 设置格式"yyyy/mm/dd"
			$('#birthday').datepick({dateFormat: 'yy-mm-dd'}); 
		});
	</script>
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
				<li>
					<a href="<s:url action="strategyFile_page" namespace="/"/>">修改攻略文件信息</a>
				</li>
				<li class="active"> 
					<a href="<s:url action="theme_findAll" namespace="/"/>">修改主题信息</a>
				</li>			
			</ul>
		</div>
		<s:form action="theme_add" namespace="/" theme="simple" enctype="multipart/form-data" onsubmit="return CheckThemeForm();">
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>添加主题信息</STRONG>
						</strong>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp;  
						主题名称:
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:textfield name="themeName" id="themeName" onblur="CheckName('themeName','主题名','themeNameError')"/>
						<span style="color:#ff0000;font-weight:900;" id="themeNameError"/>
						<span style="color:#ff0000;font-weight:900;"><s:actionerror/></span>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						是否推送首页:
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:select name="themeIsTop" list="{'是','否'}" id="themeIsTop" headerKey="" headerValue="===选择推送首页===" onchange="CheckNull('themeIsTop','是否推送主页','themeIsTopError')"/>
						<span style="color:#ff0000;font-weight:900;" id="themeIsTopError"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						主题图片上传:
					</td>				
					<td class="ta_01" bgColor="#ffffff">
						<s:file name="upload" id="themeFileName" onchange="CheckPhotoType('themeFileName','主题图片','themeFileNameError')"/>
						<span style="color:#ff0000;font-weight:900;" id="themeFileNameError"/>
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
						<button type="submit" name="submit" value="确定" class="button_ok">
							确定
						</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="重置" class="button_cancel">重置</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</HTML>