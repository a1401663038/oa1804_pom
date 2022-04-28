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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="${pageContext.request.getContextPath()}/"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>权限管理</title>
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
        function opemDialog() {
            $("#dialog_div").dialog({
                title:"新增权限",
                width:600,
                height:500,
                modal: true
            });
        }

        function select_parent_resc() {
            $.ajax({
               url:"${pageContext.request.contextPath}/resc/queryall",
                success:function (data) {
                    // console.log(data)
                    var settings = {
                        data:{
                            key:{
                                name:"rname"
                            },simpleData: {
                                enable:true,
                                pIdKey: "pid"
                            }
                        },view:{
                            showIcon:false
                        },callback:{
                            onClick: function (event,treeId,treeNode) {
                                //alert("当前点击了"+treeNode.dname);
                                $("#select_resc_id").html(treeNode.rname);
                                $("#pid").val(treeNode.id);
                                $("#ztree_dialog").dialog("close");
                            },beforeClick: function (treeId,treeNode) {
                                if(treeNode.rstate==3){
                                    alert("三级权限下不能再有子权限")
                                    return false;
                                }else if(treeNode.rstate==1){
                                    $("#rstate_id").html("二级权限");
                                    $("#rstate_id_hidden").val(2);
                                }else if(treeNode.rstate==2){
                                    $("#rstate_id").html("三级权限");
                                    $("#rstate_id_hidden").val(3);
                                }
                                return true;

                            }
                        }
                    };
                    var zNodes=data;
                    var ele=$("#ztree");

                    var ztreeObject= $.fn.zTree.init(ele,settings,zNodes);
                    ztreeObject.expandAll(true);

                    $("#ztree_dialog").dialog({
                        title: "选择父权限",
                        width: 300,
                        height: 200,
                        modal: false
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

                <h1>权限管理</h1>
                <table>
                    <thead>
                    <tr>
                        <th><input class="check-all" type="checkbox" /></th>
                        <th>编号</th>
                        <th>权限名称</th>
                        <th>权限描述</th>
                        <th>权限路径</th>
                        <th>权限类型</th>
                        <th>操作</th>
                    </tr>
                    </thead>


                    <!-- 表的内容-->
                    <tbody>
                        <c:forEach items="${rescs}" var="resc">
                            <tr>
                                <th><input class="check-all" type="checkbox" /></th>
                                <th>${resc.id}</th>
                                <th>${resc.rname}</th>
                                <th>${resc.rdesc}</th>
                                <th>${resc.rpath}</th>
                                <th>

                                    <c:if test="${resc.rstate == 1}">
                                        一级权限
                                    </c:if>
                                    <c:if test="${resc.rstate == 2}">
                                        二级权限
                                    </c:if>
                                    <c:if test="${resc.rstate == 3}">
                                        三级权限
                                    </c:if>



                                <th>
                                    <a  href="#" title="Edit"><img
                                            src="resources/images/icons/pencil.png" alt="Edit" />
                                    </a>

                                    <a href="#" title="Delete"><img
                                            src="resources/images/icons/cross.png" alt="Delete" />
                                    </a>
                                    <!-- 选择相应职工的角色-->
                                    <a  href="#"  title="Edit"  onclick=""><img
                                            src="resources/images/icons/pencil.png" alt="Edit" />
                                    </a>

                                   <!-- <a href="#" title="Edit Meta" onclick="open_roles_dialog();"><img
                                            src="resources/images/icons/hammer_scr ewdriver.png"
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
                                <select name="dropdown">
                                    <option value="option1">Choose an action...</option>
                                    <option value="option2">Edit</option>
                                    <option value="option3">Delete</option>
                                </select> <a class="mybutton" onclick="opemDialog();">新增员工</a>
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

<div id="dialog_div" style="display: none">
    <div class="content-box-content">
        <div class="tab-content default-tab" id="tab2">
            <form action="${pageContext.request.getContextPath()}/resc/insert" method="post">
                <fieldset>
                    <!-- Set class to "column-left" or "column-right" on fieldsets to divide the form into columns -->
                    <p>
                        <label>权限名称</label>
                        <input class="text-input small-input" type="text" id="rname_id"
                               name="rname" />
                    </p>
                    <p>
                        <label>选择父权限</label>
                        <button  id="select_resc_id" class="mybutton" type="button" onclick="select_parent_resc();">无</button>
                        <input type="hidden" id="pid" name="pid" value="-1"/>

                    </p>

                    <p>
                        <label>权限路径</label>
                        <input class="text-input small-input" type="text" id="rpath_id"
                               name="rpath" />

                    </p>
                    <p>
                        <label>部门描述</label>
                        <textarea class="text-input textarea wysiwyg" id="rdesc_id"
                                  name="rdesc" cols="60" rows="12"></textarea>
                    </p>
                    <p>
                        <label>权限类型</label>
                        <span id="rstate_id">一级权限</span>
                        <input id="rstate_id_hidden" name="rstate" value="1" type="hidden">
                    </p>
                    <p>
                        <input class="mybutton" type="submit" value="提交" />
                    </p>
                </fieldset>
                <div class="clear"></div>
                <!-- End .clear -->
            </form>
        </div>
        <!-- End #tab2 -->
    </div>
    <!-- End .content-box-content -->
</div>


<div id="ztree_dialog" style="display: none">
    <div id="ztree" class="ztree">

    </div>
</div>




</body>
</html>
