<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="<c:url value='/css/Style.css'/>" type="text/css" rel="stylesheet">
		<script language="javascript" src="<c:url value='/js/public.js'/>"></script>
		<script language="javascript" src="<c:url value='/js/check.js'/>"></script>
		<script type="text/javascript">
			function addJourney(){
				window.location.href = "<c:url value='/mngsystem/journey_add1.jsp'/>";
			}
		</script>
		<!-- 日期插件，使用jquery -->
		<script type="text/javascript" src="<c:url value='/jquery/jquery-1.4.2.js'/>"></script>
		<link rel="stylesheet" href="<c:url value='/jquery/jquery.datepick.css'/>" type="text/css">
		<script type="text/javascript" src="<c:url value='/jquery/jquery.datepick.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/jquery/jquery.datepick-zh-CN.js'/>"></script>
	</HEAD>
	<script type="text/javascript">
		$(document).ready(function(){
			//使用class属性处理  'yy-mm-dd' 设置格式"yyyy/mm/dd"
			$('#startdate').datepick({dateFormat: 'yy-mm-dd'}); 
		});
		$(document).ready(function(){
			//使用class属性处理  'yy-mm-dd' 设置格式"yyyy/mm/dd"
			$('#enddate').datepick({dateFormat: 'yy-mm-dd'}); 
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
			#productId{
  				background-color: #C8C8C8;
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
		<s:form action="product_edit" namespace="/" theme="simple" enctype="multipart/form-data"  onsubmit="return CheckEditProductForm();">
			<s:hidden name="model.productFileName" value = "%{model.productFileName}"/>
			<s:hidden name="model.productRealName" value = "%{model.productRealName}"/>
			<s:hidden name="proId" value="%{proId}"/>
			<s:hidden name="proName" value="%{proName}"/>
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>编 辑 产 品 信 息</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						&nbsp;&nbsp;产品编号：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:textfield name="model.productId" readonly="true" id="productId"/>
					</td>
				</tr>
				
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						产品名称：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:textfield name="model.productName" size="105" id="productName" onblur="CheckNull('productName','产品名称','productNameError');"/>
						<span style="color:#ff0000;font-weight:900;" id="productNameError"></span>
						<span style="color:#ff0000;font-weight:900;"><s:actionerror/></span>	
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						游玩城市：
					</td>
					<td class="ta_01" bgColor="#ffffff" >
						<s:textfield name="model.cityName" id="cityName" onblur="CheckName('cityName','游玩城市','cityNameError')"/>
						<span style="color:#ff0000;font-weight:900;" id="cityNameError"></span>
					</td>
				</tr>
				
				<tr>
					
					<td align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						是否热门：
					</td>
					<td class="ta_01" bgColor="#ffffff" >
						<s:select headerKey="" headerValue="==请选择==" list="{'是','否'}" name="model.isTop" id="isTop" onchange="CheckNull('isTop','是否热门','isTopError')"/>
						<span style="color:#ff0000;font-weight: 900;" id="isTopError"></span>
					</td>
						<td align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						是否发布：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:select name="model.isPublic" list="{'是','否'}" headerKey="" headerValue="===选择是否发布===" id="isPublic" onchange="CheckNull('isPublic','是否发布','isPublicError')"/>
						<span style="color:#ff0000;font-weight: 900;" id="isPublicError"></span>
					</td>
				</tr>
				
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						产品价格：
					</td>
					<td class="ta_01" bgColor="#ffffff" >
						<s:textfield name="model.productPrice" id="productPrice" onblur="CheckNum('productPrice','产品价格','productPriceError')"/>
						<span style="color:#ff0000;font-weight: 900;" id="productPriceError"></span>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						联系电话：
					</td>
					<td class="ta_01" bgColor="#ffffff" >
						<s:textfield name="model.productCellphone" id="productCellphone" onblur="CheckCellphone('productCellphone','产品联系电话','productCellphoneError')"/>
						<span style="color:#ff0000;font-weight: 900;" id="productCellphoneError"></span>
					</td>
				</tr>
				
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						&nbsp;&nbsp;产品文件：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:file name="file"/>
					</td>
					
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						开始日期：
					</td>
					<td class="ta_01" bgColor="#ffffff" >
						<s:textfield name="model.startDate" readonly="true" id="startdate" onchange="CheckNull('startdate','开始日期','startdateError')"/>
						<span style="color:#ff0000;font-weight: 900;" id="startdateError"></span>
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						<span style="color:#ff0000;font-weight:900;">*</span>&nbsp; 
						结束日期：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:textfield name="model.endDate" readonly="true" id="enddate" onchange="CheckNull('enddate','开始日期','enddateError')"/>
						<span style="color:#ff0000;font-weight: 900;" id="enddateError"></span>
						<span style="color:#ff0000;font-weight:900;"><s:fielderror name="model.endDate"/></span>
					</td>
				</tr>
				
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						&nbsp;&nbsp;产品描述：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:textarea name="model.productDescription" cols="100" rows="5"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						&nbsp;&nbsp;产品特色：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:textarea name="model.productFeature" cols="100" rows="5"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						&nbsp;&nbsp;费用说明：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:textarea name="model.costDescription" cols="100" rows="5"/>
					</td>
				</tr>
				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<button type="submit" name="submit" value="确定" class="button_ok">
							保存
						</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="重置" class="button_cancel">重置</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
						<span id="Label1"></span>
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
			</table>
			&nbsp;
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>行 程 列 表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="right">
							<s:a action="product_loadForAdd" namespace="/">
								<button type="button"value="&#28155;&#21152;" class="button_add">
									添加新的行程
								</button>
								<s:param name="proId" value="proId"/>
								<s:param name="proName" value="proName"/>
							</s:a>
							<!-- 
							<button type="button" id="add" name="add" value="&#28155;&#21152;" class="button_add" onclick="addJourney()">
								添加新的行程
							</button>
							 -->
						</td>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="8%">
										行程编号
									</td>
									<td align="center" width="8%">
										行程第几天
									</td>
									<td align="center" width="18%">
										行程名称
									</td>
									<td align="center" width="34%">
										行程描述
									</td>
									<td align="center" width="16%">
										行程文件名
									</td>
									<td align="center" width="8%">
										编辑
									</td>
									<td align="center" width="8%">
										删除
									</td>
								</tr>
								<s:iterator>						
									<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
										<td style="CURSOR: hand; HEIGHT: 22px" align="center">
											<s:property value="journeyId"/>
										</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center">
											<s:property value="journeyDayNumber"/>
										</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center">
											<s:property value="journeyTitle"/>
										</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center">
											<s:property value="journeyDescription"/>
										</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center">
											<s:property value="journeyFileName"/>
										</td>
										<td align="center" style="HEIGHT: 22px">
											<s:a action="product_loadJourneyForEdit" namespace="/">
												<s:param name="jourId" value="journeyId"/>
												<s:param name="jourRealName" value="journeyRealName"/>
												<s:param name="proName" value="proName"/>
												<s:param name="proId" value="proId"/>
												<img src="<c:url value='/images/i_edit.gif'/>" border="0" style="CURSOR: hand">
											</s:a>
										</td>
										<td align="center" style="HEIGHT: 22px" onclick="return confirm('您是否确定删除该记录？')">
											<s:a action="product_deleteOneJourney" namespace="/">
												<s:param name="jourId" value="journeyId"/>
												<s:param name="jourRealName" value="journeyRealName"/>
												<s:param name="proName" value="proName"/>
												<s:param name="proId" value="proId"/>
												<img src="<c:url value='/images/i_del.gif'/>" border="0" style="CURSOR: hand">
											</s:a>
										</td>
									</tr>
								</s:iterator>
							</table>
						</td>
					</tr>
				</TBODY>
				
			</table>
		</s:form>
	</body>
</HTML>