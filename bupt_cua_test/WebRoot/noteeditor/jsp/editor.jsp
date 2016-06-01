<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <meta charset="utf-8"/>
    <title>联航旅游攻略  游记发表</title>
    <link rel="stylesheet" href="../themes/default/default.css"/>
    <link rel="stylesheet" href="../plugins/code/prettify.css"/>
    <script charset="utf-8" src="../kindeditor-all-min.js"></script>
    <script charset="utf-8" src="../lang/zh_CN.js"></script>
    <script charset="utf-8" src="../plugins/code/prettify.js"></script>
    <script>
        var editor1;
        KindEditor.ready(function (K) {
            editor1 = K.create('textarea[name="content1"]', {
                cssPath: '../plugins/code/prettify.css',
                uploadJson: '../jsp/upload_json.jsp',
                fileManagerJson: '../jsp/file_manager_json.jsp',
                allowFileManager: true,
                themeType: 'simple',
                afterBlur: function () {
                    this.sync();
                }
            });
            prettyPrint();
        });

    </script>

    <style>
        *{
            margin:0;
            padding:0;
        }
        a{
            text-decoration: none;
        }
        .content {
            width: 980px;
            margin: 0 auto;
        }

        .btn {
            display: block;
            width: 140px;
            height: 40px;
            background-color: #FFCC00;
            border: 1px solid white;
            color: white;
            cursor: pointer;
            font-size:17px;
            font-family: "Microsoft YaHei UI";
            margin-top:20px;
            /*box-shadow: 0 4px 10px rgba(110,98,85,.5);*/
        }


        body {
            font-family: "微软雅黑"
        }

        .clear_fix:before, .clear_fix:after {
            clear: both;
            content: "";
            display: block;
        }

        .input-group {
            width: 600px;
            height:80px;
        }

        .input-group input{
            padding: 20px 40px;
            outline: 0px;
            background: #fff;
            border: 1px solid #fff;
            line-height: 20px;
            font-size: 14px;;
            box-shadow: 0 4px 10px rgba(110,98,85,.5);
            transition: .2s linear 0s;
            -webkit-transition: .2s linear 0s;
            -moz-transition: .2s linear 0s;
            -o-transition: .2s linear 0s;
            width: 980px;
            height: 20px;
            box-sizing: border-box;

        }
        .input-group input:focus{
            border: 1px solid rgba(232, 200, 12, 0.55);
            box-shadow: 0 1px 20px rgba(232, 200, 12, 0.95);
        }
        .input-group em{
            font-style: normal;
            color: rgba(128, 128, 128, 0.69);
            font-size: 15px;
            font-family: fantasy;
            margin-top: 6px;
            line-height: 35px;
        }
        #upload{
            /*box-shadow: 0 4px 10px rgba(110,98,85,.5);*/
            -moz-transition: .2s linear 0s;
            -o-transition: .2s linear 0s;
            width: 140px;
            height: 40px;
            box-sizing: border-box;
            margin-bottom: 20px;
            background-color: #FFCC00;
            border: 1px solid white;
        }
        #basic-addon1{
            position: relative;
            top: 9px;
            left:8px;
            color:white;
           font-family:  Microsoft YaHei UI;
        }
        #inputfile{
            opacity: 0;
            padding: 26px;
            position: relative;
            top: -22px;
            width: 155px
        }
    </style>
</head>
<body>
<div>
    <%@ include file="../../webpage/head.jsp" %>
</div>
<div class="content">

    <s:form action="travelNotePublish_publish" namespace="/"
            theme="simple" enctype="multipart/form-data" id="travelNotePublish">
        <div class="input-group">
            <s:textfield name="travelNoteName" placeholder="填写游记标题(2-20字)" cssClass="form-control" id="travel_title"
                         onblur="checkLength(this.id,'标题长度只能在2-20之间')"/>
        </div>
        <div class="input-group">
            <s:textfield name="travelNoteAuthor" cssClass="form-control" placeholder="请输入用户名"/>
        </div>
        <div class="input-group">
            <s:textfield name="cityName" cssClass="form-control" id="travel_name" placeholder="请输入城市名"
                         onblur="checkLength(this.id,'请输入合适的城市名')"/>
        </div>
        <div class="input-group" id="upload">
            <span class="input-group-addon" id="basic-addon1" >选择游记封面图片</span>
            <s:file name="travelnote" cssClass="form-control" id="inputfile"/>
        </div>
			<textarea name="content1" cols="100" rows="8"
                      style="width:980px;height:300px;visibility:hidden;">
			</textarea>
        <input type="button" onclick="CheckTravelNoteForm('travel_title','travel_name')" name="button" value="发表游记"
               class="btn btn-primary"/>

    </s:form>
    <div class="clear_fix"></div>
</div>
<%@ include file="../../webpage/foot.jsp" %>
<script src="../../webpage/js/jquery-1.11.1.min.js"></script>
<script>
    function deleteBtn() {
        $(".ke-inline-block").remove();
        $(".ke-hr").remove();
      //  var btn = document.getElementsByClassName("ke-outline");
        var btn = $(".ke-outline");
        for (i = 0; i < btn.length; i++) {
            var title =btn[i].title;
           // alert(title);
            switch (title){
                case "左对齐":
                case "右对齐":
                case "居中":
                case "两端对齐":
                case "编号":
                case "全选":
                case "段落":
                case "字体":
                case "文字大小":
                case "文字颜色":
                case "文字背景":
                case "粗体":
                case "斜体":
                case "下划线":
                case "图片":
                case "批量图片上传":
                case "插入表情":
                case "编号":
                case "全选":
                case "段落":
                case "字体":
                    break;
                default:
                    //btn[i].style.cssText = "display:none";
                    //$(btn[i]).remove();
                    btn[i].parentNode.removeChild(btn[i]);


            }
        }
    }
    $(document).ready(function() {
        // 任何需要执行的js特效
        deleteBtn();

        $("nav").find("li").eq(4).addClass("nav_active");
        var picList =  document.getElementsByClassName("pic_list")[0];
        if (picList == null)
            $(".foot").css("bottom","-250px");

    });

  //  window.onload = deleteBtn();
    function checkLength(id, info) {
        var text = document.getElementById(id).value;
        if (text.length > 20 || text < 2) {
            $(document.getElementById(id)).nextAll().remove();
            $(document.getElementById(id)).after("<em>" + info + "</em>");
            document.getElementById(id).focus();
        }
        else {
            $(document.getElementById(id)).nextAll().remove();
        }
    }
    function CheckTravelNoteForm(travel_title_id, travel_name_id) {
        var flag = true;
        var text = document.getElementById(travel_title_id).value;
        if (text.length > 20 || text < 2) {
            flag = false;
            checkLength("travel_title", "标题长度只能在2-20之间");
        }
        text = document.getElementById(travel_name_id).value;
        if (text.length > 20 || text < 2) {
            flag = false;
            checkLength("travel_name", "请输入合适的城市名");
        }
        if (flag) {
            /* document.getElementById("content1").value=KE.util.getData('content1'); */
            document.getElementById("travelNotePublish").submit();
        }
    }
</script>


</body>
</html>
<%!
    private String htmlspecialchars(String str) {
        str = str.replaceAll("&", "&amp;");
        str = str.replaceAll("<", "&lt;");
        str = str.replaceAll(">", "&gt;");
        str = str.replaceAll("\"", "&quot;");
        return str;
    }
%>