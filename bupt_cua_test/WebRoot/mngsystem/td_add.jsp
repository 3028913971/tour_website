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
				<li class="active">
					<a href="<s:url action="td_page" namespace="/"/>">修改旅游地信息</a>
				</li>
				<li>
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
		<s:form action="td_add" namespace="/" theme="simple" onsubmit="return CheckTdForm();" enctype="multipart/form-data">
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>添加旅游地信息</STRONG>
						</strong>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp;  
						旅游地名称:
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:textfield name="cityName" id="cityName" onblur="CheckName('cityName','旅游地名称','cityNameError')"/>
						<span style="color:#ff0000;font-weight:900;"id="cityNameError"></span>
						<span style="color:#ff0000;font-weight:900;"><s:actionerror value="cityName"/></span>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						所属省份:
					</td>

					<td class="ta_01" bgColor="#ffffff">
						<s:select list="{'安徽','澳门','北京','重庆','福建','甘肃','广东','广西','贵州','海南','河北','河南','黑龙江','湖北','湖南','吉林','江苏','江西','辽宁','内蒙古','宁夏','青海','山东','山西','陕西','上海','四川','台湾','天津','西藏','香港','新疆','云南','浙江'}" name="province" id="province" headerKey="" headerValue="--选择省份--" onchange="CheckNull('province','所属省份','provinceError')"/>
						<span style="color:#ff0000;font-weight:900;"id="provinceError"></span>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						所属区域:
					</td>				
					<td class="ta_01" bgColor="#ffffff">
						<s:select list="{'东北','华北','华东','华中','华南','西北','西南'}" name="area" id="area" headerKey="" headerValue="--选择区域--" onchange="CheckNull('area','所属区域','areaError')"/>
						<span style="color:#ff0000;font-weight:900;"id="areaError"></span>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						热门季节:
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:checkboxlist list="{'第一季度（春）','第二季度（夏）','第三季度（秋）','第四季度（冬）'}" name="topSeason" id="topSeason" onblur="CheckRadios('topSeason','热门季节','topSeasonError')"/>
						<span style="color:#ff0000;font-weight:900;"id="topSeasonError"></span>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						主题类型:
					</td>	
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:checkboxlist list="themeList" name="themeType" id="themeType" onblur="CheckRadios('themeType','主题类型','themeTypeError')"/>
						<span style="color:#ff0000;font-weight:900;"id="themeTypeError"></span>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp;
						主题类型昵称:
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:textfield name="themeNickname" id="themeNickname" onblur="CheckTDNickName('themeNickname','主题类型昵称','themeNicknameError')"/>
						<span style="color:#ff0000;font-weight:900;"id="themeNicknameError"></span>
					</td>	
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						国内或国外:
					</td>	
					<td class="ta_01" bgColor="#ffffff">
						<s:select list="{'国内','国外'}" name="homeOrAbroad" id="homeOrAbroad" headerKey="" headerValue="--请选择--" onchange="CheckNull('homeOrAbroad','国内或国外','homeOrAbroadError')"></s:select>
						<span style="color:#ff0000;font-weight:900;"id="homeOrAbroadError"></span>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						是否为首页热门季节推荐：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:select list="{'是','否'}" name="isHomeTopSeason" id="isHomeTopSeason" headerKey="" headerValue="--请选择--" onchange="CheckNull('isHomeTopSeason','是否为首页热门季节推荐','isHomeTopSeasonError')"/>	
						<span style="color:#ff0000;font-weight:900;"id="isHomeTopSeasonError"></span>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						是否为首页热门主题目的地推荐：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:select list="{'是','否'}" name="isHomeThemeType" id="isHomeThemeType" headerKey="" headerValue="--请选择--" onchange="CheckNull('isHomeThemeType','是否为首页热门主题目的地推荐','isHomeThemeTypeError')"/>	
						<span style="color:#ff0000;font-weight:900;"id="isHomeThemeTypeError"></span>
					</td>
				</tr>
				
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						是否为热门季节推荐：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:select list="{'是','否'}" name="isTopSeason" id="isTopSeason" headerKey="" headerValue="--请选择--" onchange="CheckNull('isTopSeason','是否为热门季节推荐','isTopSeasonError')"/>	
						<span style="color:#ff0000;font-weight:900;"id="isTopSeasonError"></span>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						是否为热门主题目的地推荐：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:select list="{'是','否'}" name="isThemeType" id="isThemeType" headerKey="" headerValue="--请选择--" onchange="CheckNull('isThemeType','是否为热门主题目的地推荐','isThemeTypeError')"/>	
						<span style="color:#ff0000;font-weight:900;"id="isThemeTypeError"></span>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp;  
						是否发布：
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:select list="{'是','否'}" name="isPublic" id="isPublic" headerKey="" headerValue="--请选择--" onchange="CheckNull('isPublic','是否发布','isPublicError')"/>	
						<span style="color:#ff0000;font-weight:900;"id="isPublicError"></span>
					</td>
				</tr>
				<tr>
					<td width="18%" class="ta_01" align="center" bgColor="#f5fafe">
						旅游地概述：
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:textarea name="description" cols="30" rows="5" cssStyle="WIDTH: 96%"/><br/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						旅游地封面图片上传：
					</td>
					<td class="ta_01" bgColor="#ffffff"  colspan="3">
						<s:file name="descriptionPhoto" size="20"/>
					</td>
				</tr>
				<tr>
					<td width="18%" class="ta_01" align="center" bgColor="#f5fafe">
						旅游地交通描述：
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:textarea name="trafficDescription" cols="30" rows="5" cssStyle="WIDTH: 96%"/><br/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						旅游地交通图片上传：
					</td>
					<td class="ta_01" bgColor="#ffffff"  colspan="3">
						<s:file name="traffic" size="20"/>
					</td>
				</tr>
				<tr>
					<td width="18%" class="ta_01" align="center" bgColor="#f5fafe">
						旅游地景点描述：
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:textarea name="spotDescription" cols="30" rows="5" cssStyle="WIDTH: 96%"/><br/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						旅游地景点图片上传：
					</td>
					<td class="ta_01" bgColor="#ffffff"  colspan="3">
						<s:file name="spot" size="20"/>
					</td>
				</tr>
				<tr>
					<td width="18%" class="ta_01" align="center" bgColor="#f5fafe">
						旅游地购物描述：
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:textarea name="shoppingDescription" cols="30" rows="5" cssStyle="WIDTH: 96%"/><br/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						旅游地购物图片上传：
					</td>
					<td class="ta_01" bgColor="#ffffff"  colspan="3">
						<s:file name="shopping" size="20"/>
					</td>
				</tr>
				<tr>
					<td width="18%" class="ta_01" align="center" bgColor="#f5fafe">
						旅游地美食描述：
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:textarea name="foodDescription" cols="30" rows="5" cssStyle="WIDTH: 96%"/><br/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						旅游地美食图片上传：
					</td>
					<td class="ta_01" bgColor="#ffffff"  colspan="3">
						<s:file name="food" size="20"/>
					</td>
				</tr>
				<tr>
					<td  class="ta_01" bgColor="#ffffff"  colspan="4">
						<span style="color:#ff0000;font-weight:900;">建议上传 680 x 480 ，大小约为2M的图片文件！</span> 
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