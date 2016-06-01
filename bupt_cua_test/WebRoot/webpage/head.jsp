<%@ page pageEncoding="utf-8" %>

</head>
<body>


<style>

    /*导航菜单start*/
    nav {
        height: 52px;
        margin: 10px auto;
        width: auto;
    }

    nav ul {
        margin-left: 0;
        margin: 0 auto;
        width: 980px;
        height: inherit;
    /*     background-image: linear-gradient(to top, red,  #FFC7C7); */
        box-sizing: border-box;
        background-color: #2577e3;

    }

    nav ul li {
        float: left;
        height: inherit;
        width: 163px;
        text-align: center;
        transition: all 0.5s ease 0s;
        list-style: none;

    }

    nav a {
       line-height: 52px;
    color: white;
    font-family: "Microsoft YaHei UI Light";
    font-size: 16px;
    /* text-decoration: none; */
    /* font-weight: bold; */
    padding: 14px 36px;

    }

    nav li:hover {
        background-color: #216ACA;
    }

    .nav_active {
        background-color: #216ACA;
    }

    /*导航菜单end*/
</style>
<header>
    <nav>

        <ul class="clear_fix">
             <li>
                <a href="<s:url action="homepage_load" namespace="/"/>">攻略首页</a>
            </li>
            <li>
                <a href="<s:url action="cd_loadCity" namespace="/"/>" style="padding:14px 30px">目的地推荐</a>
            </li>
            <li>
                <a href="<s:url action="productPage_pageIsTop" namespace="/"/>">产品推荐</a>
            </li>
            <li>
                <a href="<s:url action="sffirstpage_loadStrategy" namespace="/"/>">攻略下载</a>
            </li>
            <li>
                <a href="<s:url action="travelNoteFirstPage_pageIsTop" namespace="/"/>">攻略游记</a>
            </li>

            <li>
                <a href="<s:url action="wenda_page" namespace="/"/>">指路问答</a>
            </li>
        </ul>
    </nav>
</header>
