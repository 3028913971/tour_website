$(function () {
	slider(1424);
    $("nav").find("li").eq(0).addClass("nav_active");
    $("#theme >div:last").addClass("last");
    $(".wrap_gonglve:visible>div:last").addClass("last");
    $("#now_hot >div:last").addClass("last");
    //攻略下载排序方式
    $(".sort a").click(function () {
        $(this).addClass("active").siblings().removeClass("active");
        var index = $(this).index();
        if (index == 0) {
            $("div.wrap_gonglve").eq(1).hide();
            $("div.wrap_gonglve").eq(2).hide();
            $("div.wrap_gonglve").eq(0).fadeIn("slow");

        }
        if (index == 2) {
            $("div.wrap_gonglve").eq(0).hide();
            $("div.wrap_gonglve").eq(2).hide();
            $("div.wrap_gonglve").eq(1).fadeIn("slow");
            $(".wrap_gonglve:visible>div:last").addClass("last");
        }
        if (index == 4) {
            $("div.wrap_gonglve").eq(0).hide();
            $("div.wrap_gonglve").eq(1).hide();
            $("div.wrap_gonglve").eq(2).fadeIn("slow");
            $(".wrap_gonglve:visible>div:last").addClass("last");
        }
    });
    //小图标鼠标经过效果
    $(".item").mouseover(
            function () {
                var new_index = $(this).index();//得到当前经过的索引
                $(".travel_right").find(".sub_item").eq(new_index)
                        .show().siblings().hide();//找到与该索引对应的左边栏使其显示
            });
    $(".item").mouseout(function () {
        $(this).find(".item_icon").css("color", "#b951bb");
        var new_index = $(this).index();
    });
    $(".sub_item").bind("mouseenter", function () {
        //处理流程
        // alert("dd")
    });
    $(".sub_item").bind("mouseleave", function () {
        //处理流程
        $(this).hide();
    });

});