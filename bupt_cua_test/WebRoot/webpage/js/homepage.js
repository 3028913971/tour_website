$(function () {
	slider(1424);
    $("nav").find("li").eq(0).addClass("nav_active");
    $("#theme >div:last").addClass("last");
    $(".wrap_gonglve:visible>div:last").addClass("last");
    $("#now_hot >div:last").addClass("last");
    //������������ʽ
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
    //Сͼ����꾭��Ч��
    $(".item").mouseover(
            function () {
                var new_index = $(this).index();//�õ���ǰ����������
                $(".travel_right").find(".sub_item").eq(new_index)
                        .show().siblings().hide();//�ҵ����������Ӧ�������ʹ����ʾ
            });
    $(".item").mouseout(function () {
        $(this).find(".item_icon").css("color", "#b951bb");
        var new_index = $(this).index();
    });
    $(".sub_item").bind("mouseenter", function () {
        //��������
        // alert("dd")
    });
    $(".sub_item").bind("mouseleave", function () {
        //��������
        $(this).hide();
    });

});