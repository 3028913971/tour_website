function CheckNull(idText,strName,id)
{
	if(document.getElementById(idText).value == "")
	{
		document.getElementById(id).innerHTML= strName+"不能为空！";
		document.getElementById(id).focus();
		return false;
	}
	document.getElementById(id).innerHTML= "";
	return true;
}

function CheckRadios(idText,strName,id)
{
	var radios = document.getElementsByName(idText);
	var tag = false;
	var val;
	for(radio in radios) {
	   if(radios[radio].checked) {
	      tag = true;
	      val = radios[radio].value;
	      break;
	   }
	}
	if(!tag) {
		document.getElementById(id).innerHTML= strName+"不能为空！";
		document.getElementById(id).focus();
		return false;
	} 
	else {
		document.getElementById(id).innerHTML= "";
		return true;
	}
}

function CheckNullAndLengthAndCharacter(idText,strName,id)
{
	var b = /^[0-9a-zA-Z]*$/g;
	if(document.getElementById(idText).value == "")
	{
		document.getElementById(id).innerHTML= strName+"不能为空！";
		document.getElementById(id).focus();
		return false;
	}
	else if(!b.test(document.getElementById(idText).value))
	{
		document.getElementById(id).innerHTML= strName+"只能包含数字和字母！";
		document.getElementById(id).focus();
		return false;
	}
	else if(document.getElementById(idText).value.length<3 || document.getElementById(idText).value.length>20)
	{
		document.getElementById(id).innerHTML= strName+"长度必须在3~20之间！";
		document.getElementById(id).focus();
		return false;
	}
	document.getElementById(id).innerHTML= "";
	return true;
}

function CheckNumAndCharacter(idText,strName,id)
{
	var b = /^[0-9a-zA-Z]*$/g;
	if(!b.test(document.getElementById(idText).value))
	{
		document.getElementById(id).innerHTML= strName+"只能包含数字和字母！";
		document.getElementById(id).focus();
		return false;
	}
	document.getElementById(id).innerHTML= "";
	return true;
}

function CheckTelPhone(idText,strName,id)
{
	 var reg = /^0?1[3|4|5|7|8][0-9]\d{8}$/; 
	 if (!reg.test(document.getElementById(idText).value)) { 
		 document.getElementById(id).innerHTML= strName+"长度为11位，以13/14/15/17/18开头！";
		 document.getElementById(id).focus();
		 return false;
	 }
	 document.getElementById(id).innerHTML= "";
	 return true;
}

function CheckMail(idText,id)
{
	 var pattern = /^([\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;  
	 if (!pattern.test(document.getElementById(idText).value)) { 
		 document.getElementById(id).innerHTML= "请输入正确的邮箱格式 ！";
		 document.getElementById(id).focus();
		 return false;
	 }
	 document.getElementById(id).innerHTML= "";
	 return true;
}

function CheckName(idText,strName,id)
{
	 var pattern =/^([\u4E00-\uFA29]*[a-z]*[A-Z]*)+$/;
	 if (!pattern.test(document.getElementById(idText).value)) { 
		 document.getElementById(id).innerHTML= strName+"只能是中文或者英文形式 ！";
		 document.getElementById(id).focus(); 
		 return false;
	 }
	 else if(document.getElementById(idText).value.length<2 || document.getElementById(idText).value.length>20)
	 {
		document.getElementById(id).innerHTML= strName+"长度必须在2~20之间！";
		document.getElementById(id).focus();
		return false;
	 }	
	 document.getElementById(id).innerHTML= "";
	 return true;
}

function CheckTDNickName(idText,strName,id)
{
	 var pattern =/^([\u4E00-\uFA29]*[a-z]*[A-Z]*)+$/;
	 if (!pattern.test(document.getElementById(idText).value)) { 
		 document.getElementById(id).innerHTML= strName+"只能是中文或者英文形式 ！";
		 document.getElementById(id).focus(); 
		 return false;
	 }
	 else if(document.getElementById(idText).value.length<2 || document.getElementById(idText).value.length>20)
	 {
		document.getElementById(id).innerHTML= strName+"长度必须在2~20之间！";
		document.getElementById(id).focus();
		return false;
	 }	
	 document.getElementById(id).innerHTML= "";
	 return true;
}

/*function CheckName1(idText,strName,id,index)
{
	 var pattern =/^([\u4E00-\uFA29]*[a-z]*[A-Z]*)+$/;
	 if (!pattern.test(document.getElementById(idText+index).value)) { 
		 document.getElementById(id+index).innerHTML= strName+"只能是中文或者英文形式 ！";
		 document.getElementById(id+index).focus(); 
		 return false;
	 }
	 else if(document.getElementById(idText+index).value.length<2 || document.getElementById(idText+index).value.length>20)
	 {
		document.getElementById(id+index).innerHTML= strName+"长度必须在2~20之间！";
		document.getElementById(id+index).focus();
		return false;
	 }	
	 document.getElementById(id+index).innerHTML= "";
	 return true;
}*/

function CheckPhotoType(idText,strName,id){
	 var filepath = document.getElementById(idText).value; 
	 var re = /(\\+)/g; 
	 var filename=filepath.replace(re,"#");
	 var one=filename.split("#");
	 var two=one[one.length-1];
	 var three=two.split(".");
	 var last=three[three.length-1];
	 var tp ="bmp,pcx,tiff,gif,jpg,png,gif,jpeg,tga,exif,fpx,svg,psd,cdr,pcd,dxf,ufo,eps,ai,hdri,raw";
	 var rs=tp.indexOf(last);
/*	 var img=null;
	 img=document.createElement("img");  
	 img.src=location;*/
/*	 var obj_img = document.getElementById(idText);
     obj_img.dynsrc=obj_file.value;
     filesize = obj_img.fileSize;
     alert(filesize); */
     
    

/*	 var fileSize = 0;
	 var ie = !-[1,];*/
	 
	 
	 if(document.getElementById(idText).value == "")
	 {
		 document.getElementById(id).innerHTML= strName+"不能为空！";
		 document.getElementById(id).focus();
		 return false;
	 }
	 else if(rs<0)
	 {
		 document.getElementById(id).innerHTML= strName+"必须为有效的图片文件！";
		 document.getElementById(id).focus();
		 return false;
	 }
/*	 else if(img.fileSize>1)
	 {
		 document.getElementById(id).innerHTML= strName+"大小必须小于10M ！";
		 document.getElementById(id).focus();
		 return false;
	 }	 */

	 
	
/*	 if (ie && document.getElementById(idText).fileSize>10)
	 {
		 alert("ie" + document.getElementById(idText).fileSize);
	 }
	 if (!ie) {
		 fileSize = document.getElementById(idText).files[0].size;
	 	 
		 if(fileSize>10485760)
		 {
			 document.getElementById(id).innerHTML= strName+"大小必须小于10M ！";
			 document.getElementById(id).focus();
			 return false;
		 }	 
	}*/
		 
	 
	 document.getElementById(id).innerHTML= "";
	 return true;
}

function CheckPhotoType1(idText,strName,id,index){
	 var filepath = document.getElementById(idText+index).value; 
	 var re = /(\\+)/g; 
	 var filename=filepath.replace(re,"#");
	 var one=filename.split("#");
	 var two=one[one.length-1];
	 var three=two.split(".");
	 var last=three[three.length-1];
	 var tp ="bmp,pcx,tiff,gif,jpg,png,gif,jpeg,tga,exif,fpx,svg,psd,cdr,pcd,dxf,ufo,eps,ai,hdri,raw";
	 var rs=tp.indexOf(last);
	 var fileSize = 0;
	 var isIE = /msie/i.test(navigator.userAgent) && !window.opera;
	 if(document.getElementById(idText+index).value == "")
	 {
		 document.getElementById(id+index).innerHTML= strName+"不能为空！";
		 document.getElementById(id+index).focus();
		 return false;
	 }
	 else if(rs<0)
	 {
		 document.getElementById(id+index).innerHTML= strName+"必须为有效的图片文件！";
		 document.getElementById(id+index).focus();
		 return false;
	 }
	 
	 if (isIE)
	 {
		 var img=null;
		 img=document.createElement("img");  
		 img.src=location;
		 fileSize = img.fileSize;
	 }
	 else
	 {
		 fileSize = document.getElementById(idText+index).files[0].size;
	 }
	 	 
	 if(fileSize>10485760)
	 {
		 document.getElementById(id+index).innerHTML= strName+"大小必须小于10M ！";
		 document.getElementById(id+index).focus();
		 return false;
	 }	 
	 document.getElementById(id+index).innerHTML= "";
	 return true;
}


function CheckPdfType(idText,strName,id){
	 var filepath = document.getElementById(idText).value; 
	 var re = /(\\+)/g; 
	 var filename=filepath.replace(re,"#");
	 var one=filename.split("#");
	 var two=one[one.length-1];
	 var three=two.split(".");
	 var last=three[three.length-1];
	 var tp ="pdf";
	 var rs=tp.indexOf(last);
	 
	 if(document.getElementById(idText).value == "")
	 {
		 document.getElementById(id).innerHTML= strName+"不能为空！";
		 document.getElementById(id).focus();
		 return false;
	 }
	 else if(rs<0)
	 {
		 document.getElementById(id).innerHTML= strName+"必须为有效的pdf文件！";
		 document.getElementById(id).focus();
		 return false;
	 }
	 document.getElementById(id).innerHTML= "";
	 return true;
	
}

function CheckZipType(idText,strName,id){
	 var filepath = document.getElementById(idText).value; 
	 var re = /(\\+)/g; 
	 var filename=filepath.replace(re,"#");
	 var one=filename.split("#");
	 var two=one[one.length-1];
	 var three=two.split(".");
	 var last=three[three.length-1];
	 var tp ="zip";
	 var rs=tp.indexOf(last);
	 
	 if(document.getElementById(idText).value == "")
	 {
		 document.getElementById(id).innerHTML= strName+"不能为空！";
		 document.getElementById(id).focus();
		 return false;
	 }
	 else if(rs<0)
	 {
		 document.getElementById(id).innerHTML= strName+"必须为有效的zip压缩文件！";
		 document.getElementById(id).focus();
		 return false;
	 }
	 document.getElementById(id).innerHTML= "";
	 return true;
	
}

function CheckAdminForm()
{
	 if (CheckNullAndLengthAndCharacter('adminNumber','管理员编号','adminNumberError')&&
		 CheckNullAndLengthAndCharacter('loginName','登录名','loginNameError')&&
		 CheckNullAndLengthAndCharacter('adminPassword','密码','adminPasswordError')&&
		 CheckName('adminName','姓名','adminNameError')&&CheckNull('adminDepartment','所属部门','adminDepartmentError')&&
		 CheckRadios('adminSex','性别','adminSexError')&&CheckTelPhone('adminPhoneNumber','手机号','adminPhoneNumberError')&&
		 CheckNull('adminRole','权限等级','adminRoleError')&&CheckMail('adminMail','adminMailError'))
	 { 
		 return true;
	 }
	 else
		 return false;	 
}

function CheckTdForm()
{
	 if (CheckName('cityName','旅游地名称','cityNameError')&&
		 CheckNull('province','所属省份','provinceError')&&
		 CheckNull('area','所属区域','areaError')&&
		 CheckRadios('topSeason','热门季节','topSeasonError')&&CheckRadios('themeType','主题类型','themeTypeError')&&
		 CheckNull('homeOrAbroad','国内或国外','homeOrAbroadError')&&CheckNull('isHomeTopSeason','是否为首页热门季节推荐','isHomeTopSeasonError')&&
		 CheckNull('isHomeThemeType','是否为首页热门主题目的地推荐','isHomeThemeTypeError')&&CheckNull('isTopSeason','是否为热门季节推荐','isTopSeasonError')&&
		 CheckNull('isThemeType','是否为热门主题目的地推荐','isThemeTypeError')&&CheckTDNickName('themeNickname','主题类型昵称','themeNicknameError')
		 && CheckNull('isPublic','是否发布','isPublicError'))
	 { 
		 return true;
	 }
	 else
		 return false;	 
}

function CheckTdEditForm()
{
	 if (CheckNull('province','所属省份','provinceError')&&
		 CheckNull('area','所属区域','areaError')&&
		 CheckRadios('topSeason','热门季节','topSeasonError')&&CheckRadios('themeType','主题类型','themeTypeError')&&
		 CheckNull('homeOrAbroad','国内或国外','homeOrAbroadError')&&CheckNull('isHomeTopSeason','是否为首页热门季节推荐','isHomeTopSeasonError')&&
		 CheckNull('isHomeThemeType','是否为首页热门主题目的地推荐','isHomeThemeTypeError')&&CheckNull('isTopSeason','是否为热门季节推荐','isTopSeasonError')&&
		 CheckNull('isThemeType','是否为热门主题目的地推荐','isThemeTypeError')&&CheckTDNickName('themeNickname','主题类型昵称','themeNicknameError')
		 && CheckNull('isPublic','是否发布','isPublicError'))
	 { 
		 return true;
	 }
	 else
		 return false;	 
}

function CheckStrategyForm()
{
	 if (CheckName('cityName','城市名','cityNameError')&&
			 CheckNull('isTop','是否热门','isTopError')&&
			 CheckPhotoType('photoFileName','攻略图片','photoFileNameError')&&
			 CheckPdfType('uploadFileName','攻略PDF文件','uploadFileNameError')&&
			 CheckZipType('jpgFileName','攻略JPG文件','jpgFileNameError'))
	 { 
		 return true;
	 }
	 else
		 return false;	 
}

function CheckStrategyEditForm()
{
	 if (CheckName('cityName','城市名','cityNameError')&&
			 CheckNull('isTop','是否热门','isTopError'))
	 { 
		 return true;
	 }
	 else
		 return false;	 
}


function CheckQuestionForm()
{
	 if (CheckNull('questionName','问题名称','questionNameError')&&
		 CheckNull('questionContent','回答内容','questionContentError'))
	 { 
		 return true;
	 }
	 else
		 return false;	 
}

function CheckStrategyTopPhotoForm()
{
	 if (CheckPhotoType('uploadFileName','攻略首页滚动图片','uploadFileNameError')&&
			 CheckNull('isTop','是否热门','isTopError'))
	 { 
		 return true;
	 }
	 else
		 return false;	 
}

function CheckTopPhotoForm()
{
	 if (CheckPhotoType('uploadFileName','首页滚动图片','uploadFileNameError')&&
			 CheckNull('isTop','是否热门','isTopError')&&
			 CheckNull('topPhotoCity','所属城市','topPhotoCityError'))
	 { 
		 return true;
	 }
	 else
		 return false;	 
}
function CheckTopPhotoEditForm()
{
	 if (CheckNull('isTop','是否热门','isTopError')&&
		CheckNull('topPhotoCity','所属城市','topPhotoCityError'))
	 { 
		 return true;
	 }
	 else
		 return false;	 
}

function CheckTravelnoteTopPhotoForm()
{
	 if (CheckPhotoType('uploadFileName','游记首页滚动图片','uploadFileNameError')&&
			 CheckNull('isTop','是否热门','isTopError'))
	 { 
		 return true;
	 }
	 else
		 return false;	 
}

function CheckNum(idText,strName,id)
{
	var b = /^[1-9]{1}[0-9]*$/g;
	if(!b.test(document.getElementById(idText).value))
	{
		document.getElementById(id).innerHTML= strName+"只能包含数字！";
		document.getElementById(id).focus();
		return false;
	}
	document.getElementById(id).innerHTML= "";
	return true;
}


function CheckPhone(idText,strName,id)
{
	//var reg = /^0[1-9]{2,3}-[0-9]{7,8}$/;
	var reg=/^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$|(^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\d{8}$)/;
	if(!reg.test(document.getElementById(idText).value)){
		document.getElementById(id).innerHTML = strName +"格式应类似010-63392078！";
		document.getElementById(id).focus();
		return false;
	}
	document.getElementById(id).innerHTML="";
	return true;
}

function CheckCellphone(idText,strName,id){
	if(CheckPhone(idText, strName, id)||CheckTelPhone(idText, strName, id)){
		document.getElementById(id).innerHTML="";
		return true;
	}else{
		document.getElementById(id).innerHTML="请输入正确的手机号码或带区号的固话号码如010-63392078！";
		document.getElementById(id).focus();
		return false;
	}
}

function CheckProductForm(){
	 if (CheckNull('productName','产品名称','productNameError')&&
			 CheckName('cityName','游玩城市','cityNameError')&&
			 CheckNull('isTop','是否热门','isTopError')&&
			 CheckNum('productPrice','产品价格','productPriceError')&&
			 CheckCellphone('productCellphone','产品联系电话','productCellphoneError')&&
			 CheckNull('sdate','开始日期','sdateError')&&
			 CheckNull('edate','结束日期','edateError')&&
			 CheckDayNum('proDays','行程天数','proDaysError')){ 
		 return true;
	}else
		 return false;
}

function CheckEditProductForm(){
	 if (CheckNull('productName','产品名称','productNameError')&&
			 CheckName('cityName','游玩城市','cityNameError')&&
			 CheckNull('isTop','是否热门','isTopError')&&
			 CheckNum('productPrice','产品价格','productPriceError')&&
			 CheckCellphone('productCellphone','产品联系电话','productCellphoneError')&&
			 CheckNull('startdate','开始日期','startdateError')){ 
		 return true;
	}else
		 return false;
}

function CheckEditJourneyForm(){
	 if (CheckNum('journeyDayNumber','行程第几天','journeyDayNumberError')&&
			 CheckNull('journeyTitle','行程题目','journeyTitleError')){ 
		 return true;
	}else
		 return false;
}

function CheckAdd1JourneyForm(){
	 if (CheckDayNum('journeyDayNumber','行程第几天','journeyDayNumberError')&&
			 CheckNull('journeyTitle','行程题目','journeyTitleError')&&
			 CheckPhotoType('jfile','行程文件','jfileError')){ 
		 return true;
	}else
		 return false;
}

function CheckAddJourneyForm(proDays){
	var i=0;
	while(i<proDays){
		if(!CheckNull('journeyTitle','行程题目','journeyTitleError',i)||
				!CheckPhotoType1('journeyFile','行程文件','journeyFileError',i)){
			return false;
		}
		i++;
	}
	return true;
}

/*function CheckTravelNotePublishForm(){
	if (CheckName('travelNoteName','游记标题','travelNoteNameError')&&
			CheckName('cityName','城市名','cityNameError')){
		return true;
	}else
		 return false;
}*/
function CheckDayNum(idText,strName,id)
{
	var b = /^[1-9]{1}[0-9]*$/g;
	if(!b.test(document.getElementById(idText).value))
	{
		document.getElementById(id).innerHTML= strName+"只能包含数字！";
		document.getElementById(id).focus();
		return false;
	}
	if(document.getElementById(idText).value > 100){
		document.getElementById(id).innerHTML= strName+"不能大于100！";
		document.getElementById(id).focus();
		return false;
	}
	document.getElementById(id).innerHTML= "";
	return true;
}

function CheckThemeForm(){
	if(CheckName('themeName','主题名','themeNameError')&&CheckNull('themeIsTop','是否推送主页','themeIsTopError')&&CheckPhotoType('themeFileName','主题图片','themeFileNameError')){
		return true;
	}else{
		return false;
	}
}

function CheckEditThemeForm(){
	if(CheckName('themeName','主题名','themeNameError')&&CheckNull('themeIsTop','是否推送主页','themeIsTopError')){
		return true;
	}else{
		return false;
	}
}
