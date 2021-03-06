<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2022/4/10
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="shir" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Simpla Admin</title>
    <!--                       CSS                       -->
    <!-- Reset Stylesheet -->
    <link rel="stylesheet" href="../../resources/css/reset.css" type="text/css"
          media="screen" />
    <!-- Main Stylesheet -->
    <link rel="stylesheet" href="../../resources/css/style.css" type="text/css"
          media="screen" />
    <link rel="stylesheet" href="../../resources/css/invalid.css" type="text/css"
          media="screen" />
    <!--                       Javascripts                       -->
    <!-- jQuery -->
    <script type="text/javascript"
            src="../../resources/scripts/jquery-1.3.2.min.js"></script>
    <!-- jQuery Configuration -->
    <script type="text/javascript"
            src="../../resources/scripts/simpla.jquery.configuration.js"></script>
    <!-- Facebox jQuery Plugin -->
    <script type="text/javascript" src="../../resources/scripts/facebox.js"></script>
    <!-- jQuery WYSIWYG Plugin -->
    <script type="text/javascript" src="../../resources/scripts/jquery.wysiwyg.js"></script>
    <style>
        body {
            overflow-x: hidden;
            overflow-y: hidden;
        }
    </style>
    <script type="text/javascript">
        $(function(){
            $("#homeframe").css("height", $(window).height());
        });

        function itemclick(ele){
            $("#homeframe").attr("src", ele.name);
            $(".current").removeClass("current");
            $(ele).addClass("current");
        }
    </script>
</head>
<body>
<div id="body-wrapper">
    <!-- Wrapper for the radial gradient background -->
    <div id="sidebar">
        <div id="sidebar-wrapper">
            <!-- Sidebar with logo and menu -->
            <h1 id="sidebar-title">
                <a href="#">Simpla Admin</a>
            </h1>
            <!-- Logo (221px wide) -->
            <a href="#"><img id="logo" src="../../resources/images/logo.png"
                             alt="Simpla Admin logo" /></a>
            <!-- Sidebar Profile links -->
            <div id="profile-links">
                ??????, <a title="Edit your profile">
                <shiro:user>
                    <shiro:principal property="name"/>
                </shiro:user>

                </a>,

                ?????? <a>0 ?????????</a><br />
                <br /> <a title="????????????">????????????</a> | <a href="/oa/logout"
                                                     title="Sign Out">??????</a>
            </div>

            <!-- ???????????? -->
            <ul id="main-nav">
                <li><a onclick="itemclick(this);" name="/index/home"
                       class="nav-top-item no-submenu"> ?????? </a></li>
<%--                <li><a class="nav-top-item"> ???????????? </a>--%>
<%--                    <ul>--%>
<%--                        <li><a onclick="itemclick(this);" name="dep/deplist">????????????</a></li>--%>
<%--                        <li><a onclick="itemclick(this);" name="emp/emplist">????????????</a></li>--%>
<%--                        <li><a onclick="itemclick(this);" name="role/rolelist">????????????</a></li>--%>
<%--                        <li><a onclick="itemclick(this);" name="resc/resclist">????????????</a></li>--%>
<%--                    </ul>--%>
<%--                </li>--%>

                    <c:forEach items="${emp.rescs}" var="resc">
                        <c:if test="${resc.rstate==1}">
                            <!--????????????-->
                            <li><a class="nav-top-item"> ${resc.rname} </a>
                                <ul>
                                    <c:forEach items="${emp.rescs}" var="resc2" >
                                        <c:if test="${resc2.rstate==2&& resc2.pid==resc.id}">
                                            <li><a onclick="itemclick(this);" name="${resc2.rpath}">${resc2.rname}</a></li>
                                        </c:if>
                                    </c:forEach>
                                </ul>
                            </li>
                        </c:if>

                    </c:forEach>
            </ul>
        </div>
    </div>
    <!-- End #sidebar -->
    <iframe id="homeframe" name="homeframe" src="/index/home"
            width="100%" scrolling="auto" />
</div>
</body>
<!-- Download From www.exet.tk-->
</html>

