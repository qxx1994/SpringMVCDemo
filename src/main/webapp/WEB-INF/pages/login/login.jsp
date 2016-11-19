<%--
  Created by IntelliJ IDEA.
  User: 24015
  Date: 2016/11/4
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆界面</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath()%>/resources/js/jquery.jcryption.3.1.0.js"></script>
    <script type="text/javascript">
        $(function () {

            $("#login_form").submit(function () {
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
<form class="form-horizontal" role="form" id="login_form" action="<%= request.getContextPath() %>/login"
      commandName="user" method="post">
    <div class="form-group">
        <label for="username" class="col-sm-2 control-label">用户名</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
        </div>
    </div>
    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">登录</button>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <a href="<%= request.getContextPath() %>/register">注册</a>
        </div>
    </div>
</form>

</body>
</html>
