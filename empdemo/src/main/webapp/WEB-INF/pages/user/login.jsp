<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>login</title>
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

        .sign-check {
            margin: 4px;
            background: #b090a0;
            color: #000000;
            border-radius: 44px;
            cursor: pointer;
            transition: 0.8s;
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
        <h2 style="color: red;text-align: center">${msg}</h2>
        <h1>请登录</h1>
        <input class="sign-text" name="username" type="text" placeholder="用户名"/>
        <input class="sign-text" name="password" type="password" placeholder="密码"/>
        <input class="sign-text" name="gender" type="text" placeholder="性别"/>
        <table>
            <tbody>
            <tr>
                <td>
                    <input class="sign-text" type="text" required="required" id="Yzm"/>
                </td>
                <td>
                    <input class="sign-check " type="button" id="code" value="验证码" onclick="createCode()"/>
                </td>
            </tr>
            </tbody>
        </table>
        <input class="sign-btn" type="submit" id="loginBtn" value="提交">
        <a href="${pageContext.request.contextPath}/user/register.do">注册</a>
    </form>
</div>
<script>
    // 在全局定义验证码
    let code
    // 产生验证码函数
    let createCode = () => {
        code = ''
        let codeLength = 4 // 验证码的长度
        let checkCode = document.getElementById('code')
        // 随机数
        let random = [
            0,
            1,
            2,
            3,
            4,
            5,
            6,
            7,
            8,
            9,
            'A',
            'B',
            'C',
            'D',
            'E',
            'F',
            'G',
            'H',
            'I',
            'J',
            'K',
            'L',
            'M',
            'N',
            'O',
            'P',
            'Q',
            'R',
            'S',
            'T',
            'U',
            'V',
            'W',
            'X',
            'Y',
            'Z'
        ]
        for (let i = 0; i < codeLength; i++) {
            // 循环操作
            let index = Math.floor(Math.random() * 36) // 取得随机数的索引（0~35）
            code += random[index] // 根据索引取得随机数加到code上
        }
        checkCode.value = code // 把code值赋给验证码
    }
    // 网页一刷新就刷新验证码
    createCode()
    // 验证码校验函数
    let validate = () => {
        let inputCode = document.getElementById('Yzm').value.toUpperCase() // 取得输入的验证码并转化为大写
        if (inputCode.length <= 0) {
            // 若输入的验证码长度为0
            alert('请输入验证码！') // 则弹出请输入验证码
            $('#Yzm').focus() // 重新聚焦验证码框
            YZM = false
        } else if (inputCode != code) {
            // 若输入的验证码与产生的验证码不一致时
            alert('验证码输入错误！@_@') // 则弹出验证码输入错误
            createCode() // 刷新验证码
            $('#Yzm').val('') // 清空文本框
            $('#Yzm').focus() // 重新聚焦验证码框
            YZM = false
        } else {
            // 输入正确时
            $('#Yzm').blur() // 绑定验证码输入正确时要做的事
            YZM = true
            alert('验证码输入正确！@_@')
        }
    }
    // 校验验证码
    document.getElementById('Yzm').addEventListener('change', validate)
</script>
</body>
</html>