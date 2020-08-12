<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <style>
        /* 表格区 */
        .result-box {
            width: 100%;
            margin-top: 10px;
            background: #eee;
            font-style: normal;
            color: rgb(0, 0, 0);
            font-weight: bolder;
        }

        .result-box table {
            width: 100%;
            font-weight: 200;
            font-size: 16px;
            text-align: center;
            padding: 0;
            border-right: 1px solid #ddd;
            border-bottom: 1px solid #ddd;
        }

        .result-box tr {
            height: 30px;
        }

        .result-box th, td {
            border-left: 2px solid #ddd;
            border-top: 2px solid #ddd;
        }

        .result-box tbody tr {
            background: #fff;
        }

        body a {
            color: #03515d;
            text-decoration: none;
        }

        body button {
            color: #03515d;
        }

        body span {
            color: #03515d;
        }

        .center_bottom input {
            color: #03515d;
            font-size: 12px;
            height: 20px;
            width: 40px;
            padding: 2px;
            vertical-align: middle;
            text-align: center;
            margin-bottom: 6px;
        }

        .table_div {
            width: 100%;
            padding: 10px;
            margin: 0 auto;
        }

        .center_center {
            height: 400px;
            width: 100%;
            float: left;
        }

        .center_bottom {
            background: url("<%=request.getContextPath()%>/static/image/cb.gif") repeat-x;
            height: 35px;
            width: 100%;
            float: left;
            line-height: 35px;
        }

        .table_content {
            margin: 5px;
            border: 1px solid #B5D6E6;
            width: 100%;
            height: 390px;
            overflow-x: hidden;
            overflow-y: auto;
        }

        .table_content table {
            width: 100%;
            border: 0px;
            border-collapse: collapse;
            font-size: 16px;
        }

        .table_content table tr:hover {
            text-align: center;
            background-color: #C1EBFF;
        }

        .table_content table th {
            text-align: center;
            border-collapse: collapse;
            height: 22px;
            background: url("<%=request.getContextPath()%>/static/image/tb.gif");
            border-right: 1px solid #B5D6E6;
            border-bottom: 1px solid #B5D6E6;
        }

        . table_content table td {
            height: 22px;
            word-wrap: break-word;
            max-width: 200px;
            text-align: center;
            vertical-align: middle;
            border-right: 3px solid #B5D6E6;
            border-bottom: 3px solid #B5D6E6;
        }

        .a {
            font-family: SimHei;
            font-size: 16px;
            text-align: center;
            background: url("<%=request.getContextPath()%>/static/image/top.gif") repeat-x;
            height: 30px;
            line-height: 30px;
            width: 100%;
        }
    </style>
    <title>编辑用户信息</title>
</head>

<body>
<a style="font: bolder">当前用户：${user_session.username}</a><br/><br/>
<span>&nbsp;&nbsp;<a style="color: blue" href="${pageContext.request.contextPath}/user/logout.do">退出</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
</span>
<div style="float:right;padding-right:30px">
    <a style="color: blue;float: right;padding-right: 30px" href="${pageContext.request.contextPath}/user/switch.do">切换用户</a>
</div>
<a style="color: blue" href="${pageContext.request.contextPath}/admin/list.do">我的信息</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<a style="color: blue" href="${pageContext.request.contextPath}/admin/listAllUser.do">所有用户信息</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<a style="color: blue" href="${pageContext.request.contextPath}/admin/add.do">新增用户信息</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<div class="result-box">
    <!-- 静态展示的表格 -->
    <div class="table_div">
        <div class="a">
            <span style="font-weight:bold" st>你当前的位置</span>：[业务中心]-[员工信息]
        </div>
        <form id="UserForm" action="${pageContext.request.contextPath}/admin/update.do" method="post">
            <div class="center_center">
                <div class="table_content">
                    <table border="10px" cellspacing="2px" cellpadding=2px">
                        <thead>
                        <tr>
                            <th>姓名</th>
                            <th>密码</th>
                            <th>性别</th>
                            <th>邮箱</th>
                            <th>电话</th>
                            <th>考勤</th>
                            <th>编辑</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td width="12%">
                                <input type="hidden" name="id" value="${user.id}">
                                <input type="text" name="username" value="${user.username}"
                                       style="width: 100%; height: 100%"></td>
                            <td width="12%"><input type="text" name="password" value="${user.password}"
                                                   style="width: 100%; height: 100%"></td>
                            <td width="12%"><input type="text" name="gender" value="${user.gender}"
                                                   style="width: 100%; height: 100%"></td>
                            <td width="12%"><input type="text" name="email" value="${user.email}"
                                                   style="width: 100%; height: 100%"></td>
                            <td width="12%"><input type="text" name="phone" value="${user.phone}"
                                                   style="width: 100%; height: 100%"></td>
                            <td width="12%"><input type="text" name="attendance" value="${user.attendance}"
                                                   style="width: 100%; height: 100%"></td>
                            <td width="16%" style="border-right:none"><span style="color: red">无</span></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="center_bottom">
                <span>&nbsp;&nbsp;共有 1 条记录，当前第 1 页</span>
                <div style="float:right;padding-right:30px">
                    <input type="submit" value="提交" style="width: 100%; height: 100%">
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>



