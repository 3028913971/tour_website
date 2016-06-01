<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<c:url value='/css/Style.css'/>" rel="stylesheet" type="text/css" />
		<script language="javascript" src="<c:url value='/js/public.js'/>"></script>
		<script type="text/javascript">
			function addTd(){
				window.location.href = "<s:url action="td_loadForAdd" namespace="/"/>";
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
				<li class="active">
					<a href="<s:url action="td_page" namespace="/"/>">修改旅游地信息</a>
				</li>
				<li>
					<a href="<s:url action="td_findAllForEditOrder" namespace="/"/>">修改旅游地顺序</a>
				</li>
				<li>
					<a href="<s:url action="strategyFile_page" namespace="/"/>">修改攻略文件信息</a>
				</li>
				<li> 
					<a href="<s:url action="theme_findAll" namespace="/"/>">修改主题信息</a>
				</li>
			</ul>
		</div>
		<br>
		<s:form action="td_pageQuery" namespace="/" theme="simple" >
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>查 询 条 件</strong>
						</td>
					</tr>
					<tr>
						<td>
							<table cellpadding="0" cellspacing="0" border="0" width="100%">
								<tr>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01" >
										旅游地名称:
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:textfield name="qcityName" size="15"/>
									</td>
									<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
										所属省份:
									</td>
				
									<td class="ta_01" bgColor="#ffffff">
										<s:select list="{'安徽','澳门','北京','重庆','福建','甘肃','广东','广西','贵州','海南','河北','河南','黑龙江','湖北','湖南','吉林','江苏','江西','辽宁','内蒙古','宁夏','青海','山东','山西','陕西','上海','四川','台湾','天津','西藏','香港','新疆','云南','浙江'}" name="qprovince" headerKey="" headerValue="--选择省份--" />
									</td>
								</tr>
								<tr>
									<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
										所属区域:
									</td>				
									<td class="ta_01" bgColor="#ffffff">
										<s:select list="{'东北','华北','华东','华中','华南','西北','西南'}" name="qarea" headerKey="" headerValue="--选择区域--"/>
									</td>
									<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
										热门季节：
									</td>				
									<td class="ta_01" bgColor="#ffffff">
										<s:select list="{'第一季度（春）','第二季度（夏）','第三季度（秋）','第四季度（冬）'}" name="qtopSeason" headerKey="" headerValue="--选择季度--"/>
									</td>
								</tr>
								<tr>
									<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
										主题类型:
									</td>				
									<td class="ta_01" bgColor="#ffffff">
										<s:select list="themeList" name="qthemeType" headerKey="" headerValue="--选择主题类型--"/>
									</td>
									<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
										国内或国外：
									</td>				
									<td class="ta_01" bgColor="#ffffff">
										<s:select list="{'国内','国外'}" name="qhomeOrAbroad" headerKey="" headerValue="--请选择--"></s:select>
									</td>
								</tr>
								<tr>
									<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
										是否为首页热门季节推荐：
									</td>				
									<td class="ta_01" bgColor="#ffffff">
										<s:select list="{'是','否'}" name="qisHomeTopSeason" headerKey="" headerValue="--请选择--"/>
									</td>
									<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
										是否为首页主题目的地推荐：
									</td>				
									<td class="ta_01" bgColor="#ffffff">
										<s:select list="{'是','否'}" name="qisHomeThemeType" headerKey="" headerValue="--请选择--"/>
									</td>
								</tr>
								<tr>
									<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
										是否为热门季节推荐：
									</td>				
									<td class="ta_01" bgColor="#ffffff">
										<s:select list="{'是','否'}" name="qisTopSeason" headerKey="" headerValue="--请选择--"/>
									</td>
									<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
										是否为主题目的地推荐：
									</td>				
									<td class="ta_01" bgColor="#ffffff">
										<s:select list="{'是','否'}" name="qisThemeType" headerKey="" headerValue="--请选择--"/>
									</td>
								</tr>
								<tr>
									<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
										是否发布：
									</td>
									<td class="ta_01" bgColor="#ffffff" colSpan="3">
										<s:select list="{'是','否'}" name="qisPublic" id="qisPublic" headerKey="" headerValue="--请选择--"/>	
									</td>
								</tr>
								<tr>
									<td width="100" height="22" align="center" bgColor="#f5fafe"
										class="ta_01">
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<font face="宋体" color="red"> &nbsp;</font>
									</td>
									<td align="right" bgColor="#ffffff" class="ta_01">
										<button type="submit" id="search" name="search" value="查询" class="button_view">
											查询
										</button>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="reset" name="reset" value="重置" class="button_view"/>
									</td>
		
									<td align="right" bgColor="#ffffff" class="ta_01"><br><br></td>
								</tr>
							</table>
						</td>

					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>旅 游 地 列 表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="&#28155;&#21152;" class="button_add" onclick="addTd()">
								添加新的旅游地
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

									<td align="center" width="20%">
										旅游地名称
									</td>
									<td align="center" width="20%">
										所属省份
									</td>
									<td align="center" width="15%">
										所属区域
									</td>
									<td align="center" width="15%">
										当前顺序
									</td>
									<td align="center" width="10%" >
										编辑
									</td>
									<td align="center" width="10%">
										查看
									</td>
									<td align="center" width="10%">
										删除
									</td>
								</tr>	
								<s:iterator value="top">							
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="20%">
										<s:property value="cityName"/>
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="20%">
										<s:property value="province"/>
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="15%">
										<s:property value="area"/>
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="15%">
										<s:property value="order"/>
									</td>
									<td align="center" style="HEIGHT: 22px">
										<s:a action="td_loadForEdit" namespace="/">
											<s:param name="cityName" value="cityName"/>
											<img src="<c:url value='/images/i_edit.gif'/>" border="0" style="CURSOR: hand">
										</s:a>
									</td>
									<td align="center" style="HEIGHT: 22px">
										<s:a action="td_load" namespace="/">
											<s:param name="cityName" value="cityName"/>
											<img src="<c:url value='/images/button_view.gif'/>" border="0" style="CURSOR: hand">
										</s:a>
									</td>
									<td align="center" style="HEIGHT: 22px" onclick="return confirm('您是否确定删除该记录？')">
										<s:a action="td_delete" namespace="/">
											<s:param name="cityName" value="cityName"/>
											<s:param name="cityPhotoRealName" value="cityPhotoRealName"/>
											<s:param name="trafficPhotoRealName" value="trafficPhotoRealName"/>
											<s:param name="spotPhotoRealName" value="spotPhotoRealName"/>
											<s:param name="shoppingPhotoRealName" value="shoppingPhotoRealName"/>
											<s:param name="foodPhotoRealName" value="foodPhotoRealName"/>
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
							
							<s:url action="td_pageQuery1" namespace="/" id="firstPage">
								<s:param name="pageNum">1</s:param>
							</s:url>
							<s:a href="%{firstPage}" cssStyle="color:blue">[首页]</s:a>
							<s:url action="td_pageQuery1" namespace="/" id="prePage">
								<s:param name="pageNum">
									<s:property value="pageNum-1"/>
								</s:param>
								<s:param name="qcityName" value="qcityName"></s:param>
								<s:param name="qisPublic" value="qisPublic"></s:param>
								<s:param name="qprovince" value="qprovince"></s:param>
								<s:param name="qarea" value="qarea"></s:param>
								<s:param name="qtopSeason" value="qtopSeason"></s:param>
								<s:param name="qthemeType" value="qthemeType"></s:param>
								<s:param name="qhomeOrAbroad" value="qhomeOrAbroad"></s:param>
								<s:param name="qisTopSeason" value="qisTopSeason"></s:param>
								<s:param name="qisHomeThemeType" value="qisHomeThemeType"></s:param>
								<s:param name="qisThemeType" value="qisThemeType"></s:param>
								<s:param name="qisHomeTopSeason" value="qisHomeTopSeason"></s:param>
							</s:url>
							<s:a href="%{prePage}" cssStyle="color:blue">[上一页]</s:a>
							<s:url action="td_pageQuery1" namespace="/" id="nextPage">
								<s:param name="pageNum">
									<s:property value="pageNum+1"/>
								</s:param>
								<s:param name="qcityName" value="qcityName"></s:param>
								<s:param name="qisPublic" value="qisPublic"></s:param>
								<s:param name="qprovince" value="qprovince"></s:param>
								<s:param name="qarea" value="qarea"></s:param>
								<s:param name="qtopSeason" value="qtopSeason"></s:param>
								<s:param name="qthemeType" value="qthemeType"></s:param>
								<s:param name="qhomeOrAbroad" value="qhomeOrAbroad"></s:param>
								<s:param name="qisTopSeason" value="qisTopSeason"></s:param>
								<s:param name="qisHomeThemeType" value="qisHomeThemeType"></s:param>
								<s:param name="qisThemeType" value="qisThemeType"></s:param>
								<s:param name="qisHomeTopSeason" value="qisHomeTopSeason"></s:param>
							</s:url>
							<s:property value="pageNum"/>/<s:property value="totalpage"/>
							<s:a href="%{nextPage}" cssStyle="color:blue">[下一页]</s:a>
							<s:url action="td_pageQuery1" namespace="/" id="lastPage">
								<s:param name="pageNum">
									<s:property value="totalpage"/>
								</s:param>
								<s:param name="qcityName" value="qcityName"></s:param>
								<s:param name="qisPublic" value="qisPublic"></s:param>
								<s:param name="qprovince" value="qprovince"></s:param>
								<s:param name="qarea" value="qarea"></s:param>
								<s:param name="qtopSeason" value="qtopSeason"></s:param>
								<s:param name="qthemeType" value="qthemeType"></s:param>
								<s:param name="qhomeOrAbroad" value="qhomeOrAbroad"></s:param>
								<s:param name="qisTopSeason" value="qisTopSeason"></s:param>
								<s:param name="qisHomeThemeType" value="qisHomeThemeType"></s:param>
								<s:param name="qisThemeType" value="qisThemeType"></s:param>
								<s:param name="qisHomeTopSeason" value="qisHomeTopSeason"></s:param>
							</s:url>
							<s:a href="%{lastPage}" cssStyle="color:blue">[末页]</s:a>
							<s:url action="td_pageQuery1" namespace="/" id="lastPage">
								<s:param name="qcityName" value="qcityName"></s:param>
								<s:param name="qisPublic" value="qisPublic"></s:param>
								<s:param name="qprovince" value="qprovince"></s:param>
								<s:param name="qarea" value="qarea"></s:param>
								<s:param name="qtopSeason" value="qtopSeason"></s:param>
								<s:param name="qthemeType" value="qthemeType"></s:param>
								<s:param name="qhomeOrAbroad" value="qhomeOrAbroad"></s:param>
								<s:param name="qisTopSeason" value="qisTopSeason"></s:param>
								<s:param name="qisHomeThemeType" value="qisHomeThemeType"></s:param>
								<s:param name="qisThemeType" value="qisThemeType"></s:param>
								<s:param name="qisHomeTopSeason" value="qisHomeTopSeason"></s:param>
							</s:url>
						</td>
					</tr>
				</TBODY>
			</table>
		</s:form>
	</body>
</HTML>

