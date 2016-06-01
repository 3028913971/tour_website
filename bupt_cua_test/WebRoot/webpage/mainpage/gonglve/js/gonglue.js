 
function subMenu() {
            $(".nav-title").mouseover(function () {
                var $this = $(this);
                $this.parent().addClass("hover").siblings().removeClass("hover");
                $(".nav-title").next().hide();
                $this.next().show();
            });

            $(".nav-panel").bind("mouseleave", function () {
                //��������
                $(this).hide();
            });
        }


function blockSwitch() {
        //�������� ����ʽtab�л�
        $(".uptime_p a").click(function () {
            $(this).addClass("active").siblings().removeClass("active");
            var index = $(this).index();
            if (index == 0) {
                $("div.gl_cw").eq(1).hide();
                $("div.gl_cw").eq(2).hide();
                $("div.gl_cw").eq(0).show("slow");

            }
            if (index == 2) {
                $("div.gl_cw").eq(0).hide();
                $("div.gl_cw").eq(2).hide();
                $("div.gl_cw").eq(1).show("slow");
            }

            if (index == 4) {
                $("div.gl_cw").eq(0).hide();
                $("div.gl_cw").eq(1).hide();
                $("div.gl_cw").eq(2).show("slow");
            }


        });
    }