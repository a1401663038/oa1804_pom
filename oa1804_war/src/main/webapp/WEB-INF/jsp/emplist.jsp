<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2022/4/10
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="${pageContext.request.getContextPath()}/"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>职工管理</title>
    <!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
    <!-- Reset Stylesheet -->
    <link rel="stylesheet" href="resources/css/reset.css" type="text/css"
          media="screen" />
    <!-- Main Stylesheet -->
    <link rel="stylesheet" href="resources/css/style.css" type="text/css"
          media="screen" />
    <link rel="stylesheet" href="resources/css/invalid.css" type="text/css"
          media="screen" />

    <!--                       Javascripts                       -->
    <!-- jQuery -->
    <script type="text/javascript"
            src="resources/scripts/jquery-1.8.3.min.js"></script>
    <!-- jQuery Configuration -->
    <script type="text/javascript"
            src="resources/scripts/simpla.jquery.configuration.js"></script>

    <script type="text/javascript " src="resources/widget/dialog/jquery-ui-1.9.2.custom.min.js"></script>

    <link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">

    <!--时间控件-->
    <script type="text/javascript" src="${pageContext.request.getContextPath()}/resources/widget/My97DatePicker/WdatePicker.js"></script>

    <!-- ztree树形结构-->
    <link rel="stylesheet" href="resources/widget/zTree/zTreeStyle/zTreeStyle.css">
    <script type="text/javascript" src="resources/widget/zTree/jquery.ztree.all.min.js"></script>


    <link rel="stylesheet" type="text/css" href="resources/widget/webuploader/webuploader.css">

    <script type="text/javascript" src="resources/widget/webuploader/webuploader.min.js"></script>

    <script type="text/javascript">
        //提出新增框
        function opemDialog () {
            $("#id").val("");
            //alert(data.id);
            //处理照片
            $("#header").attr("src","resources/images/icons/header.jpg");
            //处理职工姓名
            $("#name_id").val("");

            $("#email_id").val("");

            $("#password_id").val("");

            $("input[name='sex'][value=' "+ 1 + "']").attr("checked","checked");

            $("#phone_id").val("");

            $("#select_dep_id").html("无");

            $("#did").val("");

            $("#einfo_id").val("");

            $("#birthday_id").val("");

            $("#entrytime_id").val("");

            $("#emp_dialog").dialog({
                title:"新增员工",
                width:600,
                height:500,
                modal: true

            });

        }
            //选择部门
        function  query_deps_ajax() {
            $.ajax({
                url:"${pageContext.request.contextPath}/dep/queryAll",
                success:function (data) {
                    // console.log(data)
                    var settings = {
                        data:{
                            key:{
                                name:"dname"
                            },simpleData: {
                                enable:true,
                                pIdKey: "pid"
                            }
                        },view:{
                            showIcon:false
                        },callback:{
                            onClick: function (event,treeId,treeNode) {
                                //alert("当前点击了"+treeNode.dname);
                                $("#select_dep_id").html(treeNode.dname);
                                $("#did").val(treeNode.id);
                                $("#ztree_dialog").dialog("close");
                            }
                        }
                    };
                    var zNodes=data;
                    var ele=$("#ztree");

                    var ztreeObject= $.fn.zTree.init(ele,settings,zNodes);
                    ztreeObject.expandAll(true);

                    //选择部门的回响
                    var did=$("#did").val();

                    if(did != null&& did !=""){
                        //说明已经选中了一个部门

                        var nodes = ztreeObject.getNodesByParam("id", did, null);

                        ztreeObject.selectNode(nodes[0]);
                    }

                    $("#ztree_dialog").dialog({
                        title: "选择部门",
                        width: 300,
                        height: 200,
                        modal: false
                    });
                },dataType: "json"
            })

        }
            function update_user(eid) {
                $.ajax({
                    url:"${pageContext.request.contextPath}/emp/querById",
                    data: {eid:eid},

                    success :function (data) {
                        //alert(data);
                        //将职工信息填充到dialog上面
                        $("#id").val(data.id);
                        //alert(data.id);

                        //处理照片
                        if(data.image!=null&& data.image!=""){
                            $("#header").attr("src","${pageContext.request.contextPath}/img/getImg?path=" + data.image);
                            $("#image").val(data.image);
                        }else{
                            $("#header").attr("src","resources/images/icons/header.jpg");

                        }
                        //处理职工姓名
                        $("#name_id").val(data.name);

                        $("#email_id").val(data.email);

                        $("#password_id").val(data.password);

                        $("input[name='sex'][value=' "+ data.sex + "']").attr("checked","checked");

                        $("#phone_id").val(data.phone);

                        $("#select_dep_id").html(data.did);

                        $("#did").val(data.did);

                        $("#einfo_id").val(data.einfo);

                        var birthday=new Date(data.birthday);

                        var entrytime=new Date(data.entrytime);

                        $("#birthday_id").val(birthday.getFullYear() + "-" + (birthday.getMonth()+1) + "-" + birthday.getDate());

                        $("#entrytime_id").val(entrytime.getFullYear() + "-" + (entrytime.getMonth()+1) + "-" + entrytime.getDate());

                        //alert(data.birthday);

                        //alert(data.entrytime);

                        $("#emp_dialog").dialog({
                            title:"修改员工",
                            width:600,
                            height:500,
                            modal:true
                        });
                    },dataType: "json"
                });

            }

        function  open_roles_dialog(eid) {

            $("input[name='eid']").val(eid);
            $.ajax({
                url:"${pageContext.request.contextPath}/role/queryall",
                data:{eid:eid},
                success :function (data) {

                    var html="<ul>";
                    for(var i=0;i<data.length;i++){
                        html+="<li>";
                        if(data[i].isHave){
                            html+="<input type='checkbox' name='rid'  value=' "+ data[i].id +"'checked/>";
                        }else {
                            html+="<input type='checkbox' name='rid'  value=' "+ data[i].id +"'/>";
                        }


                        html +=data[i].rolename;

                        html+="</li>";

                    }
                    html +="</ul>";
                    $("#role_list").html(html);

                    $("#role_dialog").dialog({
                        title:"选择角色",
                        width:300,
                        height:200,
                        modal: true

                    });
                },dataType: "json"
            });

        }


    </script>

</head>
<body>
<div id="main-content">
    <div class="content-box">
        <!-- End .content-box-header -->
        <div class="content-box-content">
            <div class="tab-content default-tab" id="tab1">

                <h1>职工的管理</h1>
                <table>
                    <thead>
                    <tr>
                        <th><input class="check-all" type="checkbox" /></th>
                        <th>编号</th>
                        <th>姓名</th>
                        <th>照片</th>
                        <th>性别</th>
                        <th>所属部门</th>
                        <th>入职时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>


                    <!-- 表的内容-->
                    <tbody>
                        <c:forEach items="${emps}" var="emp">
                            <tr>
                                <th><input class="check-all" type="checkbox" /></th>
                                <th>${emp.id}</th>
                                <th>${emp.name}</th>
                                <th>

                                    <c:if test="${emp.image == null}">
                                        <img   src="resources/images/icons/header.jpg" width="100">
                                    </c:if>
                                    <c:if test="${emp.image != null}">
                                        <img src="${pageContext.request.contextPath}/img/getImg?path=${emp.image}"width="100">
                                    </c:if>



                                </th>
                                <th>${emp.sex==1? '男':'女'}</th>
                                <th>${emp.department.dname}</th>
                                <th><fmt:formatDate value="${emp.entrytime}" pattern="yyyy-MM-dd"/> </th>
                                <th>
                                    <a  title="Edit"  onclick="update_user(${emp.id});"><img
                                            src="resources/images/icons/pencil.png" alt="Edit" />
                                    </a>

                                    <a href="#" title="Delete"><img
                                            src="resources/images/icons/cross.png" alt="Delete" />
                                    </a>
                                    <!-- 选择相应职工的角色-->
                                    <a  title="Edit"  onclick="open_roles_dialog(${emp.id});"><img
                                            src="resources/images/icons/pencil.png" alt="Edit" />
                                    </a>

                                   <!-- <a href="#" title="Edit Meta" onclick="open_roles_dialog();"><img
                                            src="resources/images/icons/hammer_screwdriver.png"
                                            alt="Edit Meta" /></a>  -->
                                </th>
                            </tr>
                        </c:forEach>

                    </tbody>

                    <!-- 表的尾部-->
                    <tfoot>
                    <tr>
                        <td colspan="6">
                            <div class="bulk-actions align-left">
                                <shiro:hasPermission name="/emp/insert">
                                    <a class="mybutton" onclick="opemDialog();">新增员工</a>
                                </shiro:hasPermission>

                            </div>
                            <div class="pagination">
                                <a href="#" title="First Page">&laquo; First</a><a href="#"
                                                                                   title="Previous Page">&laquo; Previous</a> <a href="#"
                                                                                                                                 class="number" title="1">1</a> <a href="#" class="number"
                                                                                                                                                                   title="2">2</a> <a href="#" class="number current" title="3">3</a>
                                <a href="#" class="number" title="4">4</a> <a href="#"
                                                                              title="Next Page">Next &raquo;</a><a href="#"
                                                                                                                   title="Last Page">Last &raquo;</a>
                            </div> <!-- End .pagination -->
                            <div class="clear"></div>
                        </td>
                    </tr>
                    </tfoot>

                </table>
            </div>
        </div>
        <!-- End .content-box-content -->
    </div>
</div>
<!-- End #main-content -->

<div id="emp_dialog" style="display: none" >
    <form action="${pageContext.request.getContextPath()}/emp/insert" method="post" >
        <fieldset>
            <!-- Set class to "column-left" or "column-right" on fieldsets to divide the form into columns -->
            <input name="id" id="id" type="hidden" value=""/>
            <p>
                <label>照片</label>
                <img  id="header" src="resources/images/icons/header.jpg" width="100">
                <input type="hidden" id="image" name="image" value=""/>
            <div id="filePicker">选择图片</div>
            </p>


            <p>
                <label>员工姓名</label>
                <input class="text-input small-input" type="text" id="name_id"
                       name="name" />
            </p>

            <p>
                <label>邮箱</label>
                <input class="text-input small-input" type="text" id="email_id"
                       name="email" />
            </p>

            <p>
                <label>密码</label>
                <input class="text-input small-input" type="password" id="password_id"
                       name="password" />
            </p>



            <p>
                <label>性别</label>
                <input type="radio" name="sex" value="1" checked/>男
                <input type="radio" name="sex" value="0"/>女

            </p>

            <p>
                <label>电话</label>
                <input class="text-input small-input" type="text" id="phone_id"
                       name="phone" />
            </p>

            <p>
                <label>选择部门</label>
                <button id="select_dep_id" class="mybutton" type="button" onclick="query_deps_ajax();">无</button>
                <input type="hidden" id="did" name="did" value="-1"/>

            </p>
            <p>
                <label>个人简介</label>
                <textarea class="text-input textarea wysiwyg" id="einfo_id"
                          name="einfo" cols="79" rows="15"></textarea>
            </p>

            <p>
                <label>生日</label>
                <input  class="Wdate" type="text"
                        id="birthday_id" name="birthday" onclick="WdatePicker()" />
            </p>


            <p>
                <label>入职时间</label>
                <input  class="Wdate" type="text"
                        id="entrytime_id" name="entrytime" onclick="WdatePicker()" />
            </p>

            <p>
                <input class="mybutton" type="submit" value="提交" />
            </p>
        </fieldset>
        <div class="clear"></div>
        <!-- End .clear -->
    </form>

</div>


<div id="ztree_dialog" style="display: none">
    <div id="ztree" class="ztree">

    </div>
</div>

<div id="role_dialog" style="display: none">

    <form action="${pageContext.request.contextPath}/role/selectroles" method="post">
        <input type="hidden" name="eid" value=""/>
    <div id="role_list"></div>
    <button type="submit" class="mybutton">提交</button>

    </form>
</div>


<script type="text/javascript">
     var uploader = WebUploader.create({

        // 选完文件后，是否自动上传。
        auto: true,

        // swf文件路径
        swf: '${pageContext.request.contextPath}/resources/widget/webuploader/Uploader.swf',

        // 文件接收服务端。
        server: '${pageContext.request.contextPath}/img/upload',

        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: '#filePicker',
    });

     // 当有文件添加进来的时候
     uploader.on( 'fileQueued', function( file ) {

         var img=$("#header")

         // 创建缩略图
         // 如果为非图片文件，可以不用调用此方法。
         // thumbnailWidth x thumbnailHeight 为 100 x 100
         uploader.makeThumb( file, function( error, src ) {
             if ( error ) {
                 $img.replaceWith('<span>不能预览</span>');
                 return;
             }

             img.attr( 'src', src );
         }, 100, 100 );
     });
     uploader.on('uploadSuccess',function (file,response) {
            //alert(response.fileuploader);
            $("#image").val(response.fileuploader)
     })

     uploader.on('error',function (type) {
            //文件上传失败
     })


</script>
</body>
</html>
