<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户注册</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <![endif]-->
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath()%>/resources/js/jquery.jcryption.3.1.0.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#register_form").submit(function () {
                var encrypt = new JSEncrypt();
                var publickKey = "${publicKey}";
                if ($('#password') != null && $('#password') != undefined) {
                    encrypt.setPublicKey(publickKey);
                    var encryptedPasswd = encrypt.encrypt($('#password').val());
                    $('#password').val(encryptedPasswd);
                } else {
                    alert("password can not be empty");
                }
            });
        });
    </script>
</head>
<body>
<div class="container">
    <h1>注册</h1>
    <hr/>
    <form:form action="/register/register" method="post" id="register_form" commandName="user" role="form">
        <div class="form-group">
            <label for="nickname">别名:</label>
            <input type="text" class="form-control" id="nickname" name="nickname" placeholder="请输入别名"/>
        </div>
        <div class="form-group">
            <label for="password">用户名:</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名"/>
        </div>
        <div class="form-group">
            <label for="password">密码:</label>
            <input type="text" class="form-control" id="password" name="password" placeholder="请输入密码"/>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">提交</button>
        </div>
    </form:form>
</div>


</body>
</html>