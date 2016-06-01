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
			$('#sdate').datepick({dateFormat: 'yy-mm-dd'}); 
		});
	</script>
	<script type="text/javascript">
		$(document).ready(function(){
			//使用class属性处理  'yy-mm-dd' 设置格式"yyyy/mm/dd"
			$('#edate').datepick({dateFormat: 'yy-mm-dd'}); 
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
					<a href="<s:url action="product_page" namespace="/"/>">修改产品信息</a>
				</li>
			</ul>
		</div>
		<br>
		<s:form action="product_add" namespace="/" theme="simple" enctype="multipart/form-data"  onsubmit="return CheckProductForm();">
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>添 加 产 品 文 件 信 息</STRONG>
						</strong>
					</td>
				</tr>
				
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						产品名称：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:textfield name="productName" size="105" id="productName" onblur="CheckNull('productName','产品名称','productNameError')"/>
						<span style="color:#ff0000;font-weight:900;" id="productNameError"></span>
						<span style="color:#ff0000;font-weight:900;"><s:actionerror/></span>	
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						游玩城市：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:textfield name="cityName" id="cityName" onblur="CheckName('cityName','游玩城市','cityNameError')"/>
						<span style="color:#ff0000;font-weight:900;" id="cityNameError"></span>
					</td>
				</tr>
				
				<tr>
					
					<td align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						是否热门：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:select name="isTop" list="{'是','否'}" headerKey="" headerValue="===选择是否热门===" id="isTop" onchange="CheckNull('isTop','是否热门','isTopError')"/>
						<span style="color:#ff0000;font-weight: 900;" id="isTopError"></span>
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						是否发布：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:select name="isPublic" list="{'是','否'}" headerKey="" headerValue="===选择是否发布===" id="isPublic" onchange="CheckNull('isPublic','是否发布','isPublicError')"/>
						<span style="color:#ff0000;font-weight: 900;" id="isPublicError"></span>
					</td>
				</tr>
				
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						产品价格：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:textfield name="productPrice" id="productPrice" onblur="CheckNum('productPrice','产品价格','productPriceError')"/>
						<span style="color:#ff0000;font-weight: 900;" id="productPriceError"></span>
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						产品联系电话：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:textfield name="productCellphone" id="productCellphone" onblur="CheckCellphone('productCellphone','产品联系电话','productCellphoneError')"/>
						<span style="color:#ff0000;font-weight: 900;" id="productCellphoneError"></span>
					</td>
				</tr>
				
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						开始日期：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:textfield name="startDate" readonly="true" id="sdate" onchange="CheckNull('sdate','开始日期','sdateError')"/>
						<span style="color:#ff0000;font-weight: 900;" id="sdateError"></span>
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						结束日期：
					</td>
					<td class="ta_01" bgColor="#ffffff"">
						<s:textfield name="endDate" readonly="true" id="edate" onchange="CheckNull('edate','结束日期','edateError')"/>
						<span style="color:#ff0000;font-weight: 900;" id="edateError"></span>
						<span style="color:#ff0000;font-weight:900;"><s:fielderror name="endDate"/></span>
					</td>
				</tr>
				
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						产品文件上传：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:file name="file"/>
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp;
						行程天数：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:textfield name="proDays" id="proDays" onchange="CheckDayNum('proDays','行程天数','proDaysError')"/>
						<span style="color:#ff0000;font-weight: 900;" id="proDaysError"></span>
					</td>
				</tr>
				
				
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						产品描述：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:textarea name="productDescription" cols="100" rows="5"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						产品特色：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:textarea name="productFeature" cols="100" rows="5"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						费用说明：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:textarea name="costDescription" cols="100" rows="5"/>
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
						<button type="submit" name="submit" value="保存并添加行程信息" class="button_ok">
							保存并添加行程信息
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