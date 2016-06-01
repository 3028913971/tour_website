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
		<s:form action="strategyFile_add" namespace="/" theme="simple" onsubmit="return CheckStrategyForm();"  enctype="multipart/form-data">
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>添 加 攻 略 文 件 信 息</STRONG>
						</strong>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						城市名：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:textfield name="cityName" id="cityName" onblur="CheckName('cityName','城市名','cityNameError')"/>
						<span style="color:#ff0000;font-weight:900;"id="cityNameError"></span>
						<span style="color:#ff0000;font-weight:900;"><s:actionerror value="cityName"/></span>
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						是否热门：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:select name="isTop" list="{'是','否'}" id="isTop" headerKey="" headerValue="===选择是否热门===" onchange="CheckNull('isTop','是否热门','isTopError')"/>
						<span style="color:#ff0000;font-weight:900;"id="isTopError"></span>
					</td>
				</tr>
				<tr>	
					<td align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						攻略文件PDF格式上传：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:file name="upload" id="uploadFileName" onchange="CheckPdfType('uploadFileName','攻略PDF文件','uploadFileNameError')"/>
						<span style="color:#ff0000;font-weight:900;"id="uploadFileNameError"></span>
					</td> 
					<td align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						攻略图片上传：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:file name="photo" id="photoFileName" onchange="CheckPhotoType('photoFileName','攻略图片','photoFileNameError')"/>
						<span style="color:#ff0000;font-weight:900;"id="photoFileNameError"></span>
					</td>
				</tr>
				<tr>	
					<td align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						攻略文件JPG格式上传：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="4">
						<s:file name="jpg" id="jpgFileName" onchange="CheckZipType('jpgFileName','攻略JPG文件','jpgFileNameError')"/>
						<span style="color:#ff0000;font-weight:900;"id="jpgFileNameError"></span>
						<span style="color:#ff0000;font-weight:900;">（请上传".zip"压缩文件格式 ！）</span> 
					</td> 
				</tr>
				<tr>
					<td  class="ta_01" bgColor="#ffffff"  colspan="4">
						<span style="color:#ff0000;font-weight:900;">建议上传 250 x 250 ，大小在100M以内的文件！</span> 
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