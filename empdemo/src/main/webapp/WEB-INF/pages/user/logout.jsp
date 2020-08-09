<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>form</title>
    <style>

        body {
            margin: 0;
            padding: 0;
            background: #2e6cb0;
        }

        .sign-div {
            width: 300px;
            padding: 20px;
            text-align: center;
            background: url(bg02.jpg);
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            overflow: hidden;
        }

        .sign-div h1 {
            margin-top: 100px;
            color: #fff;
            font-size: 40px;
        }

        .sign-div input {
            display: block;
            width: 100%;
            padding: 0 16px;
            height: 44px;
            text-align: center;
            box-sizing: border-box;
            outline: none;
            border: none;
            font-family: "montserrat", sans-serif;
        }

        .sign-text {
            margin: 4px;
            background: rgba(255, 255, 255, 5);
            border-radius: 6px;
        }

        .sign-btn {
            margin-top: 50px;
            margin-bottom: 20px;
            background: #11a1b0;
            color: #fff;
            border-radius: 44px;
            cursor: pointer;
            transition: 0.8s;
        }

        .sign-btn:hover {
            transform: scale(0.96);
        }

        .sign-div a {
            text-decoration: none;
            color: #fff;
            font-family: "montserrat", sans-serif;
            font-size: 14px;
            padding: 10px;
            transition: 0.8s;
            display: block;
        }

        .sign-div a:hover {
            background: rgba(0, 0, 0, .3);
        }
    </style>
</head>
<body>

<!-- 一个典型的屏幕居中box -->
<div class="sign-div">
    <!-- 表单form数据提交方式 -->
    <form id="loginForm" name="loginForm" action="/user/login.do" method="post">
        <h1>欢迎下次光临！</h1>
    </form>
</div>
</body>
</html>